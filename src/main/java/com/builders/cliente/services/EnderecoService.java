package com.builders.cliente.services;

import com.builders.cliente.domain.Cidade;
import com.builders.cliente.domain.Endereco;
import com.builders.cliente.repositories.EnderecoRepository;
import com.builders.cliente.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnderecoService extends GenericService<Endereco, Long> {
	
	@Autowired
	private EnderecoRepository repo;

	@Override
	public EnderecoRepository getRepository() {
		return repo;
	}

	public List<Endereco> findByClienteId(Long idCliente) {
		return repo.findEnderecosByCliente_Id(idCliente);
	}

	@Transactional
	public void deleteByIdAndClienteId(Long id, Long idCliente) {
		repo.deleteByIdAndCliente_Id(id, idCliente);
	}

	@Override
	protected void updateData(Endereco currentObj, Endereco newObj) {
		currentObj.setLogradouro(newObj.getLogradouro());
		currentObj.setNumero(newObj.getNumero());
		currentObj.setComplemento(newObj.getComplemento());
		currentObj.setBairro(newObj.getBairro());
		currentObj.setCep(newObj.getCep());
		currentObj.setDescricao(newObj.getDescricao());
		if (newObj.getCidade() != null && newObj.getCidade().getId() != null)
			currentObj.setCidade(new Cidade(newObj.getCidade().getId()));
	}

	@Override
	protected void prepareDataBeforeSaving(Endereco endereco) {
		endereco.setCep(StringUtils.retiraMascara(endereco.getCep()));
	}

}
