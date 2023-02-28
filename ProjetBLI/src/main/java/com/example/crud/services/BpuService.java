package com.example.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import com.example.crud.entities.BPU;
import com.example.crud.exception.ResourceNotFoundException;
import com.example.crud.repository.BPURepository;

@Service
public class BpuService {
    private final BPURepository bpuRepository;

    public BpuService(BPURepository bpuRepository) {
        this.bpuRepository = bpuRepository;
    }

    public BPU updateBpu(Long id, BPU bpuToUpdate) throws ResourceNotFoundException {
        BPU bpu = bpuRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Bpu not found with id " + id));
        bpu.update(bpuToUpdate);
        return bpuRepository.save(bpu);
    }
    
}


