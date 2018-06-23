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


/**
 *
 * @author DUALPC
 */
@ManagedBean
@ViewScoped
public class FacturaMB implements Serializable{
    
    EntityManager em = EMF.crearEntityManager();
    private Cliente cliente = new Cliente();
    private Integer codigoCliente;
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

    public Integer getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(Integer codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

  
    
    //Metodo Para Agregar Los Clientes Por Medio Del Dialog
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
    
    //Metodo Para Agregar Los Clientes Por Medio Del Dialog Con Logica De Negocio
    public void agregarCliente(Integer codCliente){
        clienteBL.obtenerCliente(codCliente);
    }
    
    //Metodo Para Agregar Los Clientes Por Medio Del Codigo
    public void agregarDatosDelCliente2(){
        this.em = null;
        try {
            if(this.codigoCliente == null){
                return;
            }
            this.em = EMF.crearEntityManager();
            em.getTransaction().begin();
            this.cliente = clienteBL.obtenerCliente(this.em, this.codigoCliente);
            if(this.cliente != null){
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado")); 
            }else{
                this.codigoCliente = null;
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Correcto", "Cliente No Encontrado"));
            }
            em.getTransaction().commit();
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Correcto", "Datos Del Cliente Agregado"));
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
