/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.entity;

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
@Table(name = "detalle_producto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleProducto.findAll", query = "SELECT d FROM DetalleProducto d")
    , @NamedQuery(name = "DetalleProducto.findByIdDetalleProducto", query = "SELECT d FROM DetalleProducto d WHERE d.idDetalleProducto = :idDetalleProducto")
    , @NamedQuery(name = "DetalleProducto.findByDisponible", query = "SELECT d FROM DetalleProducto d WHERE d.disponible = :disponible")
    , @NamedQuery(name = "DetalleProducto.findByCantidad", query = "SELECT d FROM DetalleProducto d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "DetalleProducto.findByFormula", query = "SELECT d FROM DetalleProducto d WHERE d.formula = :formula")
    , @NamedQuery(name = "DetalleProducto.findByLaboratorio", query = "SELECT d FROM DetalleProducto d WHERE d.laboratorio = :laboratorio")
    , @NamedQuery(name = "DetalleProducto.findByIndicaciones", query = "SELECT d FROM DetalleProducto d WHERE d.indicaciones = :indicaciones")
    , @NamedQuery(name = "DetalleProducto.findByContraindicaciones", query = "SELECT d FROM DetalleProducto d WHERE d.contraindicaciones = :contraindicaciones")
    , @NamedQuery(name = "DetalleProducto.findByPrecauciones", query = "SELECT d FROM DetalleProducto d WHERE d.precauciones = :precauciones")
    , @NamedQuery(name = "DetalleProducto.findByObservaciones", query = "SELECT d FROM DetalleProducto d WHERE d.observaciones = :observaciones")})
public class DetalleProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle_producto", nullable = false)
    private Integer idDetalleProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "disponible", nullable = false)
    private boolean disponible;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad", nullable = false)
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "formula", nullable = false, length = 255)
    private String formula;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "laboratorio", nullable = false, length = 45)
    private String laboratorio;
    @Size(max = 255)
    @Column(name = "indicaciones", length = 255)
    private String indicaciones;
    @Size(max = 255)
    @Column(name = "contraindicaciones", length = 255)
    private String contraindicaciones;
    @Size(max = 255)
    @Column(name = "precauciones", length = 255)
    private String precauciones;
    @Size(max = 255)
    @Column(name = "observaciones", length = 255)
    private String observaciones;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto", nullable = false)
    @ManyToOne(optional = false)
    private Producto idProducto;

    public DetalleProducto() {
    }

    public DetalleProducto(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public DetalleProducto(Integer idDetalleProducto, boolean disponible, int cantidad, String formula, String laboratorio) {
        this.idDetalleProducto = idDetalleProducto;
        this.disponible = disponible;
        this.cantidad = cantidad;
        this.formula = formula;
        this.laboratorio = laboratorio;
    }

    public Integer getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(Integer idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    public boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    public String getContraindicaciones() {
        return contraindicaciones;
    }

    public void setContraindicaciones(String contraindicaciones) {
        this.contraindicaciones = contraindicaciones;
    }

    public String getPrecauciones() {
        return precauciones;
    }

    public void setPrecauciones(String precauciones) {
        this.precauciones = precauciones;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleProducto != null ? idDetalleProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleProducto)) {
            return false;
        }
        DetalleProducto other = (DetalleProducto) object;
        if ((this.idDetalleProducto == null && other.idDetalleProducto != null) || (this.idDetalleProducto != null && !this.idDetalleProducto.equals(other.idDetalleProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.datos.definicion.DetalleProducto[ idDetalleProducto=" + idDetalleProducto + " ]";
    }
    
}
