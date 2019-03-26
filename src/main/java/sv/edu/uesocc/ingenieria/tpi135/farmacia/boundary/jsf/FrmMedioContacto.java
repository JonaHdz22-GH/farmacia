package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractInterface;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.MedioContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author jonahdz
 */

@Named
@ViewScoped
public class FrmMedioContacto extends AbstractInterface<MedioContacto> implements Serializable{
    
    @Inject
    MedioContactoFacade medioContactoFacade;
    private LazyDataModel<MedioContacto> lazymodel;
    private MedioContacto registro;
    private boolean botonAgregar = true;
    private boolean botones = false;
    private boolean seleccion = false;

    @PostConstruct
    private void inicio() {

        registro = new MedioContacto();

        try {
            this.lazymodel = new LazyDataModel<MedioContacto>() {
                
                @Override
                public Object getRowKey(MedioContacto object) {
                    if (object != null) {
                        return object.getIdMedioContacto();
                    }
                    return null;
                }
                
                @Override
                public MedioContacto getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (MedioContacto reg : (List<MedioContacto>) getWrappedData()) {
                                if (reg.getIdMedioContacto().compareTo(buscado) == 0) {
                                    return reg;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }
                
                @Override
                public List<MedioContacto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<MedioContacto> salida = new ArrayList();
                    try {
                        if (medioContactoFacade != null) {
                            this.setRowCount(medioContactoFacade.count());
                            salida = medioContactoFacade.findRange(first, pageSize);
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    
    public void guardar() {
        try {
            if (this.medioContactoFacade != null && this.registro != null ) {
               if (this.medioContactoFacade.create(registro)) {
                    inicio();
                }
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(),exp);
        }
    }

    
    public void Eliminar() {
        try {
            if (this.registro != null && this.medioContactoFacade != null) {
                if (this.medioContactoFacade.remove(registro)) {
                    this.registro = new MedioContacto();
                    this.botones = false;
                    this.botonAgregar = true;
                    inicio();
                }
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(),exp);
        }
    }

    
    public void Modificar() {
        try {
            if (this.registro != null && this.medioContactoFacade != null) {
                if (this.medioContactoFacade.edit(registro)) {
                    this.botones = false;
                    this.botonAgregar = true;
                    inicio();  
                }
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(),exp);
        }
    }

    
    public void cambiarSeleccion() {
        this.botones = true;
        this.botonAgregar = false;    
    }
    
    
    public void cancelar() {
        this.registro = new MedioContacto();
        this.botones=false;
        this.botonAgregar=true;
    }
    
    
    
    
    public MedioContactoFacade getMedioContactoFacade() {
        return medioContactoFacade;
    }

    public void setMedioContactoFacade(MedioContactoFacade medioContactoFacade) {
        this.medioContactoFacade = medioContactoFacade;
    }

    public LazyDataModel<MedioContacto> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<MedioContacto> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public MedioContacto getRegistro() {
        return registro;
    }

    public void setRegistro(MedioContacto registrotev) {
        this.registro = registrotev;
    }

    public boolean isBotonAgregar() {
        return botonAgregar;
    }

    public void setBotonAgregar(boolean botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
    
}
