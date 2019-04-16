/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.almacen.dto.in;

import com.almacen.model.Maestra;
import com.almacen.model.Marca;
import com.almacen.model.Proveedor;
import com.almacen.model.Unidad;

import java.math.BigDecimal;

/**
 *
 * @author Estudiante
 */
public class MaestraInDTO {
    
    private Maestra maestra = new Maestra();

    public void setMaeCodigo(Long maeCodigo) {
        maestra.setMaeCodigo(maeCodigo);
    }

    public void setMaeDeslar(String maeDeslar) {
        maestra.setMaeDeslar(maeDeslar);
    }

    public void setMaeEspecif(String maeEspecif) {
        maestra.setMaeEspecif(maeEspecif);
    }

    public void setMaeEstado(String maeEstado) {
        maestra.setMaeEstado(maeEstado);
    }

    public void setMaeMonto(BigDecimal maeMonto) {
        maestra.setMaeMonto(maeMonto);
    }

    public void setMaeSalini(Long maeSalini) {
        maestra.setMaeSalini(maeSalini);
    }

    public void setMaeStock(Long maeStock) {
        maestra.setMaeStock(maeStock);
    }

    public void setMaeUnidad(String maeUnidad) {
        maestra.setMaeUnidad(maeUnidad);
    }

    public void setAlmUnidad(String almUnidad) {
        maestra.setAlmUnidade(new Unidad());
        maestra.getAlmUnidade().setUniCodigo(almUnidad);
    }

    public void setAlmMarca(Long almMarca) {
        maestra.setAlmMarca(new Marca());
        maestra.getAlmMarca().setMarMarca(almMarca);
    }

    public void setAlmProveedor(Long almProveedor) {
        maestra.setAlmProveedor(new Proveedor());
        maestra.getAlmProveedor().setPrvCodigo(almProveedor);
    }

    public Maestra getMaestra() {
        return maestra;
    }

}
