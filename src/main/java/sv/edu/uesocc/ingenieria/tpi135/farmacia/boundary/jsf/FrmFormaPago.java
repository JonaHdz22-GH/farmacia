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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.FormaPagoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmFormaPago implements Serializable{
    
     @Inject
    private FormaPagoFacade fpa;
    private LazyDataModel<FormaPago> lazymodel;
    private FormaPago registrofpa;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {

        registrofpa = new FormaPago();

        try {
            this.lazymodel = new LazyDataModel<FormaPago>() {
                
                @Override
                public Object getRowKey(FormaPago object) {
                    if (object != null) {
                        return object.getIdFormaPago();
                    }
                    return null;
                }
                
                @Override
                public FormaPago getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (FormaPago reg : (List<FormaPago>) getWrappedData()) {
                                if (reg.getIdFormaPago().compareTo(buscado) == 0) {
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
                public List<FormaPago> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<FormaPago> salida = new ArrayList();
                    try {
                        if (fpa != null) {
                            this.setRowCount(fpa.count());
                            salida = fpa.findRange(first, pageSize);
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
        if(fpa != null){
            try{
                fpa.create(this.registrofpa);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(fpa != null){
            try{
                fpa.edit(this.registrofpa);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(fpa != null){
            try{
                fpa.remove(this.registrofpa);
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
        this.registrofpa = new FormaPago();
        this.botones = false;
        this.botonAgregar = true;
    }

    public FormaPagoFacade getFpa() {
        return fpa;
    }

    public void setFpa(FormaPagoFacade fpa) {
        this.fpa = fpa;
    }

    public LazyDataModel<FormaPago> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<FormaPago> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public FormaPago getRegistrofpa() {
        return registrofpa;
    }

    public void setRegistrofpa(FormaPago registrofpa) {
        this.registrofpa = registrofpa;
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
