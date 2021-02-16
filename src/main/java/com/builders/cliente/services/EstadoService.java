package com.builders.cliente.services;

import com.builders.cliente.domain.Estado;
import com.builders.cliente.repositories.EstadoRepository;
import com.builders.cliente.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class EstadoService extends GenericService<Estado, Long> {
	
	@Autowired
	private EstadoRepository repo;

	@Override
	public EstadoRepository getRepository() {
		return repo;
	}

	public Page<Estado> findByFilter(String nome, PageRequest pageRequest) {
		return repo.findByFilter(StringUtils.upper(nome), pageRequest);
	}

	@Override
	protected void updateData(Estado currentObj, Estado newObj) {
		currentObj.setNome(newObj.getNome());
	}

}
