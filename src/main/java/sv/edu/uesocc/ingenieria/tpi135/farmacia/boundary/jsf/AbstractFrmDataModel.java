package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;

/**
 *
 * @author jonahdz
 */
public abstract class AbstractFrmDataModel<T> {

    protected LazyDataModel<T> lazymodel;
    protected T registro;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    protected EstadosCRUD stdCrud;

    public enum EstadosCRUD {
        NONE, EDITAR, NUEVO, ELIMINAR, ADD;
    }

    public EstadosCRUD getEstado() {
        return stdCrud;
    }
    
    public void nuevoEstado() {
        stdCrud = EstadosCRUD.NUEVO;
        this.registro = registroNew();
    }
    
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    @PostConstruct
    protected void inicializar(){
        this.inicio();
        stdCrud = EstadosCRUD.NONE;
    }
    
    protected void inicio() {
        try {
            this.lazymodel = new LazyDataModel<T>() {
                
                @Override
                public T getRowData(String rowKey) {
                    return datosPorClave(rowKey);
                }

                @Override
                public Object getRowKey(T object) {
                    return clavePorDatos(object);
                }

                @Override
                public List<T> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    return loadDatos(first, pageSize, sortField, sortOrder, filters);
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public List<T> loadDatos(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        List salida = null;
        try {
            if (getFacade() != null) {
                salida = getFacade().findRange(first, pageSize);
                if (this.lazymodel != null) {
                    this.lazymodel.setRowCount(getFacade().count());
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            if (salida == null) {
                salida = new ArrayList();
            }
        }
        return salida;
    }
    
    public abstract T registroNew();
    
    protected abstract AbstractFacade<T> getFacade();

    public abstract T datosPorClave(String rowKey);

    public abstract Object clavePorDatos(T Object);
    
    public void guardar(){
        if(getFacade()!=null){
            try{
                getFacade().create(registro);
                addMessage("Registro Guardado");
            }catch(Exception ex){
                System.out.println("ERROR: "+ex);
                addMessage("Fallo Guardar Registro");
            }
        }
        limpiar();
    }
    
    public void editar(){
        if(getFacade()!=null){
            try{
                getFacade().edit(this.registro);
                addMessage("Registro Editado");
            }catch(Exception ex){
                System.out.println("ERROR: "+ex);
                addMessage("Fallo Editar Registro");
            }
        }
        limpiar();
    }
    
    public void eliminar(){
        if(getFacade()!=null){
            try{
                getFacade().remove(this.registro);
                addMessage("Registro Eliminado");
            }catch(Exception ex){
                System.out.println("ERROR: "+ex);
                addMessage("Fallo Eliminar Registro");
            }
        }
        limpiar();
    }
    
    public void cambiarSeleccion(){
        this.botones = true;
        this.botonAgregar = false;
        stdCrud = EstadosCRUD.EDITAR;
    }
    
    public void limpiar(){
        this.registro = registroNew();
        this.botones = false;
        this.botonAgregar = true;
    }
    
    public void btnCancelar(){
        this.registro = registroNew();
        stdCrud = EstadosCRUD.NONE;
        this.botones = false;
        this.botonAgregar = true;
    }

    public LazyDataModel<T> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<T> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public T getRegistro() {
        return registro;
    }

    public void setRegistro(T registro) {
        this.registro = registro;
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

    public EstadosCRUD getStdCrud() {
        return stdCrud;
    }

    public void setStdCrud(EstadosCRUD stdCrud) {
        this.stdCrud = stdCrud;
    }
    
    
}
