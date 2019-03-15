/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.definicion;

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
@Table(name = "medio_contacto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioContacto.findAll", query = "SELECT m FROM MedioContacto m")
    , @NamedQuery(name = "MedioContacto.findByIdMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.idMedioContacto = :idMedioContacto")
    , @NamedQuery(name = "MedioContacto.findByMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.medioContacto = :medioContacto")
    , @NamedQuery(name = "MedioContacto.findByDescripcion", query = "SELECT m FROM MedioContacto m WHERE m.descripcion = :descripcion")})
public class MedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private Integer idMedioContacto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "medio_contacto", nullable = false, length = 45)
    private String medioContacto;
    @Size(max = 255)
    @Column(name = "descripcion", length = 255)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedioContacto")
    private List<Contacto> contactoList;

    public MedioContacto() {
    }

    public MedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public MedioContacto(Integer idMedioContacto, String medioContacto) {
        this.idMedioContacto = idMedioContacto;
        this.medioContacto = medioContacto;
    }

    public Integer getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public String getMedioContacto() {
        return medioContacto;
    }

    public void setMedioContacto(String medioContacto) {
        this.medioContacto = medioContacto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<Contacto> getContactoList() {
        return contactoList;
    }

    public void setContactoList(List<Contacto> contactoList) {
        this.contactoList = contactoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMedioContacto != null ? idMedioContacto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedioContacto)) {
            return false;
        }
        MedioContacto other = (MedioContacto) object;
        if ((this.idMedioContacto == null && other.idMedioContacto != null) || (this.idMedioContacto != null && !this.idMedioContacto.equals(other.idMedioContacto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.datos.definicion.MedioContacto[ idMedioContacto=" + idMedioContacto + " ]";
    }
    
}
