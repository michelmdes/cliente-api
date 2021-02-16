package com.builders.cliente.services;

import com.builders.cliente.domain.Genero;
import com.builders.cliente.repositories.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeneroService extends GenericService<Genero, Integer> {
	
	@Autowired
	private GeneroRepository repo;

	@Override
	public GeneroRepository getRepository() {
		return repo;
	}

	@Override
	protected void updateData(Genero currentObj, Genero newObj) {
		currentObj.setNome(newObj.getNome());
	}

}
