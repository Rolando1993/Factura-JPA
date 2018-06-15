/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entidades.Cliente;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public interface IClienteDao {
    
    void insertar(Cliente c);
    void actualizar(Cliente c);
    void eliminar(Cliente c);
    List<Cliente> getListaClientes();
    
}
