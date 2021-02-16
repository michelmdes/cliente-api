package com.builders.cliente.resources;

import com.builders.cliente.domain.Cliente;
import com.builders.cliente.domain.Genero;
import com.builders.cliente.services.ClienteService;
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
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value="/clientes")
@Api(value = "cliente", description = "Recursos disponíveis para o domínio Cliente")
public class ClienteResource {
	
	@Autowired
	private ClienteService service;

	/*@GetMapping
	@ApiOperation(value = "Lista todos os Clientes")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clienteList = service.findAll();
		return ResponseEntity.ok().body(clienteList);
	}*/

	@GetMapping(value="/{id}")
	@ApiOperation(value = "Busca clientes por ID")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@GetMapping
	@ApiOperation(value = "Lista todos os Clientes paginados")
	public ResponseEntity<Page<Cliente>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="size", defaultValue="10") Integer size,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Cliente> list = service.findPage(PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy));
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/filtro")
	@ApiOperation(value = "Filtrar Clientes paginados")
	public ResponseEntity<Page<Cliente>> findByFilter(
			@RequestParam(value="nome", required = false) String nome,
			@RequestParam(value="rg", required = false) String rg,
			@RequestParam(value="cpf", required = false) String cpf,
			@RequestParam(value="email", required = false) String email,
			@RequestParam(value="telefone", required = false) String telefone,
			@RequestParam(value="genero", required = false) Integer genero,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="size", defaultValue="10") Integer size,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
		Page<Cliente> list = service.findByFilter(nome, cpf, rg, email, telefone, genero, pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@PostMapping
	@ApiOperation(value = "Inclui um novo Cliente")
	public ResponseEntity<Void> insert(@Valid @RequestBody Cliente cliente) {
		cliente = service.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Edita um Cliente")
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
		service.update(id, cliente);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Exclui um Cliente por ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
