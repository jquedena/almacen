package com.almacen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.model.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, String> {

}
