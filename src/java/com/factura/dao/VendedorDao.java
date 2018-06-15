/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entidades.Vendedor;
import com.factura.listener.EMF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DUALPC
 */
public class VendedorDao implements IVendedorDao{

    @Override
    public void insertar(Vendedor v) {
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        em.persist(v);
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Vendedor v) {
        EntityManager em = EMF.crearEntityManager();
        Vendedor v1 = em.find(Vendedor.class, v.getCodigovendedor());
        em.getTransaction().begin();
        if(em.contains(v1)){
            em.merge(v);
        }else{
            System.out.println("No Se Pudo Actualizar El Vendedor......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Vendedor v) {
        EntityManager em = EMF.crearEntityManager();
        Vendedor v1 = em.find(Vendedor.class, v.getCodigovendedor());
        em.getTransaction().begin();
        if(em.contains(v1)){
            em.remove(v1);
        }else{
            System.out.println("No Se Pudo Eliminar El Vendedor......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Vendedor> getListaVendedores() {
        List<Vendedor> listaVendedor = new ArrayList<>();
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("consultarVendedor");
        listaVendedor = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return listaVendedor;
    }
    
}
