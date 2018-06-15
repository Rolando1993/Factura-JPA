/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.listener;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author DUALPC
 */
public class EMF {
    
    private static EntityManagerFactory emf;
    
    public static EntityManager crearEntityManager(){
        
        if(emf == null){
            
            emf = Persistence.createEntityManagerFactory("JPAFacturaWebPU");
        }
        
        return emf.createEntityManager();
    }
}
