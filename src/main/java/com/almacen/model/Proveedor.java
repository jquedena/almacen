package com.almacen.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * The persistent class for the ALM_PROVEEDOR database table.
 * 
 */
@Entity
@Table(name = "ALM_PROVEEDOR")
public class Proveedor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "ALM_PROVEEDOR_PRVCODIGO_GENERATOR", sequenceName = "SQ_ALM_PROVEEDOR")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ALM_PROVEEDOR_PRVCODIGO_GENERATOR")
    @Column(name = "PRV_CODIGO")
    private Long prvCodigo;

    @Column(name = "PRV_CONTACTO")
    private String prvContacto;

    @Column(name = "PRV_DIRECCION")
    private String prvDireccion;

    @Column(name = "PRV_NOMBRE")
    private String prvNombre;

    @Column(name = "PRV_RUC")
    private String prvRuc;

    @Column(name = "PRV_TELEFONO")
    private String prvTelefono;

    // bi-directional many-to-one association to Maestra
    @OneToMany(mappedBy = "almProveedor")
    private List<Maestra> almMaestras;

    public Long getPrvCodigo() {
        return this.prvCodigo;
    }

    public void setPrvCodigo(Long prvCodigo) {
        this.prvCodigo = prvCodigo;
    }

    public String getPrvContacto() {
        return this.prvContacto;
    }

    public void setPrvContacto(String prvContacto) {
        this.prvContacto = prvContacto;
    }

    public String getPrvDireccion() {
        return this.prvDireccion;
    }

    public void setPrvDireccion(String prvDireccion) {
        this.prvDireccion = prvDireccion;
    }

    public String getPrvNombre() {
        return this.prvNombre;
    }

    public void setPrvNombre(String prvNombre) {
        this.prvNombre = prvNombre;
    }

    public String getPrvRuc() {
        return this.prvRuc;
    }

    public void setPrvRuc(String prvRuc) {
        this.prvRuc = prvRuc;
    }

    public String getPrvTelefono() {
        return this.prvTelefono;
    }

    public void setPrvTelefono(String prvTelefono) {
        this.prvTelefono = prvTelefono;
    }

    public List<Maestra> getAlmMaestras() {
        return this.almMaestras;
    }

    public void setAlmMaestras(List<Maestra> almMaestras) {
        this.almMaestras = almMaestras;
    }

    public Maestra addAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().add(almMaestra);
        almMaestra.setAlmProveedor(this);

        return almMaestra;
    }

    public Maestra removeAlmMaestra(Maestra almMaestra) {
        getAlmMaestras().remove(almMaestra);
        almMaestra.setAlmProveedor(null);

        return almMaestra;
    }

}