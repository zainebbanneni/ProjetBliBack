package com.example.crud.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.crud.entities.ESIMB;
import com.example.crud.repository.ESIMBRepository;

@org.springframework.stereotype.Service
public class Service implements ServiceInterface {
	@Autowired
	ESIMBRepository ESIMBRepo;
	
	
	@Override
	public boolean isExisteEsimb(ESIMB esimb) {
		List<ESIMB> esimbs= new ArrayList<ESIMB>();
		ESIMBRepo.findByCodeIMB(esimb.getCodeIMB()).forEach(esimbs::add);
		System.out.println("size="+esimbs.size());
		if(esimbs.size() > 0) {
			for(int i =0;i<esimbs.size();i++) {
				System.out.println("esimb="+esimbs.get(i).toString());
				System.out.println("esimbbanbou="+esimbs.get(i).getCodeBanbou());
				System.out.println("esimbparam="+esimb.getCodeBanbou());
				if (esimbs.get(i).getCodeBanbou().equals(esimb.getCodeBanbou()) ) {
					return true;
				}
			}
		}
		return false;
	}

}
