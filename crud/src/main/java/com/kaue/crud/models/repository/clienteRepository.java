package com.kaue.crud.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.kaue.crud.models.entidade.cliente;

public interface clienteRepository extends JpaRepository<cliente, Integer>{

    
}
