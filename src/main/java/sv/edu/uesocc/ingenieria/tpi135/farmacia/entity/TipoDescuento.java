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
@Table(name = "tipo_descuento", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoDescuento.findAll", query = "SELECT t FROM TipoDescuento t")
    , @NamedQuery(name = "TipoDescuento.findByIdTipoDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.idTipoDescuento = :idTipoDescuento")
    , @NamedQuery(name = "TipoDescuento.findByTipoDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.tipoDescuento = :tipoDescuento")
    , @NamedQuery(name = "TipoDescuento.findByDescuento", query = "SELECT t FROM TipoDescuento t WHERE t.descuento = :descuento")
    , @NamedQuery(name = "TipoDescuento.findByDescripcion", query = "SELECT t FROM TipoDescuento t WHERE t.descripcion = :descripcion")})
public class TipoDescuento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_descuento", nullable = false)
    private Integer idTipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_descuento", nullable = false, length = 45)
    private String tipoDescuento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "descuento", nullable = false)
    private double descuento;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoDescuento")
    private List<Descuento> descuentoList;

    public TipoDescuento() {
    }

    public TipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public TipoDescuento(Integer idTipoDescuento, String tipoDescuento, double descuento) {
        this.idTipoDescuento = idTipoDescuento;
        this.tipoDescuento = tipoDescuento;
        this.descuento = descuento;
    }

    public Integer getIdTipoDescuento() {
        return idTipoDescuento;
    }

    public void setIdTipoDescuento(Integer idTipoDescuento) {
        this.idTipoDescuento = idTipoDescuento;
    }

    public String getTipoDescuento() {
        return tipoDescuento;
    }

    public void setTipoDescuento(String tipoDescuento) {
        this.tipoDescuento = tipoDescuento;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Descuento> getDescuentoList() {
        return descuentoList;
    }

    public void setDescuentoList(List<Descuento> descuentoList) {
        this.descuentoList = descuentoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoDescuento != null ? idTipoDescuento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoDescuento)) {
            return false;
        }
        TipoDescuento other = (TipoDescuento) object;
        if ((this.idTipoDescuento == null && other.idTipoDescuento != null) || (this.idTipoDescuento != null && !this.idTipoDescuento.equals(other.idTipoDescuento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento[ idTipoDescuento=" + idTipoDescuento + " ]";
    }
    
}
