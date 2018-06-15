/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.pruebas;

import com.factura.entidades.Cliente;
import com.factura.negocio.ClienteLN;
import com.factura.negocio.IClienteLN;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DUALPC
 */
public class AppCliente {
    
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAFacturaWebPU");
     
    public static void main(String[] args) {
        
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        
        int codigo;
        String nombre = "";
        String apellido = "";
        String direccion = "";
        int op = 0;
        IClienteLN clienteBL = new ClienteLN();
        Cliente c = new Cliente();
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
                    System.out.println("Datos Personales Del Cliente.....");
                    //System.out.println("Ingrese El Codigo Del Cliente");
                    //codigo = sc.nextInt();
                    
                    System.out.println("Ingrese El Nombre Del Cliente");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Apellido Del Cliente");
                    apellido = sc.nextLine();
                    
                    System.out.println("Ingrese La Direccion Del Cliente");
                    direccion = sc.nextLine();
                  
                    //c.setCodigocliente(codigo);
                    c.setNombres(nombre);
                    c.setApellidos(apellido);
                    c.setDireccion(direccion);
                    clienteBL.save(c);
                    System.out.println("Registro Insertado Con Exito....");
                    
                }else if(op == 2){
                    System.out.println("Datos Personales Del Cliente.....");
                    System.out.println("Ingrese El Codigo Del Cliente");
                    codigo = sc.nextInt();
                    
                    System.out.println("Ingrese El Nombre Del Cliente");
                    nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    
                    System.out.println("Ingrese El Apellido Del Cliente");
                    apellido = sc.nextLine();
                    
                    System.out.println("Ingrese La Direccion Del Cliente");
                    direccion = sc.nextLine();
                    
                    //em.getTransaction().begin();
                    c.setCodigocliente(codigo);
                    c.setNombres(nombre);
                    c.setApellidos(apellido);
                    c.setDireccion(direccion);
                    clienteBL.update(c);
                    //em.getTransaction().commit();
                    System.out.println("Registro Actualizado Con Exito....");
                    
                }else if(op == 3){
                    System.out.println("Datos Personales Del Cliente.....");
                    System.out.println("Ingrese El Codigo Del Cliente");
                    codigo = sc.nextInt();
                    
                    c.setCodigocliente(codigo);
                    clienteBL.delete(c);
                    System.out.println("Registro Eliminado Con Exito....");
                    
                }else if(op == 4){
                    for (Cliente c1 : clienteBL.consultarCliente()) {
                        System.out.println(c1);
                        
                    }
                    
                }else if(op == 5){
                    List<Cliente> listaClientes = (List<Cliente>) em.createQuery("FROM Cliente").getResultList();
                    System.out.println("Hay " + listaClientes.size() + " Clientes En El Sistema");
                    for (Cliente cli : listaClientes) {
                        System.out.println(cli.toString());
            
                    }
                }
        } while (op != 6);
        System.exit(op);
        System.out.println("Saliendo........");
        
    }
    
}
