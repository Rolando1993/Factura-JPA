/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entidades.Producto;
import com.factura.listener.EMF;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author DUALPC
 */
public class ProductoDao implements IProductoDao{

    @Override
    public void insertar(Producto p) {
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
    }

    @Override
    public void actualizar(Producto p) {
        EntityManager em = EMF.crearEntityManager();
        Producto p1 = em.find(Producto.class, p.getCodigoproducto());
        em.getTransaction().begin();
        if(em.contains(p1)){
            em.merge(p);
        }else{
            System.out.println("No Se Pudo Actualizar El Producto......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void eliminar(Producto p) {
        EntityManager em = EMF.crearEntityManager();
        Producto p1 = em.find(Producto.class, p.getCodigoproducto());
        em.getTransaction().begin();
        if(em.contains(p1)){
            em.remove(p1);
        }else{
            System.out.println("No Se Pudo Eliminar El Producto......");
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Producto> getListaProductos() {
        List<Producto> listaProducto = new ArrayList<>();
        EntityManager em = EMF.crearEntityManager();
        em.getTransaction().begin();
        Query q = em.createNamedQuery("consultarProducto");
        listaProducto = q.getResultList();
        em.getTransaction().commit();
        em.close();
        return listaProducto;
    }
    
}
