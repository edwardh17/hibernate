package com.edwardh17.tablas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "transporte")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="tr_discriminador",
        discriminatorType=DiscriminatorType.STRING
)
public class Transporte implements Serializable{
    @Id
    @GeneratedValue
    @Column(name = "tr_id")
    private Long transporteid;
    @Column(name = "tr_largo")
    private int largo;
    @Column(name = "tr_ancho")
    private int ancho;
    
    public Transporte(){}

    public Long getTransporteid() {
        return transporteid;
    }

    public void setTransporteid(Long transporteid) {
        this.transporteid = transporteid;
    }

    public int getLargo() {
        return largo;
    }

    public void setLargo(int largo) {
        this.largo = largo;
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    
    
}



