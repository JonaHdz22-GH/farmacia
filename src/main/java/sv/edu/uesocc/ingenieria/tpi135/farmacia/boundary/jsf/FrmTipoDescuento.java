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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoDescuentoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmTipoDescuento implements Serializable{
    
    @Inject
    private TipoDescuentoFacade tde;
    private LazyDataModel<TipoDescuento> lazymodel;
    private TipoDescuento registrotde;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {

        registrotde = new TipoDescuento();

        try {
            this.lazymodel = new LazyDataModel<TipoDescuento>() {
                
                @Override
                public Object getRowKey(TipoDescuento object) {
                    if (object != null) {
                        return object.getIdTipoDescuento();
                    }
                    return null;
                }
                
                @Override
                public TipoDescuento getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (TipoDescuento reg : (List<TipoDescuento>) getWrappedData()) {
                                if (reg.getIdTipoDescuento().compareTo(buscado) == 0) {
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
                public List<TipoDescuento> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<TipoDescuento> salida = new ArrayList();
                    try {
                        if (tde != null) {
                            this.setRowCount(tde.count());
                            salida = tde.findRange(first, pageSize);
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
        if(tde != null){
            try{
                tde.create(this.registrotde);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(tde != null){
            try{
                tde.edit(this.registrotde);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(tde != null){
            try{
                tde.remove(this.registrotde);
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
        this.registrotde = new TipoDescuento();
        this.botones = false;
        this.botonAgregar = true;
    }

    public TipoDescuentoFacade getTde() {
        return tde;
    }

    public void setTde(TipoDescuentoFacade tde) {
        this.tde = tde;
    }

    public LazyDataModel<TipoDescuento> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<TipoDescuento> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public TipoDescuento getRegistrotde() {
        return registrotde;
    }

    public void setRegistrotde(TipoDescuento registrotde) {
        this.registrotde = registrotde;
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
