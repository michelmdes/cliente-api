package com.builders.cliente.resources;

import com.builders.cliente.domain.Genero;
import com.builders.cliente.services.GeneroService;
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
@RequestMapping(value="/generos")
@Api(value = "Genero", description = "Recursos disponíveis para o domínio Genero")
public class GeneroResource {
	
	@Autowired
	private GeneroService service;

	@GetMapping
	@ApiOperation(value = "Lista todos os Generos")
	public ResponseEntity<List<Genero>> findAll() {
		List<Genero> clienteList = service.findAll();
		return ResponseEntity.ok().body(clienteList);
	}

	@GetMapping(value="/{id}")
	@ApiOperation(value = "Busca genero por ID")
	public ResponseEntity<Genero> findById(@PathVariable Integer id) {
		Genero obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ApiOperation(value = "Inclui um novo Genero")
	public ResponseEntity<Void> insert(@Valid @RequestBody Genero genero) {
		genero = service.insert(genero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(genero.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Edita um Genero")
	public ResponseEntity<Void> update(@PathVariable Integer id, @Valid @RequestBody Genero genero) {
		service.update(id, genero);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Exclui um Genero por ID")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
