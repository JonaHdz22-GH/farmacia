package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;

/**
 *
 * @author jonahdz
 * @param <T>
 */
@Dependent
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
        } catch (Exception ex) {
            throw ex;
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
            throw ex;
        }finally {
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
        if(getFacade() != null){
            try{
                getFacade().create(registro);
            }catch(Exception ex){
                throw ex;
            }
        }
        limpiar();
    }
    
    public void editar(){
        if(getFacade()!=null){
            try{
                getFacade().edit(registro);
            }catch(Exception ex){
                throw ex;
            }
        }
        limpiar();
    }
    
    public void eliminar(){
        if(getFacade()!=null){
            try{
                getFacade().remove(registro);
            }catch(Exception ex){
                throw ex;
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
