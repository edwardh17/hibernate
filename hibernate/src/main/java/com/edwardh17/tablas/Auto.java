package com.edwardh17.tablas;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "autos")
@NamedQueries({
    @NamedQuery(
            name = "obtenerAutosCaros",
            query = "FROM Auto a WHERE a.precio > 10000"
    ),
    @NamedQuery(
            name = "obtenerAutosBaratos",
            query = "FROM Auto a WHERE a.precio <= :pre"
    )
})
public class Auto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "au_id")
    private int id;
    @Column(name = "au_marca")
    private String marca;
    @Column(name = "au_modelo")
    private String modelo;
    @Column(name = "au_fecha_venta")
    private Date fechaVenta;
    @Column(name = "au_precio")
    private float precio;
    @Column(name = "au_concesionario")
    private int concesionario;

    public Auto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(int concesionario) {
        this.concesionario = concesionario;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
