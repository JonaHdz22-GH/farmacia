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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmContacto implements Serializable {

    @Inject
    private ContactoFacade cof;
    private LazyDataModel<Contacto> lazymodel;
    private Contacto registrocof;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {

        registrocof = new Contacto();

        try {
            this.lazymodel = new LazyDataModel<Contacto>() {
                
                @Override
                public Object getRowKey(Contacto object) {
                    if (object != null) {
                        return object.getIdContacto();
                    }
                    return null;
                }
                
                @Override
                public Contacto getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Contacto reg : (List<Contacto>) getWrappedData()) {
                                if (reg.getIdContacto().compareTo(buscado) == 0) {
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
                public List<Contacto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Contacto> salida = new ArrayList();
                    try {
                        if (cof != null) {
                            this.setRowCount(cof.count());
                            salida = cof.findRange(first, pageSize);
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
    
    public void guardar(){
        if(cof != null){
            try{
                cof.create(this.registrocof);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(cof != null){
            try{
                cof.edit(this.registrocof);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(cof != null){
            try{
                cof.remove(this.registrocof);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    
    public void cambiarSeleccion(){
        this.botones = true;
        this.botonAgregar = false;
    }
    
    public void cancelar(){
        this.registrocof = new Contacto();
        this.botones = false;
        this.botonAgregar = true;
    }

    public ContactoFacade getCof() {
        return cof;
    }

    public void setCof(ContactoFacade cof) {
        this.cof = cof;
    }

    public LazyDataModel<Contacto> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<Contacto> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public Contacto getRegistrocof() {
        return registrocof;
    }

    public void setRegistrocof(Contacto registrocof) {
        this.registrocof = registrocof;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
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
    
    
    
    
    
}
