/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DUALPC
 */
@Entity
@Table(name = "producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "consultarProducto", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByCodigoproducto", query = "SELECT p FROM Producto p WHERE p.codigoproducto = :codigoproducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByPrecioventa", query = "SELECT p FROM Producto p WHERE p.precioventa = :precioventa")
    , @NamedQuery(name = "Producto.findByStockminimo", query = "SELECT p FROM Producto p WHERE p.stockminimo = :stockminimo")
    , @NamedQuery(name = "Producto.findByStockactual", query = "SELECT p FROM Producto p WHERE p.stockactual = :stockactual")
    , @NamedQuery(name = "Producto.findByCodigobarra", query = "SELECT p FROM Producto p WHERE p.codigobarra = :codigobarra")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigoproducto")
    private Integer codigoproducto;
    @Column(name = "nombre")
    private String nombre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precioventa")
    private BigDecimal precioventa;
    @Column(name = "stockminimo")
    private Integer stockminimo;
    @Column(name = "stockactual")
    private Integer stockactual;
    @Column(name = "codigobarra")
    private String codigobarra;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoproducto")
    private Collection<Detallefactura> detallefacturaCollection;

    public Producto() {
    }

    public Producto(Integer codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public Integer getCodigoproducto() {
        return codigoproducto;
    }

    public void setCodigoproducto(Integer codigoproducto) {
        this.codigoproducto = codigoproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(BigDecimal precioventa) {
        this.precioventa = precioventa;
    }

    public Integer getStockminimo() {
        return stockminimo;
    }

    public void setStockminimo(Integer stockminimo) {
        this.stockminimo = stockminimo;
    }

    public Integer getStockactual() {
        return stockactual;
    }

    public void setStockactual(Integer stockactual) {
        this.stockactual = stockactual;
    }

    public String getCodigobarra() {
        return codigobarra;
    }

    public void setCodigobarra(String codigobarra) {
        this.codigobarra = codigobarra;
    }

    @XmlTransient
    public Collection<Detallefactura> getDetallefacturaCollection() {
        return detallefacturaCollection;
    }

    public void setDetallefacturaCollection(Collection<Detallefactura> detallefacturaCollection) {
        this.detallefacturaCollection = detallefacturaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoproducto != null ? codigoproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.codigoproducto == null && other.codigoproducto != null) || (this.codigoproducto != null && !this.codigoproducto.equals(other.codigoproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigoproducto=" + codigoproducto + ", nombre=" + nombre + ", precioventa=" + precioventa + ", stockminimo=" + stockminimo + ", stockactual=" + stockactual + ", codigobarra=" + codigobarra + '}';
    }

    
}
