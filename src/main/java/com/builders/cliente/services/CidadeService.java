package com.builders.cliente.services;

import com.builders.cliente.domain.Cidade;
import com.builders.cliente.repositories.CidadeRepository;
import com.builders.cliente.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class CidadeService extends GenericService<Cidade, Long> {
	
	@Autowired
	private CidadeRepository repo;

	@Override
	public CidadeRepository getRepository() {
		return repo;
	}

	public Page<Cidade> findByFilter(String nome, Long idEstado, PageRequest pageRequest) {
		return repo.findByFilter(StringUtils.upper(nome), idEstado, pageRequest);
	}

	@Override
	protected void updateData(Cidade currentObj, Cidade newObj) {
		currentObj.setNome(newObj.getNome());
		if (newObj.getEstado() != null && newObj.getEstado().getId() != null)
			currentObj.setEstado(newObj.getEstado());
	}

}
