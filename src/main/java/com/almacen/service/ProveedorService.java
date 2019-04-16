package com.almacen.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.dto.out.ProveedorOutDTO;
import com.almacen.model.Proveedor;
import com.almacen.repository.ProveedorRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Transactional(readOnly = true)
    public List<ProveedorOutDTO> buscarTodos() {
        List<Proveedor> marcas = proveedorRepository.findAll();
        return marcas
            .stream()
            .map(ProveedorOutDTO::new)
            .collect(Collectors.toList());
    }
}
