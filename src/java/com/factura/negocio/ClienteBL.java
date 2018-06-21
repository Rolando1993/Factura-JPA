/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.negocio;

import com.factura.dao.ClienteDao;
import com.factura.dao.IClienteDao;
import com.factura.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;

/**
 *
 * @author DUALPC
 */
public class ClienteBL implements IClienteBL{
    
    IClienteDao clienteDao = new ClienteDao();

    @Override
    public void save(Cliente c) {
        this.clienteDao.insertar(c);
    }

    @Override
    public void update(Cliente c) {
        this.clienteDao.actualizar(c);
    }

    @Override
    public void delete(Cliente c) {
        this.clienteDao.eliminar(c);
    }

    @Override
    public List<Cliente> consultarCliente() {
        return this.clienteDao.getListaClientes();
    }

    @Override
    public Cliente obtenerCliente(EntityManager emf, Integer codCliente) throws Exception {
        return this.clienteDao.obtenerClientePorCodigo(emf, codCliente);
    }

    @Override
    public ArrayList<Cliente> obtenerCliente(Integer codCliente) {
        return this.clienteDao.getObtenerClientePorCodigo(codCliente);
    }

    /*
    @Override
    public Cliente obtenerCliente(Session sesion, Integer codCliente) throws Exception {
        return this.clienteDao.obtenerClientePorCodigo(sesion, codCliente);
    }*/
    
}
