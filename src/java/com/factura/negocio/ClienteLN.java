/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.negocio;

import com.factura.dao.ClienteDao;
import com.factura.dao.IClienteDao;
import com.factura.entidades.Cliente;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public class ClienteLN implements IClienteLN{
    
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
    
}
