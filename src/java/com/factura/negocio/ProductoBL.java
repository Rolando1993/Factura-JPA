/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.negocio;

import com.factura.dao.IProductoDao;
import com.factura.dao.ProductoDao;
import com.factura.entidades.Producto;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public class ProductoBL implements IProductoBL{
    
    IProductoDao productoDao = new ProductoDao();

    @Override
    public void save(Producto p) {
        this.productoDao.insertar(p);
    }

    @Override
    public void update(Producto p) {
        this.productoDao.actualizar(p);
    }

    @Override
    public void delete(Producto p) {
        this.productoDao.eliminar(p);
    }

    @Override
    public List<Producto> consultarProducto() {
        return this.productoDao.getListaProductos();
    }
    
}
