package com.devcaio.crudclientes.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.devcaio.crudclientes.domain.entities.Cliente;
import com.devcaio.crudclientes.dtos.ClienteRequestDTO;
import com.devcaio.crudclientes.repositories.ClienteRepository;
import com.devcaio.crudclientes.services.exceptions.NotValidException;
import com.devcaio.crudclientes.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {

	private final ClienteRepository repository;

	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}

	public Cliente insert(ClienteRequestDTO dto) {
		Cliente cliente = dto.toCliente();
		if (cliente.getNome() == null || cliente.getNome().trim().isEmpty() || cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
			throw new NotValidException();
		}
		return repository.save(cliente);
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = repository.findById(id);
		return cliente.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}

	public Cliente update(Long id, ClienteRequestDTO dto) {
		try {
			Cliente cliente = repository.getReferenceById(id);
			if (cliente.getNome() == null || cliente.getNome().trim().isEmpty() || cliente.getEmail() == null || cliente.getEmail().trim().isEmpty()) {
				throw new NotValidException();
			}
			updateData(cliente, dto.toCliente());
			return repository.save(cliente);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	public Cliente updateData(Cliente cliente, Cliente clienteAtualizado) {
		cliente.setNome(clienteAtualizado.getNome());
		cliente.setEmail(clienteAtualizado.getEmail());
		return cliente;
	}

}
