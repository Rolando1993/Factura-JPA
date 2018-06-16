/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.dao;

import com.factura.entidades.Producto;
import java.util.List;

/**
 *
 * @author DUALPC
 */
public interface IProductoDao {
    
    void insertar(Producto p);
    void actualizar(Producto p);
    void eliminar(Producto p);
    List<Producto> getListaProductos();
}
