package com.example.crud.authentification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.authentification.models.ERole;
import com.example.crud.authentification.models.Role;





public interface RoleRepository extends JpaRepository<Role, Long>{
	  Optional<Role> findByName(ERole name);


}
