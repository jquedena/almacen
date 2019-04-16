package com.almacen.controllers;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.dto.DataTableDTO;
import com.almacen.dto.in.MaestraInDTO;
import com.almacen.dto.out.MaestraOutDTO;
import com.almacen.service.MaestraService;

@RestController
public class MaestraController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MaestraController.class);

    @Autowired
    private MaestraService maestraService;

    @GetMapping(value = "/servicios/productos")
    public ResponseEntity<DataTableDTO<MaestraOutDTO>> listarProductos(@RequestParam MultiValueMap<String, String> params) {
        LOGGER.info("{}", params);
        int page = Integer.parseInt(params.getFirst("start")) / 10;
        MaestraInDTO in = new MaestraInDTO();
        in.setMaeCodigo(Long.valueOf(params.getFirst("maeCodigo")));
        in.setMaeDeslar(params.getFirst("maeDeslar"));
        in.setAlmMarca(Long.valueOf(params.getFirst("almMarca")));
        DataTableDTO<MaestraOutDTO> response = maestraService.buscar(in, page);
        response.setDraw(params.getFirst("draw"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping(value = "/servicios/producto")
    public ResponseEntity<MaestraOutDTO> insertarProducto(@Valid @RequestBody MaestraInDTO maestra) {
        return new ResponseEntity<>(maestraService.insertar(maestra), HttpStatus.CREATED);
    }

}
