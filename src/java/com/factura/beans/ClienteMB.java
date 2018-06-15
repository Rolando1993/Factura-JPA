/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.beans;

import com.factura.entidades.Cliente;
import com.factura.negocio.ClienteLN;
import com.factura.negocio.IClienteLN;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author DUALPC
 */
@ManagedBean
@ViewScoped
public class ClienteMB implements Serializable{

    private Cliente cliente = new Cliente();
    private List<Cliente> listaClientes;
    IClienteLN clienteBL = new ClienteLN();
    
    public ClienteMB() {
        cliente = new Cliente();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getListaClientes() {
        listaClientes = clienteBL.consultarCliente();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }
    
    public void save(){
        clienteBL.save(getCliente());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Datos Insertados Exitosamente"));

        
    }
    
    public void update(){
        clienteBL.update(getCliente());
    }
    
    public void delete(){
         clienteBL.delete(getCliente());
    }
    
}
