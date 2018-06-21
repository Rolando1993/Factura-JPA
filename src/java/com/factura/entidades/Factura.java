/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DUALPC
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "consultarFactura", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByCodigofactura", query = "SELECT f FROM Factura f WHERE f.codigofactura = :codigofactura")
    , @NamedQuery(name = "Factura.findByNumerofactura", query = "SELECT f FROM Factura f WHERE f.numerofactura = :numerofactura")
    , @NamedQuery(name = "Factura.findByTotalventa", query = "SELECT f FROM Factura f WHERE f.totalventa = :totalventa")
    , @NamedQuery(name = "Factura.findByFecharegistro", query = "SELECT f FROM Factura f WHERE f.fecharegistro = :fecharegistro")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigofactura")
    private Integer codigofactura;
    @Column(name = "numerofactura")
    private Integer numerofactura;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalventa")
    private BigDecimal totalventa;
    @Column(name = "fecharegistro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecharegistro;
    @JoinColumn(name = "codigocliente", referencedColumnName = "codigocliente")
    @ManyToOne
    private Cliente codigocliente;
    @JoinColumn(name = "codigovendedor", referencedColumnName = "codigovendedor")
    @ManyToOne
    private Vendedor codigovendedor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigofactura")
    private Collection<Detallefactura> detallefacturaCollection;

    public Factura() {
    }

    public Factura(Integer codigofactura) {
        this.codigofactura = codigofactura;
    }

    public Integer getCodigofactura() {
        return codigofactura;
    }

    public void setCodigofactura(Integer codigofactura) {
        this.codigofactura = codigofactura;
    }

    public Integer getNumerofactura() {
        return numerofactura;
    }

    public void setNumerofactura(Integer numerofactura) {
        this.numerofactura = numerofactura;
    }

    public BigDecimal getTotalventa() {
        return totalventa;
    }

    public void setTotalventa(BigDecimal totalventa) {
        this.totalventa = totalventa;
    }

    public Date getFecharegistro() {
        return fecharegistro;
    }

    public void setFecharegistro(Date fecharegistro) {
        this.fecharegistro = fecharegistro;
    }

    public Cliente getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(Cliente codigocliente) {
        this.codigocliente = codigocliente;
    }

    public Vendedor getCodigovendedor() {
        return codigovendedor;
    }

    public void setCodigovendedor(Vendedor codigovendedor) {
        this.codigovendedor = codigovendedor;
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
        hash += (codigofactura != null ? codigofactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.codigofactura == null && other.codigofactura != null) || (this.codigofactura != null && !this.codigofactura.equals(other.codigofactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.factura.entidades.Factura[ codigofactura=" + codigofactura + " ]";
    }
    
}
