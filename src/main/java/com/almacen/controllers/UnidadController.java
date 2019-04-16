package com.almacen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.out.UnidadOutDTO;
import com.almacen.service.UnidadService;

@RestController
public class UnidadController {

    @Autowired
    private UnidadService unidadService;

    @GetMapping(value = "/servicios/unidades")
    public ResponseEntity<DataTableDTO<UnidadOutDTO>> listarProductos(@RequestParam MultiValueMap<String, String> params) {
        DataTableDTO<UnidadOutDTO> response = new DataTableDTO<>();
        response.setData(unidadService.buscarTodos());
        response.setDraw("1");
        response.setRecordsFiltered(response.getData().size());
        response.setRecordsTotal(response.getData().size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
