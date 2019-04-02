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
@Table(name = "medio_contacto", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MedioContacto.findAll", query = "SELECT m FROM MedioContacto m")
    , @NamedQuery(name = "MedioContacto.findByIdMedioContacto", query = "SELECT m FROM MedioContacto m WHERE m.idMedioContacto = :idMedioContacto")})
public class MedioContacto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_medio_contacto", nullable = false)
    private Integer idMedioContacto;
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto", nullable = false)
    @ManyToOne(optional = false)
    private Contacto idContacto;
    @JoinColumn(name = "id_proveedor", referencedColumnName = "id_proveedor", nullable = false)
    @ManyToOne(optional = false)
    private Proveedor idProveedor;

    public MedioContacto() {
    }

    public MedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public Integer getIdMedioContacto() {
        return idMedioContacto;
    }

    public void setIdMedioContacto(Integer idMedioContacto) {
        this.idMedioContacto = idMedioContacto;
    }

    public Contacto getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(Contacto idContacto) {
        this.idContacto = idContacto;
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
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto[ idMedioContacto=" + idMedioContacto + " ]";
    }
    
}
