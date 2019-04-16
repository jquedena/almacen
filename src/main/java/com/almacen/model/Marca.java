package com.almacen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the ALM_MARCA database table.
 * 
 */
@Entity
@Table(name = "ALM_MARCA")
public class Marca implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "MAR_MARCA")
    private Long marMarca;

    @Column(name = "MAR_DESLAR")
    private String marDeslar;

    @Column(name = "MAR_ESTADO")
    private String marEstado;

    // bi-directional many-to-one association to Maestra
    @OneToMany(mappedBy = "almMarca")
    private List<Maestra> almMaestras;

    public Long getMarMarca() {
        return this.marMarca;
    }

    public void setMarMarca(Long marMarca) {
        this.marMarca = marMarca;
    }

    public String getMarDeslar() {
        return this.marDeslar;
    }

    public void setMarDeslar(String marDeslar) {
        this.marDeslar = marDeslar;
    }

    public String getMarEstado() {
        return this.marEstado;
    }

    public void setMarEstado(String marEstado) {
        this.marEstado = marEstado;
    }

    public List<Maestra> getAlmMaestras() {
        return this.almMaestras;
    }

    public void setAlmMaestras(List<Maestra> almMaestras) {
        this.almMaestras = almMaestras;
    }

    public Maestra addAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().add(almMaestra);
        almMaestra.setAlmMarca(this);

        return almMaestra;
    }

    public Maestra removeAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().remove(almMaestra);
        almMaestra.setAlmMarca(null);

        return almMaestra;
    }

}