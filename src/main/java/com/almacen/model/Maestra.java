package com.almacen.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ALM_MAESTRA database table.
 * 
 */
@Entity
@Table(name = "ALM_MAESTRA")
public class Maestra implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ALM_MAESTRA_MAECODIGO_GENERATOR", sequenceName = "SQ_ALM_MAESTRA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALM_MAESTRA_MAECODIGO_GENERATOR")
    @Column(name = "MAE_CODIGO")
    private Long maeCodigo;

    @Column(name = "MAE_DESLAR")
    private String maeDeslar;

    @Column(name = "MAE_ESPECIF")
    private String maeEspecif;

    @Column(name = "MAE_ESTADO")
    private String maeEstado;

    @Column(name = "MAE_MONTO")
    private BigDecimal maeMonto;

    @Column(name = "MAE_SALINI")
    private Long maeSalini;

    @Column(name = "MAE_STOCK")
    private Long maeStock;

    @Column(name = "MAE_UNIDAD")
    private String maeUnidad;

    // bi-directional many-to-one association to Marca
    @ManyToOne
    @JoinColumn(name = "MAR_MARCA")
    private Marca almMarca;

    // bi-directional many-to-one association to Proveedor
    @ManyToOne
    @JoinColumn(name = "PRV_CODIGO")
    private Proveedor almProveedor;

    // bi-directional many-to-one association to Unidades
    @ManyToOne
    @JoinColumn(name = "UNI_CODIGO")
    private Unidad almUnidade;

    public Long getMaeCodigo() {
        return this.maeCodigo;
    }

    public void setMaeCodigo(Long maeCodigo) {
        this.maeCodigo = maeCodigo;
    }

    public String getMaeDeslar() {
        return this.maeDeslar;
    }

    public void setMaeDeslar(String maeDeslar) {
        this.maeDeslar = maeDeslar;
    }

    public String getMaeEspecif() {
        return this.maeEspecif;
    }

    public void setMaeEspecif(String maeEspecif) {
        this.maeEspecif = maeEspecif;
    }

    public String getMaeEstado() {
        return this.maeEstado;
    }

    public void setMaeEstado(String maeEstado) {
        this.maeEstado = maeEstado;
    }

    public BigDecimal getMaeMonto() {
        return this.maeMonto;
    }

    public void setMaeMonto(BigDecimal maeMonto) {
        this.maeMonto = maeMonto;
    }

    public Long getMaeSalini() {
        return this.maeSalini;
    }

    public void setMaeSalini(Long maeSalini) {
        this.maeSalini = maeSalini;
    }

    public Long getMaeStock() {
        return this.maeStock;
    }

    public void setMaeStock(Long maeStock) {
        this.maeStock = maeStock;
    }

    public String getMaeUnidad() {
        return this.maeUnidad;
    }

    public void setMaeUnidad(String maeUnidad) {
        this.maeUnidad = maeUnidad;
    }

    public Marca getAlmMarca() {
        return this.almMarca;
    }

    public void setAlmMarca(Marca almMarca) {
        this.almMarca = almMarca;
    }

    public Proveedor getAlmProveedor() {
        return this.almProveedor;
    }

    public void setAlmProveedor(Proveedor almProveedor) {
        this.almProveedor = almProveedor;
    }

    public Unidad getAlmUnidade() {
        return this.almUnidade;
    }

    public void setAlmUnidade(Unidad almUnidade) {
        this.almUnidade = almUnidade;
    }

}