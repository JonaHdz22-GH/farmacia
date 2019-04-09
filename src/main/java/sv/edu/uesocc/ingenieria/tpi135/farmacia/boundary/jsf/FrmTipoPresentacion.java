/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoPresentacionFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmTipoPresentacion implements Serializable{
        
    @Inject
    private TipoPresentacionFacade tpr;
    private LazyDataModel<TipoPresentacion> lazymodel;
    private TipoPresentacion registrotpr;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    @PostConstruct
    private void inicio() {

        registrotpr = new TipoPresentacion();

        try {
            this.lazymodel = new LazyDataModel<TipoPresentacion>() {
                
                @Override
                public Object getRowKey(TipoPresentacion object) {
                    if (object != null) {
                        return object.getIdTipoPresentacion();
                    }
                    return null;
                }
                
                @Override
                public TipoPresentacion getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (TipoPresentacion reg : (List<TipoPresentacion>) getWrappedData()) {
                                if (reg.getIdTipoPresentacion().compareTo(buscado) == 0) {
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
                public List<TipoPresentacion> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<TipoPresentacion> salida = new ArrayList();
                    try {
                        if (tpr != null) {
                            this.setRowCount(tpr.count());
                            salida = tpr.findRange(first, pageSize);
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
        if(tpr != null){
            try{
                tpr.create(this.registrotpr);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(tpr != null){
            try{
                tpr.edit(this.registrotpr);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(tpr != null){
            try{
                tpr.remove(this.registrotpr);
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
        this.registrotpr = new TipoPresentacion();
        this.botones = false;
        this.botonAgregar = true;
    }

    public TipoPresentacionFacade getTpr() {
        return tpr;
    }

    public void setTpr(TipoPresentacionFacade tpr) {
        this.tpr = tpr;
    }

    public LazyDataModel<TipoPresentacion> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<TipoPresentacion> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public TipoPresentacion getRegistrotpr() {
        return registrotpr;
    }

    public void setRegistrotpr(TipoPresentacion registrotpr) {
        this.registrotpr = registrotpr;
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
