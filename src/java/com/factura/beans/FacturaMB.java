/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.beans;

import com.factura.entidades.Cliente;
import com.factura.listener.EMF;
import com.factura.negocio.ClienteBL;
import com.factura.negocio.IClienteBL;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@ViewScoped
public class FacturaMB implements Serializable{

    Session sesion;
    Transaction transaccion;
    EntityManager em = EMF.crearEntityManager();
    private Cliente cliente = new Cliente();
    Cliente clienteModels;
    private String codigoCliente;
    IClienteBL clienteBL = new ClienteBL();
    
    public FacturaMB() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
    
    public void agregarDatosDelCliente(Integer codCliente){
        this.em = null;
        try {
            this.em = EMF.crearEntityManager();
            em.getTransaction().begin();
            this.cliente = clienteBL.obtenerCliente(this.em, codCliente);
            em.getTransaction().commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado"));
        } catch (Exception e) {
            if(this.em.getTransaction() != null){
                System.out.println(e.getMessage());
                em.getTransaction().rollback();
            }
        }finally{
            if(this.em != null){
                this.em.close();
            }
        }
    }
    
    public void agregarCliente(Integer codCliente){
        clienteBL.obtenerCliente(codCliente);
    }
    
    /*
    public void datosDelCliente(Integer codCliente){
        this.sesion = null;
        this.transaccion = null;
        try {
            this.sesion = HibernateUtil.getSessionFactory().openSession();
            this.transaccion = this.sesion.beginTransaction();
            
            this.cliente = clienteBL.obtenerCliente(this.sesion, codCliente);
            this.transaccion.commit();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado"));

        } catch (Exception e) {
            if(this.transaccion != null){
                System.out.println(e.getMessage());
                transaccion.rollback();  
            }
        }finally{
            if(this.sesion != null){
                this.sesion.close();
            }
        }
    }*/
    
}
