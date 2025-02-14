package com.devcaio.crudclientes.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devcaio.crudclientes.domain.entities.Cliente;
import com.devcaio.crudclientes.dtos.ClienteRequestDTO;
import com.devcaio.crudclientes.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteController {
	
	private final ClienteService service;

	public ClienteController(ClienteService service) {
		this.service = service;
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody ClienteRequestDTO dto) {
		Cliente cliente = service.insert(dto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(cliente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id) {
		Cliente cliente = service.findById(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> clientes = service.findAll();
		return ResponseEntity.ok().body(clientes);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<Cliente> update(@PathVariable Long id, @RequestBody ClienteRequestDTO dto) {
		Cliente cliente = service.update(id, dto);
		return ResponseEntity.ok().body(cliente);
	}
	
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
