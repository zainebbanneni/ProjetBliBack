package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud.entities.BPU;

@Repository
public interface BPURepository extends JpaRepository<BPU, Long > {
	

}
