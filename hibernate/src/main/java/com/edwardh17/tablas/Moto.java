package com.edwardh17.tablas;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "transporte")
@DiscriminatorValue("M")
public class Moto extends Transporte implements Serializable{
    @Column(name = "transporte")
    private String patente;
    
    public Moto(){}

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
   
}
