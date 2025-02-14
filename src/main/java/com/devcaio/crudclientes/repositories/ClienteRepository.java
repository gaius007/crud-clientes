package com.devcaio.crudclientes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devcaio.crudclientes.domain.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
}
