package com.almacen.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.almacen.dto.out.MarcaOutDTO;
import com.almacen.model.Marca;
import com.almacen.repository.MarcaRepository;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    @Transactional(readOnly = true)
    public List<MarcaOutDTO> buscarTodos() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas
            .stream()
            .map(MarcaOutDTO::new)
            .collect(Collectors.toList());
    }
}
