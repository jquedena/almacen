package com.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.model.Marca;

public interface MarcaRepository extends JpaRepository<Marca, String> {

}
