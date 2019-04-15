package com.edwardh17.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edwardh17.tablas.Autos;

public class Main {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        //insertarAuto("Peugeot", "307", sesion);
        //insertarAuto("Audi", "A8", sesion);
        //insertarAuto("Mercedez", "C320", sesion);
        //sesion.close(); En las nuevas versiones de hibernate se cierran solas
        //List<Autos> lista = buscarTodos(sesion);
        
        
        
        /*Iterator<Autos> itAutos = lista.iterator();
        while (itAutos.hasNext()){
            Autos itemp = itAutos.next();
            System.out.println("Marca: " + itemp.getMarca() + " Modelo: " + itemp.getModelo());
            
            Transaction tx = sesion.beginTransaction();
            itemp.setConcesionario("Avellaneda Cars");
            sesion.update(itemp);
            tx.commit();
        }*/
        /*for(Autos l : lista){
            System.out.println("ID: " + l.getId() + " || Marca: " + l.getMarca() + " || Modelo: " + l.getModelo());
        }*/
        buscarUnAuto("Peugeot",sesion);
        sesion.close();
    }
    
    public static void insertarAuto(String marca, String modelo, Session sesion){
        Autos auto1 = new Autos();
        auto1.setMarca(marca);
        auto1.setModelo(modelo);
        Transaction tx = sesion.beginTransaction();
        sesion.save(auto1);
        tx.commit();
    }
    
    public static List<Autos> buscarTodos(Session sesion){
        List<Autos> listAutos = sesion.createQuery("FROM Autos").list();
        return listAutos;
    }
    
    public static void buscarUnAuto(String marca, Session sesion){
        List<Autos> listAutos =
                sesion.createQuery("FROM Autos a WHERE a.marca = 'Peugeot'").list();
        System.out.println("Cantidad de autos devueltos " + listAutos.size());
    }
}
