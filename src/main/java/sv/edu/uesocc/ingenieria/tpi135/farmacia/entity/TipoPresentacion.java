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
import javax.persistence.Lob;
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
@Table(name = "tipo_presentacion", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPresentacion.findAll", query = "SELECT t FROM TipoPresentacion t")
    , @NamedQuery(name = "TipoPresentacion.findByIdTipoPresentacion", query = "SELECT t FROM TipoPresentacion t WHERE t.idTipoPresentacion = :idTipoPresentacion")
    , @NamedQuery(name = "TipoPresentacion.findByNombre", query = "SELECT t FROM TipoPresentacion t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TipoPresentacion.findByEstado", query = "SELECT t FROM TipoPresentacion t WHERE t.estado = :estado")})
public class TipoPresentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_tipo_presentacion", nullable = false)
    private Integer idTipoPresentacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;
    @Column(name = "estado")
    private Boolean estado;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idTipoPresentacion")
    private List<PresentacionProducto> presentacionProductoList;

    public TipoPresentacion() {
    }

    public TipoPresentacion(Integer idTipoPresentacion) {
        this.idTipoPresentacion = idTipoPresentacion;
    }

    public TipoPresentacion(Integer idTipoPresentacion, String nombre) {
        this.idTipoPresentacion = idTipoPresentacion;
        this.nombre = nombre;
    }

    public Integer getIdTipoPresentacion() {
        return idTipoPresentacion;
    }

    public void setIdTipoPresentacion(Integer idTipoPresentacion) {
        this.idTipoPresentacion = idTipoPresentacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<PresentacionProducto> getPresentacionProductoList() {
        return presentacionProductoList;
    }

    public void setPresentacionProductoList(List<PresentacionProducto> presentacionProductoList) {
        this.presentacionProductoList = presentacionProductoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoPresentacion != null ? idTipoPresentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPresentacion)) {
            return false;
        }
        TipoPresentacion other = (TipoPresentacion) object;
        if ((this.idTipoPresentacion == null && other.idTipoPresentacion != null) || (this.idTipoPresentacion != null && !this.idTipoPresentacion.equals(other.idTipoPresentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion[ idTipoPresentacion=" + idTipoPresentacion + " ]";
    }
    
}
