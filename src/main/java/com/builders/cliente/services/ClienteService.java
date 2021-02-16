package com.builders.cliente.services;

import com.builders.cliente.domain.Cliente;
import com.builders.cliente.repositories.ClienteRepository;
import com.builders.cliente.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ClienteService extends GenericService<Cliente, Long> {
	
	@Autowired
	private ClienteRepository repo;

	@Override
	public ClienteRepository getRepository() {
		return repo;
	}

	public Page<Cliente> findByFilter(String nome, String cpf, String rg, String email, String telefone, Integer genero, PageRequest pageRequest) {
		return repo.findByFilter(StringUtils.upper(nome),
				StringUtils.retiraMascara(cpf),
				StringUtils.retiraMascara(rg),
				email,
				StringUtils.retiraMascara(telefone),
				genero,
				pageRequest);
	}

	@Override
	protected void updateData(Cliente currentObj, Cliente newObj) {
		currentObj.setNome(newObj.getNome());
		currentObj.setDataNascimento(newObj.getDataNascimento());
		currentObj.setEmail(newObj.getEmail());
		currentObj.setCpf(newObj.getCpf());
		currentObj.setRg(newObj.getRg());
		currentObj.setTelefone(newObj.getTelefone());
		currentObj.setGenero(newObj.getGenero());
	}

	@Override
	protected void prepareDataBeforeSaving(Cliente cliente) {
		cliente.setRg(StringUtils.retiraMascara(cliente.getRg()));
		cliente.setCpf(StringUtils.retiraMascara(cliente.getCpf()));
		cliente.setTelefone(StringUtils.retiraMascara(cliente.getTelefone()));
	}

}
