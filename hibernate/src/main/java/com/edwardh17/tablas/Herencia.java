/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edwardh17.tablas;

import com.edwardh17.hibernate.SessionFactory;
import com.edwardh17.laboratorio4.Cliente;
import com.edwardh17.laboratorio4.Vendedor;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;

public class Herencia {

    public static void main(String[] args) {
        Session sesion = SessionFactory.getSession();
//        Moto m1 = new Moto();
//        m1.setAncho(25);
//        m1.setLargo(150);
//        m1.setPatente("YVH-896");
//        sesion.save(m1);
//        try{
//            agregarVendedor(sesion, "Jose", "Mendez", "Lanus", "123456", "2018-01-01");
//            agregarVendedor(sesion, "Maria", "Rodriguez", "Lanus", "23434", "2018-01-01");
//            agregarVendedor(sesion, "Raul", "Gonzalez", "Lanus", "76867878", "2018-01-01");
//            
//            agregarCliente(sesion, "Luis", "Jimenez", "Lanus", "990906", 'C');
//            agregarCliente(sesion, "Ricardo", "Hernandez", "Lanus", "1545545", 'P');
//            agregarCliente(sesion, "Laura", "Infante", "Lanus", "1233456", 'C');
//            
//        }catch(Exception e){
//            System.out.println("error " + e);
//        }
        
        List<Cliente> cliente =
                sesion.createQuery("FROM Cliente").getResultList();
        System.out.println("Total clientes " + cliente.size());
        
        Iterator it = cliente.iterator();
        while (it.hasNext()){
            Cliente cltmp = (Cliente) it.next();
            System.out.println("Nombre: " + cltmp.getPe_nombre()+
                    " - Apellido: " + cltmp.getPe_apellido() + " - Tipo cliente " +
                    cltmp.getPe_cl_tipo());
        }
        
        List <Vendedor> vendedores =
                sesion.createQuery("FROM Vendedor").getResultList();
        it = vendedores.iterator();
        while (it.hasNext()){
            Vendedor vntmp = (Vendedor) it.next();
            System.out.println("Nombre y Apellido: " + vntmp.getPe_nombre() + " " + vntmp.getPe_apellido()
            + " - Fecha ingreso: " + FechatoString(vntmp.getPe_ve_fecha_ingreso()));
        }
        
        sesion.close();
    }
    
    public static void agregarVendedor (Session s, String nombre, String apellido, String direccion,
            String nro_legajo, String fechaIngreso) throws ParseException{
        Vendedor vendedor = new Vendedor();
        vendedor.setPe_nombre(nombre);
        vendedor.setPe_apellido(apellido);
        vendedor.setPe_direccion(direccion);
        vendedor.setPe_ve_legajo(nro_legajo);
        vendedor.setPe_ve_fecha_ingreso(obtenerFecha(fechaIngreso));
        s.save(vendedor);
    }
    
    public static void agregarCliente (Session s, String nombre, String apellido, String direccion,
            String nro_cliente, char tipo_cliente){
        Cliente cliente = new Cliente();
        cliente.setPe_nombre(nombre);
        cliente.setPe_apellido(apellido);
        cliente.setPe_direccion(direccion);
        cliente.setPe_cl_nro(nro_cliente);
        cliente.setPe_cl_tipo(tipo_cliente);
        s.save(cliente);
    }
    
    public static Date obtenerFecha(String date) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date dateF = formatter.parse(date);
        return dateF;
    }
    
    public static String FechatoString(Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateF = dateFormat.format(fecha);
        return dateF;
    }
}
