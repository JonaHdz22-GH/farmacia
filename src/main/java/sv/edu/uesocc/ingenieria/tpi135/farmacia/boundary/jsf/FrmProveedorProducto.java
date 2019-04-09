/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmProveedorProducto implements Serializable{
    
    @Inject
    ProveedorFacade proveedorFacade;
    @Inject
    ProveedorProductoFacade proveedorProductofacade;
    
    protected List<Proveedor> listaProveedor;
    private LazyDataModel<ProveedorProducto> lazymodel;
    private ProveedorProducto registro;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {
        
        try{
            this.listaProveedor = proveedorFacade.findAll();
        }catch(Exception ex){
            this.listaProveedor = Collections.EMPTY_LIST;
        }
        
        registro = new ProveedorProducto();

        try {
            this.lazymodel = new LazyDataModel<ProveedorProducto>() {
                
                @Override
                public Object getRowKey(ProveedorProducto object) {
                    if (object != null) {
                        return object.getIdProveedorProducto();
                    }
                    return null;
                }
                
                @Override
                public ProveedorProducto getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (ProveedorProducto reg : (List<ProveedorProducto>) getWrappedData()) {
                                if (reg.getIdProveedorProducto().compareTo(buscado) == 0) {
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
                public List<ProveedorProducto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<ProveedorProducto> salida = new ArrayList();
                    try {
                        if (proveedorProductofacade != null) {
                            this.setRowCount(proveedorProductofacade.count());
                            salida = proveedorProductofacade.findRange(first, pageSize);
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
        if(proveedorProductofacade != null){
            try{
                proveedorProductofacade.create(this.registro);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(proveedorProductofacade != null){
            try{
                proveedorProductofacade.edit(this.registro);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(proveedorProductofacade != null){
            try{
                proveedorProductofacade.remove(this.registro);
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
        this.registro = new ProveedorProducto();
        this.botones = false;
        this.botonAgregar = true;
    }
    
    public Integer getIdProveedorSeleccionado() {
        if (this.registro != null && this.registro.getIdProveedor()!= null) {
            return this.registro.getIdProveedor().getIdProveedor();
        }
        return null;
    }
    
    public void setIdProveedorSeleccionado(Integer idProveedorSeleccionado) {
        if (this.registro != null && this.listaProveedor != null) {
            try {
                this.registro.setIdProveedor(this.listaProveedor.stream().filter(r -> r.getIdProveedor().compareTo(idProveedorSeleccionado) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
    }

    public ProveedorFacade getProveedorFacaded() {
        return proveedorFacade;
    }

    public void setProveedorFacaded(ProveedorFacade proveedorFacade) {
        this.proveedorFacade = proveedorFacade;
    }

    public ProveedorProductoFacade getProveedorProductofacade() {
        return proveedorProductofacade;
    }

    public void setProveedorProductofacade(ProveedorProductoFacade proveedorProductofacade) {
        this.proveedorProductofacade = proveedorProductofacade;
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }

    public void setListaProveedor(List<Proveedor> listaProveedor) {
        this.listaProveedor = listaProveedor;
    }

    public LazyDataModel<ProveedorProducto> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<ProveedorProducto> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public ProveedorProducto getRegistro() {
        return registro;
    }

    public void setRegistro(ProveedorProducto registro) {
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
    
    
    
}
