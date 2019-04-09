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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmProducto implements Serializable{
    
    @Inject
    ProveedorProductoFacade proveedorProductoFacade;
    @Inject
    ProductoFacade productoFacade;
    
    protected List<ProveedorProducto> listaProveedorProducto;
    private LazyDataModel<Producto> lazymodel;
    private Producto registro;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    
    @PostConstruct
    private void inicio() {
        
        try{
            this.listaProveedorProducto = proveedorProductoFacade.findAll();
        }catch(Exception ex){
            this.listaProveedorProducto = Collections.EMPTY_LIST;
        }
        
        registro = new Producto();

        try {
            this.lazymodel = new LazyDataModel<Producto>() {
                
                @Override
                public Object getRowKey(Producto object) {
                    if (object != null) {
                        return object.getIdProducto();
                    }
                    return null;
                }
                
                @Override
                public Producto getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Producto reg : (List<Producto>) getWrappedData()) {
                                if (reg.getIdProducto().compareTo(buscado) == 0) {
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
                public List<Producto> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Producto> salida = new ArrayList();
                    try {
                        if (productoFacade != null) {
                            this.setRowCount(productoFacade.count());
                            salida = productoFacade.findRange(first, pageSize);
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
        if(productoFacade != null){
            try{
                productoFacade.create(this.registro);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(productoFacade != null){
            try{
                productoFacade.edit(this.registro);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(productoFacade != null){
            try{
                productoFacade.remove(this.registro);
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
        this.registro = new Producto();
        this.botones = false;
        this.botonAgregar = true;
    }
    
    public Integer getIdProveedorProductoSeleccionado() {
        if (this.registro != null && this.registro.getIdProveedorProducto() != null) {
            return this.registro.getIdProveedorProducto().getIdProveedorProducto();
        }
        return null;
    }
    
    public void setIdProveedorProductoSeleccionado(Integer idProveedorProductoSeleccionado) {
        if (this.registro != null && this.listaProveedorProducto != null) {
            try {
                this.registro.setIdProveedorProducto(this.listaProveedorProducto.stream().filter(r -> r.getIdProveedorProducto().compareTo(idProveedorProductoSeleccionado) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {

            }
        }
    }

    public ProveedorProductoFacade getProveedorProductoFacade() {
        return proveedorProductoFacade;
    }

    public void setProveedorProductoFacade(ProveedorProductoFacade proveedorProductoFacade) {
        this.proveedorProductoFacade = proveedorProductoFacade;
    }

    public ProductoFacade getProductoFacade() {
        return productoFacade;
    }

    public void setProductoFacade(ProductoFacade productoFacade) {
        this.productoFacade = productoFacade;
    }

    public List<ProveedorProducto> getListaProveedorProducto() {
        return listaProveedorProducto;
    }

    public void setListaProveedorProducto(List<ProveedorProducto> listaProveedorProducto) {
        this.listaProveedorProducto = listaProveedorProducto;
    }

    public LazyDataModel<Producto> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<Producto> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public Producto getRegistro() {
        return registro;
    }

    public void setRegistro(Producto registro) {
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
