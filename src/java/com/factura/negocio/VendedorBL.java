/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.negocio;

import com.factura.dao.IVendedorDao;
import com.factura.dao.VendedorDao;
import com.factura.entidades.Vendedor;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public class VendedorBL implements IVendedorBL{
    
    IVendedorDao vendedorDao = new VendedorDao();

    @Override
    public void save(Vendedor v) {
        this.vendedorDao.insertar(v);
    }

    @Override
    public void update(Vendedor v) {
        this.vendedorDao.actualizar(v);
    }

    @Override
    public void delete(Vendedor v) {
        this.vendedorDao.eliminar(v);
    }

    @Override
    public List<Vendedor> consultarVendedor() {
        return this.vendedorDao.getListaVendedores();
    }
    
}
