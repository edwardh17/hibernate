package com.edwardh17.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edwardh17.tablas.Auto;
import com.edwardh17.tablas.Concesionario;

public class Main {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        insertarConcesionario("Automóviles San Jorge", "Av Corrientes 1740", sesion);
        insertarConcesionario("Auto Zero", "Lavalle 1101", sesion);
        insertarConcesionario("Giorgi Automotores", "Juan Domingo Perón 795", sesion);
        insertarConcesionario("Pro Motors", "Juana Manso 163,", sesion);
        insertarAuto("Peugeot", "307", 1, sesion);
        insertarAuto("Audi", "A8", 2,sesion);
        insertarAuto("Mercedez", "C320", 1,sesion);
        insertarAuto("Toyota", "Yaris", 3,sesion);
        insertarAuto("Toyota", "Corolla", 4, sesion);
        insertarAuto("Toyota", "Etios", 1, sesion);
        //sesion.close(); En las nuevas versiones de hibernate se cierran solas
        List<Auto> lista = buscarTodos(sesion);
        
        /*Iterator<Autos> itAutos = lista.iterator();
        while (itAutos.hasNext()){
            Auto itemp = itAutos.next();
            System.out.println("Marca: " + itemp.getMarca() + " Modelo: " + itemp.getModelo());
            
            Transaction tx = sesion.beginTransaction();
            itemp.setConcesionario("Avellaneda Cars");
            sesion.update(itemp);
            tx.commit();
        }*/
        /*for(Auto l : lista){
            System.out.println("ID: " + l.getId() + " || Marca: " + l.getMarca() + " || Modelo: " + l.getModelo());
        }*/
        buscarUnAuto("Toyota",sesion);
        sesion.close();
    }
    
    public static void insertarAuto(String marca, String modelo, int concesionario, Session sesion){
        Auto auto1 = new Auto();
        auto1.setMarca(marca);
        auto1.setModelo(modelo);
        auto1.setConcesionario(concesionario);
        Transaction tx = sesion.beginTransaction();
        sesion.save(auto1);
        tx.commit();
    }
    
    public static List<Auto> buscarTodos(Session sesion){
        List<Auto> listAutos = sesion.createQuery("FROM Auto").list();
        return listAutos;
    }
    
    public static void buscarUnAuto(String marca, Session sesion){
        List<Auto> listAutos =
                sesion.createQuery("FROM Auto a WHERE a.marca = '"+marca+"'").list();
        System.out.println("Cantidad de autos devueltos " + listAutos.size());
    }
    
    public static void insertarConcesionario(String nombre, String direccion, Session sesion){
        Concesionario con = new Concesionario();
        con.setNombre(nombre);
        con.setDireccion(direccion);
        Transaction tx = sesion.beginTransaction();
        sesion.save(con);
        tx.commit();
    //List<Concesionario> listConcesionarios = sesion.createQuery("FROM Concesionarios a WHERE a.nombre = '"+nombre+"'").list();
    }
}