/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.factura.entidades;

import java.io.Serializable;
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
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByCodigousuario", query = "SELECT u FROM Usuario u WHERE u.codigousuario = :codigousuario")
    , @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigousuario")
    private Integer codigousuario;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "password")
    private String password;
    @JoinColumn(name = "codigovendedor", referencedColumnName = "codigovendedor")
    @ManyToOne
    private Vendedor codigovendedor;

    public Usuario() {
    }

    public Usuario(Integer codigousuario) {
        this.codigousuario = codigousuario;
    }

    public Integer getCodigousuario() {
        return codigousuario;
    }

    public void setCodigousuario(Integer codigousuario) {
        this.codigousuario = codigousuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Vendedor getCodigovendedor() {
        return codigovendedor;
    }

    public void setCodigovendedor(Vendedor codigovendedor) {
        this.codigovendedor = codigovendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigousuario != null ? codigousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.codigousuario == null && other.codigousuario != null) || (this.codigousuario != null && !this.codigousuario.equals(other.codigousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.factura.entidades.Usuario[ codigousuario=" + codigousuario + " ]";
    }
    
}
