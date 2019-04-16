package com.almacen.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.dto.out.UnidadOutDTO;
import com.almacen.model.Unidad;
import com.almacen.repository.UnidadRepository;

@Service
public class UnidadService {

    @Autowired
    private UnidadRepository unidadRepository;

    @Transactional(readOnly = true)
    public List<UnidadOutDTO> buscarTodos() {
        List<Unidad> marcas = unidadRepository.findAll();
        return marcas
            .stream()
            .map(UnidadOutDTO::new)
            .collect(Collectors.toList());
    }
}
