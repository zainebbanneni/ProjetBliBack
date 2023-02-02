package com.example.crud.authentification.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.authentification.models.ERole;
import com.example.crud.authentification.models.Role;
import com.example.crud.authentification.models.User;
import com.example.crud.authentification.payload.request.LoginRequest;
import com.example.crud.authentification.payload.request.SignupRequest;
import com.example.crud.authentification.payload.response.JwtResponse;
import com.example.crud.authentification.payload.response.MessageResponse;
import com.example.crud.authentification.repository.RoleRepository;
import com.example.crud.authentification.repository.UserRepository;
import com.example.crud.authentification.security.jwt.JwtUtils;
import com.example.crud.authentification.security.services.UserDetailsImpl;
import com.example.crud.entities.Collaborateur;
import com.example.crud.repository.CollaborateurRepository;





@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	CollaborateurRepository collaborateurRepository;
	
	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());

		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getEmail(), 
												 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: CUID is already taken!"));
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(), 
							 signUpRequest.getEmail(),
							 encoder.encode(signUpRequest.getPassword()));
		Collaborateur collaborateur= new Collaborateur(signUpRequest.getUsername(), signUpRequest.getNom(), signUpRequest.getPrenom(), signUpRequest.getId_equipe());

		Set<String> strRoles = signUpRequest.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "prod":
					Role prodRole = roleRepository.findByName(ERole.ROLE_PRODUCTEUR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(prodRole);

					break;
				case "pilo":
					Role piloRole = roleRepository.findByName(ERole.ROLE_PILOTE)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(piloRole);

					break;
				case "dir":
					Role dirRole = roleRepository.findByName(ERole.ROLE_DIRECTION)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(dirRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
		}

		user.setRoles(roles);
		userRepository.save(user);
		collaborateurRepository.save(collaborateur);
		

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	
	

}
