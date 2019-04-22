package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.InventarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmInventario extends AbstractFrmDataModel<Inventario> implements Serializable {
    
    @Inject
    InventarioFacade inventarioFacade;
    @Inject
    ProductoFacade productoFacade;
    @Inject
    SucursalFacade sucursalFacade;
    
    protected List<Producto> listaProducto;
    protected List<Sucursal> listaSucursal;
    
    
    @Override
    @PostConstruct
    public void inicializar() {
        super.inicializar();
        this.inicioProducto();
        this.inicioSucursal();
    }
    
    public void inicioProducto(){
        try{
            this.listaProducto = productoFacade.findAll();
        }catch(Exception ex){
            this.listaProducto = Collections.EMPTY_LIST;
        }
    }
    
    public void inicioSucursal(){
        try{
            this.listaSucursal = sucursalFacade.findAll();
        }catch(Exception ex){
            this.listaSucursal = Collections.EMPTY_LIST;
        }
    }
    
    public Integer getIdProductoSeleccionado() {
        if (this.registro != null && this.registro.getIdProducto()!= null) {
            return this.registro.getIdProducto().getIdProducto();
        }
        return null;
    }
    
    public void setIdProductoSeleccionado(Integer idProductoSeleccionado) {
        if (this.registro != null && this.listaProducto != null) {
            try {
                this.registro.setIdProducto(this.listaProducto.stream().filter(r -> r.getIdProducto().compareTo(idProductoSeleccionado) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {
                throw ex;
            }
        }
    }
    
    public Integer getIdSucursalSeleccionado() {
        if (this.registro != null && this.registro.getIdSucursal()!= null) {
            return this.registro.getIdSucursal().getIdSucursal();
        }
        return null;
    }
    
    public void setIdSucursalSeleccionado(Integer idSucursalSeleccionado) {
        if (this.registro != null && this.listaSucursal != null) {
            try {
                this.registro.setIdSucursal(this.listaSucursal.stream().filter(r -> r.getIdSucursal().compareTo(idSucursalSeleccionado) == 0).collect(Collectors.toList()).get(0));
            } catch (Exception ex) {
                throw ex;
            }
        }
    }
   
    @Override
    public Object clavePorDatos(Inventario object) {
        if (object != null) {
            return object.getIdInventario();
        }
        return null;
    }
    
    
    @Override
    public Inventario datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdInventario().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {
                throw new IllegalStateException();
            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return inventarioFacade;
    }
    
    @Override
    public Inventario registroNew(){
    return new Inventario();
    }

    public List<Producto> getListaProducto() {
        return listaProducto;
    }

    public List<Sucursal> getListaSucursal() {
        return listaSucursal;
    }

    public void setListaProducto(List<Producto> listaProducto) {
        this.listaProducto = listaProducto;
    }

    public void setListaSucursal(List<Sucursal> listaSucursal) {
        this.listaSucursal = listaSucursal;
    }
}
