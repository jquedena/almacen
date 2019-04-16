package com.almacen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ALM_UNIDADES database table.
 * 
 */
@Entity
@Table(name = "ALM_UNIDADES")
public class Unidad implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UNI_CODIGO")
    private String uniCodigo;

    @Column(name = "UNI_DESLAR")
    private String uniDeslar;

    @Column(name = "UNI_ESTADO")
    private String uniEstado;

    // bi-directional many-to-one association to Maestra
    @OneToMany(mappedBy = "almUnidade")
    private List<Maestra> almMaestras;

    public String getUniCodigo() {
        return this.uniCodigo;
    }

    public void setUniCodigo(String uniCodigo) {
        this.uniCodigo = uniCodigo;
    }

    public String getUniDeslar() {
        return this.uniDeslar;
    }

    public void setUniDeslar(String uniDeslar) {
        this.uniDeslar = uniDeslar;
    }

    public String getUniEstado() {
        return this.uniEstado;
    }

    public void setUniEstado(String uniEstado) {
        this.uniEstado = uniEstado;
    }

    public List<Maestra> getAlmMaestras() {
        return this.almMaestras;
    }

    public void setAlmMaestras(List<Maestra> almMaestras) {
        this.almMaestras = almMaestras;
    }

    public Maestra addAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().add(almMaestra);
        almMaestra.setAlmUnidade(this);

        return almMaestra;
    }

    public Maestra removeAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().remove(almMaestra);
        almMaestra.setAlmUnidade(null);

        return almMaestra;
    }

}