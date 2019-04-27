/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwardh17.tablas;

import com.edwardh17.hibernate.SessionFactory;
import org.hibernate.Session;

/**
 *
 * @author EducaciónIT
 */
public class Herencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
        Moto m1 = new Moto();
        m1.setAncho(25);
        m1.setLargo(150);
        m1.setPatente("YVH-896");
        sesion.save(m1);
        sesion.close();
    }
    
}
