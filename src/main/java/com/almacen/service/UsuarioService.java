package com.almacen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.dto.UsuarioDTO;
import com.almacen.model.Usuario;
import com.almacen.repository.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String nombreUsuario) {
        Usuario usuario = usuarioRepository
            .findByNombreUsuario(nombreUsuario)
            .orElseThrow(()->new UsernameNotFoundException("Usuario no registro"));
        return new UsuarioDTO(usuario);
    }

}
