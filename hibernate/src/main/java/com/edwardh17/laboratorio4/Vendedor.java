
package com.edwardh17.laboratorio4;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@DiscriminatorValue("B")
public class Vendedor extends Persona implements Serializable{
    @Column(name = "pe_ve_legajo")
    private String pe_ve_legajo;
    @Column(name = "pe_ve_fecha_ingreso")
    private Date pe_ve_fecha_ingreso;
    
    public Vendedor(){}

    public String getPe_ve_legajo() {
        return pe_ve_legajo;
    }

    public void setPe_ve_legajo(String pe_ve_legajo) {
        this.pe_ve_legajo = pe_ve_legajo;
    }

    public Date getPe_ve_fecha_ingreso() {
        return pe_ve_fecha_ingreso;
    }

    public void setPe_ve_fecha_ingreso(Date pe_ve_fecha_ingreso) {
        this.pe_ve_fecha_ingreso = pe_ve_fecha_ingreso;
    }
    
    
}
