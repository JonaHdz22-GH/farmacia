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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jonahdz
 */
@Entity
@Table(name = "presentacion_producto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PresentacionProducto.findAll", query = "SELECT p FROM PresentacionProducto p")
    , @NamedQuery(name = "PresentacionProducto.findByIdPresentacion", query = "SELECT p FROM PresentacionProducto p WHERE p.idPresentacion = :idPresentacion")})
public class PresentacionProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_presentacion", nullable = false)
    private Integer idPresentacion;
    @JoinColumn(name = "id_detalle", referencedColumnName = "id_detalle", nullable = false)
    @ManyToOne(optional = false)
    private Detalle idDetalle;
    @JoinColumn(name = "id_tipo_presentacion", referencedColumnName = "id_tipo_presentacion", nullable = false)
    @ManyToOne(optional = false)
    private TipoPresentacion idTipoPresentacion;

    public PresentacionProducto() {
    }

    public PresentacionProducto(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Integer getIdPresentacion() {
        return idPresentacion;
    }

    public void setIdPresentacion(Integer idPresentacion) {
        this.idPresentacion = idPresentacion;
    }

    public Detalle getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Detalle idDetalle) {
        this.idDetalle = idDetalle;
    }

    public TipoPresentacion getIdTipoPresentacion() {
        return idTipoPresentacion;
    }

    public void setIdTipoPresentacion(TipoPresentacion idTipoPresentacion) {
        this.idTipoPresentacion = idTipoPresentacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresentacion != null ? idPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PresentacionProducto)) {
            return false;
        }
        PresentacionProducto other = (PresentacionProducto) object;
        if ((this.idPresentacion == null && other.idPresentacion != null) || (this.idPresentacion != null && !this.idPresentacion.equals(other.idPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.PresentacionProducto[ idPresentacion=" + idPresentacion + " ]";
    }
    
}
