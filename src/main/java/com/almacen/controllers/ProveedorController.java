package com.almacen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.out.ProveedorOutDTO;
import com.almacen.service.ProveedorService;

@RestController
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @GetMapping(value = "/servicios/proveedores")
    public ResponseEntity<DataTableDTO<ProveedorOutDTO>> listarProductos(@RequestParam MultiValueMap<String, String> params) {
        DataTableDTO<ProveedorOutDTO> response = new DataTableDTO<>();
        response.setData(proveedorService.buscarTodos());
        response.setDraw("1");
        response.setRecordsFiltered(response.getData().size());
        response.setRecordsTotal(response.getData().size());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
