/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

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
    , @NamedQuery(name = "ProveedorProducto.findByPrecioCompra", query = "SELECT p FROM ProveedorProducto p WHERE p.precioCompra = :precioCompra")
    , @NamedQuery(name = "ProveedorProducto.findByDescuentoCompra", query = "SELECT p FROM ProveedorProducto p WHERE p.descuentoCompra = :descuentoCompra")})
public class ProveedorProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_proveedor_producto", nullable = false)
    private Integer idProveedorProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_compra", nullable = false)
    private double precioCompra;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento_compra", nullable = false)
    private double descuentoCompra;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProveedorProducto")
    private List<Producto> productoList;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public ProveedorProducto() {
    }

    public ProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public ProveedorProducto(Integer idProveedorProducto, double precioCompra, double descuentoCompra) {
        this.idProveedorProducto = idProveedorProducto;
        this.precioCompra = precioCompra;
        this.descuentoCompra = descuentoCompra;
    }

    public Integer getIdProveedorProducto() {
        return idProveedorProducto;
    }

    public void setIdProveedorProducto(Integer idProveedorProducto) {
        this.idProveedorProducto = idProveedorProducto;
    }

    public double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public double getDescuentoCompra() {
        return descuentoCompra;
    }

    public void setDescuentoCompra(double descuentoCompra) {
        this.descuentoCompra = descuentoCompra;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
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
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto[ idProveedorProducto=" + idProveedorProducto + " ]";
    }
    
}
