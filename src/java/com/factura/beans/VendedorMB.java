/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.beans;

import com.factura.entidades.Vendedor;
import com.factura.negocio.IVendedorBL;
import com.factura.negocio.VendedorBL;
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
public class VendedorMB implements Serializable{

    private Vendedor vendedor = new Vendedor();
    private List<Vendedor> listaVendedores;
    IVendedorBL vendedorBL = new VendedorBL();
    
    public VendedorMB() {
        vendedor = new Vendedor();
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<Vendedor> getListaVendedores() {
        listaVendedores = vendedorBL.consultarVendedor();
        return listaVendedores;
    }

    public void setListaVendedores(List<Vendedor> listaVendedores) {
        this.listaVendedores = listaVendedores;
    }
    
     public void save(){
        vendedorBL.save(getVendedor());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "", "Datos Insertados Exitosamente"));   
    }
    
    public void update(){
        vendedorBL.update(getVendedor());
    }
    
    public void delete(){
         vendedorBL.delete(getVendedor());
    }
    
}
