package com.almacen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.almacen.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
