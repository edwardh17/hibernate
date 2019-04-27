package com.edwardh17.hibernate;

import com.edwardh17.tablas.Auto;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class TestQueriesParametrizadas {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        //List resultado = obtenerAutosSegunCriterio(sesion, "98","chev");
        //List resultado = obtenerAutosConPaginacion(sesion, 0, 5);
        //List resultado = sesion.getNamedQuery("obtenerAutosCaros").list();
        //List resultado = sesion.getNamedQuery("obtenerAutosBaratos").list();
        Query query = sesion.createNamedQuery("obtenerAutosBaratos");
        query.setParameter("pre", 10000f);
        List resultado = query.list();
        System.out.println("resultado " + resultado.size());
        Iterator it = resultado.iterator();
        while (it.hasNext()){
            Auto autmp = (Auto) it.next();
            System.out.println("Id " + autmp.getId() + " - Modelo " + autmp.getModelo() + " - Marca " + autmp.getMarca());
        }
        sesion.close();
    }

    public static List obtenerAutosSegunCriterio(Session s, String unModelo, String unaMarca) {
        Query qry = s.createQuery("FROM Auto WHERE modelo like :mod and marca like :marca ");
        qry.setParameter("mod", "%"+unModelo);
        qry.setParameter("marca", unaMarca+"%");

        return qry.list();
    }
    
    public static List obtenerAutosConPaginacion(Session s, int registroInicial, int cantidad){
        Query qry = s.createQuery("FROM Auto");
        qry.setMaxResults(cantidad);
        qry.setFirstResult(registroInicial);
        return qry.list();
    }

}
