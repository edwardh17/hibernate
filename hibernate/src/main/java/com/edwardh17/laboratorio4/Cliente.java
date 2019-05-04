/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwardh17.laboratorio4;

import java.io.Serializable;
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
@DiscriminatorValue("C")
public class Cliente extends Persona implements Serializable{
    @Column(name = "pe_cl_nro")
    private String pe_cl_nro;
    @Column(name = "pe_cl_tipo")     
    private char pe_cl_tipo;

    public Cliente() {
    }

    public String getPe_cl_nro() {
        return pe_cl_nro;
    }

    public void setPe_cl_nro(String pe_cl_nro) {
        this.pe_cl_nro = pe_cl_nro;
    }

    public char getPe_cl_tipo() {
        return pe_cl_tipo;
    }

    public void setPe_cl_tipo(char pe_cl_tipo) {
        this.pe_cl_tipo = pe_cl_tipo;
    }
    
   } 
