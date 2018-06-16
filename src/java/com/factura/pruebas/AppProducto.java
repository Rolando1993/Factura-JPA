/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.pruebas;

import com.factura.entidades.Producto;
import com.factura.negocio.IProductoBL;
import com.factura.negocio.ProductoBL;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DUALPC
 */
public class AppProducto {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAFacturaWebPU");
     
    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        
        int codigo;
        String nombre = "";
        BigDecimal precioVenta;
        int stockMinimo;
        int stockActual;
        String codigoBarra = "";
        int op = 0;
        IProductoBL productoBL = new ProductoBL();
        Producto p = new Producto();
        do {            
            System.out.println("Menu De Opciones - JPA - Hibernate ");
            System.out.println("1. Grabar");
            System.out.println("2. Actualizar");
            System.out.println("3. Eliminar");
            System.out.println("4. Consultar");
            System.out.println("5. Imprimir Todo");
            System.out.println("6. Salir");
            System.out.println("Ingrese La Opcion");
            op = sc.nextInt();
                if(op == 1){
                    System.out.println("Datos Del Producto.....");
                    //System.out.println("Ingrese El Codigo Del Cliente");
                    //codigo = sc.nextInt();
                    
                    System.out.println("Ingrese El Nombre Del Producto");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Precio De Venta Del Producto");
                    precioVenta = sc.nextBigDecimal();
                    
                    System.out.println("Ingrese El Stock Minimo Del Producto");
                    stockMinimo = sc.nextInt();
                    
                    System.out.println("Ingrese El Stock Actual Del Producto");
                    stockActual = sc.nextInt();
                    
                    System.out.println("Ingrese El Codigo De Barra Del Producto");
                    codigoBarra = sc.nextLine();
                    codigoBarra = sc.nextLine();
                  
                    //c.setCodigocliente(codigo);
                    p.setNombre(nombre);
                    p.setPrecioventa(precioVenta);
                    p.setStockminimo(stockMinimo);
                    p.setStockactual(stockActual);
                    p.setCodigobarra(codigoBarra);
                    productoBL.save(p);
                    System.out.println("Registro Insertado Con Exito....");
                    
                }else if(op == 2){
                    System.out.println("Datos Del Producto.....");
                    System.out.println("Ingrese El Codigo Del Producto");
                    codigo = sc.nextInt();
                    
                    System.out.println("Ingrese El Nombre Del Producto");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Precio De Venta Del Producto");
                    precioVenta = sc.nextBigDecimal();
                    
                    System.out.println("Ingrese El Stock Minimo Del Producto");
                    stockMinimo = sc.nextInt();
                    
                    System.out.println("Ingrese El Stock Actual Del Producto");
                    stockActual = sc.nextInt();
                    
                    System.out.println("Ingrese El Codigo De Barra Del Producto");
                    codigoBarra = sc.nextLine();
                    codigoBarra = sc.nextLine();
                    
                    //em.getTransaction().begin();
                    p.setCodigoproducto(codigo);
                    p.setNombre(nombre);
                    p.setPrecioventa(precioVenta);
                    p.setStockminimo(stockMinimo);
                    p.setStockactual(stockActual);
                    p.setCodigobarra(codigoBarra);
                    productoBL.update(p);
                    //em.getTransaction().commit();
                    System.out.println("Registro Actualizado Con Exito....");
                    
                }else if(op == 3){
                    System.out.println("Datos Del Producto.....");
                    System.out.println("Ingrese El Codigo Del Producto");
                    codigo = sc.nextInt();
                    
                    p.setCodigoproducto(codigo);
                    productoBL.delete(p);
                    System.out.println("Registro Eliminado Con Exito....");
                    
                }else if(op == 4){
                    for (Producto p1 : productoBL.consultarProducto()) {
                        System.out.println(p1);
                        
                    }
                    
                }else if(op == 5){
                    List<Producto> listaProductos = (List<Producto>) em.createQuery("FROM Producto").getResultList();
                    System.out.println("Hay " + listaProductos.size() + " Productos En El Sistema");
                    for (Producto pro : listaProductos) {
                        System.out.println(pro.toString());
            
                    }
                }
        } while (op != 6);
        System.exit(op);
        System.out.println("Saliendo........");
        
    }
    
}
