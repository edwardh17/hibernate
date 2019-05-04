package com.edwardh17.hibernate;

import com.edwardh17.asociaciones.Factura;
import com.edwardh17.asociaciones.Item;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;



public class Asociaciones {
    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        
        //List<Factura> factura = sesion.createQuery("FROM factura WHERE codigo = 4").getResultList();
        
        Factura factura = new Factura();
        Item i = new Item();
        i.setCantidad(4L);
        i.setNombreProducto("Dulce de Leche");
        i.setFactura(factura);
        
        factura.getItems().add(i);
        
        
        sesion.close();
    }
}
