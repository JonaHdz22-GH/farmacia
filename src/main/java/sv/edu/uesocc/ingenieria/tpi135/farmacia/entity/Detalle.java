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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jonahdz
 */
@Entity
@Table(name = "detalle", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Detalle.findAll", query = "SELECT d FROM Detalle d")
    , @NamedQuery(name = "Detalle.findByIdDetalle", query = "SELECT d FROM Detalle d WHERE d.idDetalle = :idDetalle")
    , @NamedQuery(name = "Detalle.findByFormula", query = "SELECT d FROM Detalle d WHERE d.formula = :formula")
    , @NamedQuery(name = "Detalle.findByNombreLaboratorio", query = "SELECT d FROM Detalle d WHERE d.nombreLaboratorio = :nombreLaboratorio")
    , @NamedQuery(name = "Detalle.findByIndicaciones", query = "SELECT d FROM Detalle d WHERE d.indicaciones = :indicaciones")
    , @NamedQuery(name = "Detalle.findByPrecauciones", query = "SELECT d FROM Detalle d WHERE d.precauciones = :precauciones")})
public class Detalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_detalle", nullable = false)
    private Integer idDetalle;
    @Size(max = 45)
    @Column(name = "formula", length = 45)
    private String formula;
    @Size(max = 45)
    @Column(name = "nombre_laboratorio", length = 45)
    private String nombreLaboratorio;
    @Size(max = 300)
    @Column(name = "indicaciones", length = 300)
    private String indicaciones;
    @Size(max = 300)
    @Column(name = "precauciones", length = 300)
    private String precauciones;
    @Lob
    @Size(max = 65535)
    @Column(name = "observaciones", length = 65535)
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDetalle")
    private List<PresentacionProducto> presentacionProductoList;
    @JoinColumn(name = "id_detalle_producto", referencedColumnName = "id_detalle_producto", nullable = false)
    @ManyToOne(optional = false)
    private DetalleProducto idDetalleProducto;

    public Detalle() {
    }

    public Detalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Integer getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Integer idDetalle) {
        this.idDetalle = idDetalle;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
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

    @XmlTransient
    public List<PresentacionProducto> getPresentacionProductoList() {
        return presentacionProductoList;
    }

    public void setPresentacionProductoList(List<PresentacionProducto> presentacionProductoList) {
        this.presentacionProductoList = presentacionProductoList;
    }

    public DetalleProducto getIdDetalleProducto() {
        return idDetalleProducto;
    }

    public void setIdDetalleProducto(DetalleProducto idDetalleProducto) {
        this.idDetalleProducto = idDetalleProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalle != null ? idDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detalle)) {
            return false;
        }
        Detalle other = (Detalle) object;
        if ((this.idDetalle == null && other.idDetalle != null) || (this.idDetalle != null && !this.idDetalle.equals(other.idDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Detalle[ idDetalle=" + idDetalle + " ]";
    }
    
}
