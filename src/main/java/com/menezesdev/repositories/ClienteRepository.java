package com.menezesdev.repositories;

import com.menezesdev.models.Categoria;
import com.menezesdev.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Serializable> {

}
