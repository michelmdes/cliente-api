package com.builders.cliente.resources;

import com.builders.cliente.domain.Cidade;
import com.builders.cliente.services.CidadeService;
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
@RequestMapping(value="/cidades")
@Api(value = "Cidade", description = "Recursos disponíveis para o domínio Cidade")
public class CidadeResource {
	
	@Autowired
	private CidadeService service;

	/*@GetMapping
	@ApiOperation(value = "Lista todos os Clientes paginados")
	public ResponseEntity<Page<Cidade>> findAll(
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="size", defaultValue="10") Integer size,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Cidade> list = service.findPage(PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy));
		return ResponseEntity.ok().body(list);
	}*/

	@GetMapping(value = "/filtro")
	@ApiOperation(value = "Filtrar Cidades paginadas")
	public ResponseEntity<Page<Cidade>> findByFilter(
			@RequestParam(value="nome", required = false) String nome,
			@RequestParam(value="idEstado", required = false) Long idEstado,
			@RequestParam(value="page", defaultValue="0") Integer page,
			@RequestParam(value="size", defaultValue="10") Integer size,
			@RequestParam(value="orderBy", defaultValue="id") String orderBy,
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		PageRequest pageRequest = PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);
		Page<Cidade> list = service.findByFilter(nome, idEstado, pageRequest);
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value="/{id}")
	@ApiOperation(value = "Busca cidade por ID")
	public ResponseEntity<Cidade> findById(@PathVariable Long id) {
		Cidade obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	@ApiOperation(value = "Inclui um novo Cidade")
	public ResponseEntity<Void> insert(@Valid @RequestBody Cidade cidade) {
		cidade = service.insert(cidade);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cidade.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@PutMapping(value="/{id}")
	@ApiOperation(value = "Edita um Cidade")
	public ResponseEntity<Void> update(@PathVariable Long id, @Valid @RequestBody Cidade cidade) {
		service.update(id, cidade);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation(value = "Exclui um Cidade por ID")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
