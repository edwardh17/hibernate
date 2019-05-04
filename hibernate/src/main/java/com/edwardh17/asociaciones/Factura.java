package com.edwardh17.asociaciones;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


public class Factura implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "fac_id")
     private Long codigo;
     
     @OneToMany(cascade = CascadeType.ALL, mappedBy ="factura")
     //@JoinColumn(name = "fac_id")
     private Set<Item> items = new HashSet<Item>();
     
    public Factura() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    
     
}
