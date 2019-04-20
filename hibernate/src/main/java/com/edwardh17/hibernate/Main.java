package com.edwardh17.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.edwardh17.tablas.Auto;
import com.edwardh17.tablas.Concesionario;
import java.util.Date;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        insertarConcesionario("Automóviles San Jorge", "Av Corrientes 1740", sesion);
        insertarConcesionario("Auto Zero", "Lavalle 1101", sesion);
        insertarConcesionario("Giorgi Automotores", "Juan Domingo Perón 795", sesion);
        insertarConcesionario("Pro Motors", "Juana Manso 163,", sesion);
        /*insertarAuto("chevrolet", "2000",  2005-05-05, 18000,  1, sesion);
        insertarAuto("Audi", "A8", 2,sesion);
        insertarAuto("Mercedez", "C320", 1,sesion);
        insertarAuto("Toyota", "Yaris", 3,sesion);
        insertarAuto("Toyota", "Corolla", 4, sesion);
        insertarAuto("Toyota", "Etios", 1, sesion);*/
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
        //buscarUnAuto("Toyota",sesion);
        
        //Todos los autos ordenados en forma descendente porfecha de venta
        List<Auto> listautos =
                //sesion.createQuery("FROM Auto order by au_fecha_venta").getResultList();
                //mostrarListaAutos(listautos.iterator());
        //Los autos con fecha de venta entre 2002-01-01 y 2003-01-01.
                //sesion.createQuery("FROM Auto WHERE au_fecha_venta BETWEEN '2002-01-01' AND '2003-01-01'").getResultList();
                //mostrarListaAutos(listautos.iterator());
        //Los autos cuya marca comienza con la letra C.
                sesion.createQuery("FROM Auto WHERE au_marca LIKE 'c%'").getResultList();
                //mostrarListaAutos(listautos.iterator());
                
        //La cantidad total de marcas diferentes.
                Query qry = sesion.createQuery("SELECT COUNT(DISTINCT marca)FROM Auto");
                long totalmarcasdistintas = (Long)qry.uniqueResult();
                //System.out.println("Total marcas encontradas: " + totalmarcasdistintas);
        //El monto total de venta agrupado por marca
        
        Iterator listapreciospormarca = sesion.createQuery("select marca, sum(precio)"
                + "FROM Auto GROUP BY marca").list().iterator();
        while (listapreciospormarca.hasNext()){
            Object[] marcaprecio = (Object[]) listapreciospormarca.next();
            //System.out.println("Marca: " + marcaprecio[0] + " | Total Venta : " + marcaprecio[1]);
        }
        
        //Producto cartesiano entre autos y concesionarios
        System.out.println("\n\n***** Producto cartesiano entre autos y concesionarios *******");
        Iterator pcartesiano = sesion.createQuery("SELECT a.marca, "
                + "a.modelo, c.nombre FROM Auto "
                + "a, Concesionario c WHERE a.concesionario = c.id").list().iterator();
        while (pcartesiano.hasNext()){
            Object[] autocons = (Object[]) pcartesiano.next();
            System.out.println("Marca: " + autocons[0] + " | Modelo : " + autocons[1] + ", Concesionario: " + autocons[2]);
        }
                
        sesion.close();
    }
    
    public static void mostrarListaAutos(Iterator<Auto> itautos){
        while(itautos.hasNext()){
            Auto autotmp = itautos.next();
            System.out.println("Marca : " + autotmp.getMarca()
            + ", Modelo : " + autotmp.getModelo() + ", Precio : " + autotmp.getPrecio());
        }
    }
    
    public static void insertarAuto(String marca, String modelo, Date fecha, float precio, int concesionario, Session sesion){
        Auto auto1 = new Auto();
        auto1.setMarca(marca);
        auto1.setModelo(modelo);
        auto1.setFechaVenta(fecha);
        auto1.setPrecio(precio);
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