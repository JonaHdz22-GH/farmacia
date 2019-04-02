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
@Table(name = "forma_pago", catalog = "farmacia", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FormaPago.findAll", query = "SELECT f FROM FormaPago f")
    , @NamedQuery(name = "FormaPago.findByIdFormaPago", query = "SELECT f FROM FormaPago f WHERE f.idFormaPago = :idFormaPago")
    , @NamedQuery(name = "FormaPago.findByFormaPago", query = "SELECT f FROM FormaPago f WHERE f.formaPago = :formaPago")
    , @NamedQuery(name = "FormaPago.findByEstado", query = "SELECT f FROM FormaPago f WHERE f.estado = :estado")})
public class FormaPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_forma_pago", nullable = false)
    private Integer idFormaPago;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "forma_pago", nullable = false, length = 45)
    private String formaPago;
    @Column(name = "estado")
    private Boolean estado;
    @Lob
    @Size(max = 65535)
    @Column(name = "descripcion", length = 65535)
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFormaPago")
    private List<Pago> pagoList;

    public FormaPago() {
    }

    public FormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public FormaPago(Integer idFormaPago, String formaPago) {
        this.idFormaPago = idFormaPago;
        this.formaPago = formaPago;
    }

    public Integer getIdFormaPago() {
        return idFormaPago;
    }

    public void setIdFormaPago(Integer idFormaPago) {
        this.idFormaPago = idFormaPago;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
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
    public List<Pago> getPagoList() {
        return pagoList;
    }

    public void setPagoList(List<Pago> pagoList) {
        this.pagoList = pagoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormaPago != null ? idFormaPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPago)) {
            return false;
        }
        FormaPago other = (FormaPago) object;
        if ((this.idFormaPago == null && other.idFormaPago != null) || (this.idFormaPago != null && !this.idFormaPago.equals(other.idFormaPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago[ idFormaPago=" + idFormaPago + " ]";
    }
    
}
