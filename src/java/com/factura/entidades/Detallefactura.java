/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DUALPC
 */
@Entity
@Table(name = "detallefactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detallefactura.findAll", query = "SELECT d FROM Detallefactura d")
    , @NamedQuery(name = "Detallefactura.findByCodigodetalle", query = "SELECT d FROM Detallefactura d WHERE d.codigodetalle = :codigodetalle")
    , @NamedQuery(name = "Detallefactura.findByCodigobarra", query = "SELECT d FROM Detallefactura d WHERE d.codigobarra = :codigobarra")
    , @NamedQuery(name = "Detallefactura.findByNombre", query = "SELECT d FROM Detallefactura d WHERE d.nombre = :nombre")
    , @NamedQuery(name = "Detallefactura.findByCantidad", query = "SELECT d FROM Detallefactura d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Detallefactura.findByPrecioventa", query = "SELECT d FROM Detallefactura d WHERE d.precioventa = :precioventa")
    , @NamedQuery(name = "Detallefactura.findByTotal", query = "SELECT d FROM Detallefactura d WHERE d.total = :total")})
public class Detallefactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigodetalle")
    private Integer codigodetalle;
    @Column(name = "codigobarra")
    private String codigobarra;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "cantidad")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioventa")
    private BigDecimal precioventa;
    @Column(name = "total")
    private BigDecimal total;
    @JoinColumn(name = "codigofactura", referencedColumnName = "codigofactura")
    @ManyToOne(optional = false)
    private Factura codigofactura;
    @JoinColumn(name = "codigoproducto", referencedColumnName = "codigoproducto")
    @ManyToOne(optional = false)
    private Producto codigoproducto;

    public Detallefactura() {
    }

    public Detallefactura(Integer codigodetalle) {
        this.codigodetalle = codigodetalle;
    }

    public Integer getCodigodetalle() {
        return codigodetalle;
    }

    public void setCodigodetalle(Integer codigodetalle) {
        this.codigodetalle = codigodetalle;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Factura getCodigofactura() {
        return codigofactura;
    }

    public void setCodigofactura(Factura codigofactura) {
        this.codigofactura = codigofactura;
    }

    public Producto getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Producto codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigodetalle != null ? codigodetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detallefactura)) {
            return false;
        }
        Detallefactura other = (Detallefactura) object;
        if ((this.codigodetalle == null && other.codigodetalle != null) || (this.codigodetalle != null && !this.codigodetalle.equals(other.codigodetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.factura.entidades.Detallefactura[ codigodetalle=" + codigodetalle + " ]";
    }
    
}
