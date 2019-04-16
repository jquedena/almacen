package com.almacen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.out.MarcaOutDTO;
import com.almacen.service.MarcaService;

@RestController
public class MarcaController {

    @Autowired
    private MarcaService marcaService;

    @GetMapping(value = "/servicios/marcas")
    public ResponseEntity<DataTableDTO<MarcaOutDTO>> listarProductos(@RequestParam MultiValueMap<String, String> params) {
        DataTableDTO<MarcaOutDTO> response = new DataTableDTO<>();
        response.setData(marcaService.buscarTodos());
        response.setDraw("1");
        response.setRecordsFiltered(response.getData().size());
        response.setRecordsTotal(response.getData().size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
