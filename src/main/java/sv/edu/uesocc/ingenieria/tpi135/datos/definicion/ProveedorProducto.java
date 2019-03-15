/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.definicion;

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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonahdz
 */
@Entity
@Table(name = "proveedor_producto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProveedorProducto.findAll", query = "SELECT p FROM ProveedorProducto p")
    , @NamedQuery(name = "ProveedorProducto.findByIdProveedorProducto", query = "SELECT p FROM ProveedorProducto p WHERE p.idProveedorProducto = :idProveedorProducto")
    , @NamedQuery(name = "ProveedorProducto.findByPrecios", query = "SELECT p FROM ProveedorProducto p WHERE p.precios = :precios")
    , @NamedQuery(name = "ProveedorProducto.findByDescuentos", query = "SELECT p FROM ProveedorProducto p WHERE p.descuentos = :descuentos")
    , @NamedQuery(name = "ProveedorProducto.findByObservaciones", query = "SELECT p FROM ProveedorProducto p WHERE p.observaciones = :observaciones")})
public class ProveedorProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor_producto", nullable = false)
    private Integer idProveedorProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precios", nullable = false)
    private double precios;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuentos", nullable = false)
    private double descuentos;
    @Size(max = 255)
    @Column(name = "observaciones", length = 255)
    private String observaciones;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idProducto;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public ProveedorProducto() {
    }

    public ProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public ProveedorProducto(Integer idProveedorProducto, double precios, double descuentos) {
        this.idProveedorProducto = idProveedorProducto;
        this.precios = precios;
        this.descuentos = descuentos;
    }

    public Integer getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public double getPrecios() {
        return precios;
    }

    public void setPrecios(double precios) {
        this.precios = precios;
    }

    public double getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(double descuentos) {
        this.descuentos = descuentos;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProveedorProducto != null ? idProveedorProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProveedorProducto)) {
            return false;
        }
        ProveedorProducto other = (ProveedorProducto) object;
        if ((this.idProveedorProducto == null && other.idProveedorProducto != null) || (this.idProveedorProducto != null && !this.idProveedorProducto.equals(other.idProveedorProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.datos.definicion.ProveedorProducto[ idProveedorProducto=" + idProveedorProducto + " ]";
    }
    
}
