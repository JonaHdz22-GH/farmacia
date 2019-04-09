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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmProveedor implements Serializable{
    
    @Inject
    private ProveedorFacade prv;
    private LazyDataModel<Proveedor> lazymodel;
    private Proveedor registroprv;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {

        registroprv = new Proveedor();

        try {
            this.lazymodel = new LazyDataModel<Proveedor>() {
                
                @Override
                public Object getRowKey(Proveedor object) {
                    if (object != null) {
                        return object.getIdProveedor();
                    }
                    return null;
                }
                
                @Override
                public Proveedor getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Proveedor reg : (List<Proveedor>) getWrappedData()) {
                                if (reg.getIdProveedor().compareTo(buscado) == 0) {
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
                public List<Proveedor> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Proveedor> salida = new ArrayList();
                    try {
                        if (prv != null) {
                            this.setRowCount(prv.count());
                            salida = prv.findRange(first, pageSize);
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
        if(prv != null){
            try{
                prv.create(this.registroprv);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(prv != null){
            try{
                prv.edit(this.registroprv);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(prv != null){
            try{
                prv.remove(this.registroprv);
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
        this.registroprv = new Proveedor();
        this.botones = false;
        this.botonAgregar = true;
    }

    public ProveedorFacade getPrv() {
        return prv;
    }

    public void setPrv(ProveedorFacade prv) {
        this.prv = prv;
    }

    public LazyDataModel<Proveedor> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<Proveedor> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public Proveedor getRegistroprv() {
        return registroprv;
    }

    public void setRegistroprv(Proveedor registroprv) {
        this.registroprv = registroprv;
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
