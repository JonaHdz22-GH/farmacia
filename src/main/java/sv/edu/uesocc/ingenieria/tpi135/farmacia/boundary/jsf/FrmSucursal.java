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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmSucursal implements Serializable{
    
    @Inject
    private SucursalFacade suc;
    private LazyDataModel<Sucursal> lazymodel;
    private Sucursal registrosuc;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {

        registrosuc = new Sucursal();

        try {
            this.lazymodel = new LazyDataModel<Sucursal>() {
                
                @Override
                public Object getRowKey(Sucursal object) {
                    if (object != null) {
                        return object.getIdSucursal();
                    }
                    return null;
                }
                
                @Override
                public Sucursal getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Sucursal reg : (List<Sucursal>) getWrappedData()) {
                                if (reg.getIdSucursal().compareTo(buscado) == 0) {
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
                public List<Sucursal> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Sucursal> salida = new ArrayList();
                    try {
                        if (suc != null) {
                            this.setRowCount(suc.count());
                            salida = suc.findRange(first, pageSize);
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
        if(suc != null){
            try{
                suc.create(this.registrosuc);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(suc != null){
            try{
                suc.edit(this.registrosuc);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(suc != null){
            try{
                suc.remove(this.registrosuc);
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
        this.registrosuc = new Sucursal();
        this.botones = false;
        this.botonAgregar = true;
    }

    public SucursalFacade getSuc() {
        return suc;
    }

    public void setSuc(SucursalFacade suc) {
        this.suc = suc;
    }

    public LazyDataModel<Sucursal> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<Sucursal> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public Sucursal getRegistrosuc() {
        return registrosuc;
    }

    public void setRegistrosuc(Sucursal registrosuc) {
        this.registrosuc = registrosuc;
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
