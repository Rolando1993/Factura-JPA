/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entidades.Cliente;
import com.factura.listener.EMF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DUALPC
 */
public class ClienteDao implements IClienteDao{

    @Override
    public void insertar(Cliente c) {
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        em.persist(c);
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Cliente c) {
        EntityManager em = EMF.crearEntityManager();
        Cliente c1 = em.find(Cliente.class, c.getCodigocliente());
        em.getTransaction().begin();
        if(em.contains(c1)){
            em.merge(c);
        }else{
            System.out.println("No Se Pudo Actualizar El Cliente......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Cliente c) {
        EntityManager em = EMF.crearEntityManager();
        Cliente c1 = em.find(Cliente.class, c.getCodigocliente());
        em.getTransaction().begin();
        if(em.contains(c1)){
            em.remove(c1);
        }else{
            System.out.println("No Se Pudo Eliminar El Cliente......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Cliente> getListaClientes() {
        List<Cliente> listaCliente = new ArrayList<>();
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("consultarCliente");
        listaCliente = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return listaCliente;
    }
    
}
