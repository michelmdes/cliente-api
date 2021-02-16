package com.builders.cliente.resources;

import com.builders.cliente.domain.Estado;
import com.builders.cliente.services.EstadoService;
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

@RestController
@RequestMapping(value="/estados")
@Api(value = "Estado", description = "Recursos disponíveis para o domínio Estado")
public class EstadoResource {
	
	@Autowired
	private EstadoService service;

	/*@GetMapping
	@ApiOperation(value = "Lista todos os Estados")
	public ResponseEntity<List<Estado>> findAll() {
		List<Estado> clienteList = service.findAll();
		return ResponseEntity.ok().body(clienteList);
	}*/

	@GetMapping(value = "/filtro")
	@ApiOperation(value = "Lista todos os Clientes paginados")
	public ResponseEntity<Page<Estado>> findByFilter(
			@RequestParam(value="nome", required = false) String nome,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="size", defaultValue="10") Integer size,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Estado> list = service.findByFilter(nome, PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy));
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value="/{id}")
	@ApiOperation(value = "Busca estado por ID")
	public ResponseEntity<Estado> findById(@PathVariable Long id) {
		Estado obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ApiOperation(value = "Inclui um novo Estado")
	public ResponseEntity<Void> insert(@Valid @RequestBody Estado estado) {
		estado = service.insert(estado);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Edita um Estado")
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Estado estado) {
		service.update(id, estado);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Exclui um Estado por ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
