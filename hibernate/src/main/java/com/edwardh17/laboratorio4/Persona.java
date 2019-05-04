package com.edwardh17.laboratorio4;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "pe_discriminador",
        discriminatorType = DiscriminatorType.STRING
)
@DiscriminatorValue(value = "P")

public abstract class Persona implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pe_id")
    private int pe_id;
    @Column(name = "pe_nombre")
    private String pe_nombre;
    @Column(name = "pe_apellido")
    private String pe_apellido;
    @Column(name = "pe_direccion")
    private String pe_direccion;

    public Persona() {
    }

    public int getPe_id() {
        return pe_id;
    }

    public void setPe_id(int pe_id) {
        this.pe_id = pe_id;
    }

    public String getPe_nombre() {
        return pe_nombre;
    }

    public void setPe_nombre(String pe_nombre) {
        this.pe_nombre = pe_nombre;
    }

    public String getPe_apellido() {
        return pe_apellido;
    }

    public void setPe_apellido(String pe_apellido) {
        this.pe_apellido = pe_apellido;
    }

    public String getPe_direccion() {
        return pe_direccion;
    }

    public void setPe_direccion(String pe_direccion) {
        this.pe_direccion = pe_direccion;
    }
    
    

}
