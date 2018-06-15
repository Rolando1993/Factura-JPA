/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
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
@Table(name = "vendedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "consultarVendedor", query = "SELECT v FROM Vendedor v")
    , @NamedQuery(name = "Vendedor.findByCodigovendedor", query = "SELECT v FROM Vendedor v WHERE v.codigovendedor = :codigovendedor")
    , @NamedQuery(name = "Vendedor.findByNombres", query = "SELECT v FROM Vendedor v WHERE v.nombres = :nombres")
    , @NamedQuery(name = "Vendedor.findByApellidos", query = "SELECT v FROM Vendedor v WHERE v.apellidos = :apellidos")
    , @NamedQuery(name = "Vendedor.findByDni", query = "SELECT v FROM Vendedor v WHERE v.dni = :dni")
    , @NamedQuery(name = "Vendedor.findByCeluldar", query = "SELECT v FROM Vendedor v WHERE v.celuldar = :celuldar")
    , @NamedQuery(name = "Vendedor.findByDireccion", query = "SELECT v FROM Vendedor v WHERE v.direccion = :direccion")})
public class Vendedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigovendedor")
    private Integer codigovendedor;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "apellidos")
    private String apellidos;
    @Column(name = "dni")
    private String dni;
    @Column(name = "celuldar")
    private String celuldar;
    @Column(name = "direccion")
    private String direccion;
    @OneToMany(mappedBy = "codigovendedor")
    private Collection<Factura> facturaCollection;
    @OneToMany(mappedBy = "codigovendedor")
    private Collection<Usuario> usuarioCollection;

    public Vendedor() {
    }

    public Vendedor(Integer codigovendedor) {
        this.codigovendedor = codigovendedor;
    }

    public Integer getCodigovendedor() {
        return codigovendedor;
    }

    public void setCodigovendedor(Integer codigovendedor) {
        this.codigovendedor = codigovendedor;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getCeluldar() {
        return celuldar;
    }

    public void setCeluldar(String celuldar) {
        this.celuldar = celuldar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @XmlTransient
    public Collection<Factura> getFacturaCollection() {
        return facturaCollection;
    }

    public void setFacturaCollection(Collection<Factura> facturaCollection) {
        this.facturaCollection = facturaCollection;
    }

    @XmlTransient
    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigovendedor != null ? codigovendedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.codigovendedor == null && other.codigovendedor != null) || (this.codigovendedor != null && !this.codigovendedor.equals(other.codigovendedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "codigovendedor=" + codigovendedor + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni=" + dni + ", celuldar=" + celuldar + ", direccion=" + direccion + '}';
    }

    
    
}
