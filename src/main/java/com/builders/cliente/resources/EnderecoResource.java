package com.builders.cliente.resources;

import com.builders.cliente.domain.Cliente;
import com.builders.cliente.domain.Endereco;
import com.builders.cliente.services.EnderecoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping
@Api(value = "Endereco", description = "Recursos disponíveis para o domínio Endereco")
public class EnderecoResource {
	
	@Autowired
	private EnderecoService service;

	@GetMapping(value = "/clientes/{idCliente}/enderecos")
	@ApiOperation(value = "Lista todos os Endereços de um Cliente")
	public ResponseEntity<List<Endereco>> findByClienteId(@PathVariable Long idCliente) {
		List<Endereco> clienteList = service.findByClienteId(idCliente);
		return ResponseEntity.ok().body(clienteList);
	}

	@PostMapping(value = "/clientes/{idCliente}/enderecos")
	@ApiOperation(value = "Inclui um novo Endereco")
	public ResponseEntity<Void> insert(@PathVariable Long idCliente, @Valid @RequestBody Endereco endereco) {
		endereco.setCliente(new Cliente(idCliente));
		endereco = service.insert(endereco);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(endereco.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/clientes/{idCliente}/enderecos/{id}")
	@ApiOperation(value = "Edita um Endereco")
	public ResponseEntity<Void> update(@PathVariable Long idCliente, @PathVariable Long id, @Valid @RequestBody Endereco endereco) {
		endereco.setCliente(new Cliente(idCliente));
		service.update(id, endereco);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/clientes/{idCliente}/enderecos/{id}")
	@ApiOperation(value = "Exclui um Endereco por ID")
	public ResponseEntity<Void> delete(@PathVariable Long idCliente, @PathVariable Long id) {
//		service.delete(id);
		service.deleteByIdAndClienteId(id, idCliente);
		return ResponseEntity.noContent().build();
	}

}
