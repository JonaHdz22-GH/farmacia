/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonahdz
 */
@Entity
@Table(name = "producto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Producto.findAll", query = "SELECT p FROM Producto p")
    , @NamedQuery(name = "Producto.findByIdProducto", query = "SELECT p FROM Producto p WHERE p.idProducto = :idProducto")
    , @NamedQuery(name = "Producto.findByNombre", query = "SELECT p FROM Producto p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Producto.findByPrecio", query = "SELECT p FROM Producto p WHERE p.precio = :precio")
    , @NamedQuery(name = "Producto.findByFechaFabricacion", query = "SELECT p FROM Producto p WHERE p.fechaFabricacion = :fechaFabricacion")
    , @NamedQuery(name = "Producto.findByFechaVencimiento", query = "SELECT p FROM Producto p WHERE p.fechaVencimiento = :fechaVencimiento")
    , @NamedQuery(name = "Producto.findByDescripcion", query = "SELECT p FROM Producto p WHERE p.descripcion = :descripcion")})
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto", nullable = false)
    private Integer idProducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio", nullable = false)
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fabricacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFabricacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<DetalleProducto> detalleProductoList;
    @JoinColumn(name = "id_descuento", referencedColumnName = "id_descuento", nullable = false)
    @ManyToOne(optional = false)
    private Descuento idDescuento;
    @JoinColumn(name = "id_presentacion", referencedColumnName = "id_presentacion", nullable = false)
    @ManyToOne(optional = false)
    private PresentacionProducto idPresentacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<DetalleVenta> detalleVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<ProveedorProducto> proveedorProductoList;

    public Producto() {
    }

    public Producto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public Producto(Integer idProducto, String nombre, double precio, Date fechaFabricacion, Date fechaVencimiento) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.fechaFabricacion = fechaFabricacion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(Date fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DetalleProducto> getDetalleProductoList() {
        return detalleProductoList;
    }

    public void setDetalleProductoList(List<DetalleProducto> detalleProductoList) {
        this.detalleProductoList = detalleProductoList;
    }

    public Descuento getIdDescuento() {
        return idDescuento;
    }

    public void setIdDescuento(Descuento idDescuento) {
        this.idDescuento = idDescuento;
    }

    public PresentacionProducto getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(PresentacionProducto idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    @XmlTransient
    public List<DetalleVenta> getDetalleVentaList() {
        return detalleVentaList;
    }

    public void setDetalleVentaList(List<DetalleVenta> detalleVentaList) {
        this.detalleVentaList = detalleVentaList;
    }

    @XmlTransient
    public List<ProveedorProducto> getProveedorProductoList() {
        return proveedorProductoList;
    }

    public void setProveedorProductoList(List<ProveedorProducto> proveedorProductoList) {
        this.proveedorProductoList = proveedorProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProducto != null ? idProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.idProducto == null && other.idProducto != null) || (this.idProducto != null && !this.idProducto.equals(other.idProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.datos.definicion.Producto[ idProducto=" + idProducto + " ]";
    }
    
}
