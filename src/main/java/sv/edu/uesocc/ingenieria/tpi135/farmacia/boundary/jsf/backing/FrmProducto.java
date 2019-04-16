package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.backing;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
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
public class FrmProducto extends AbstractFrmDataModel<Producto> implements Serializable{
    
    @Inject
    ProveedorProductoFacade proveedorProductoFacade;
    @Inject
    ProductoFacade productoFacade;
    
    protected List<ProveedorProducto> listaProveedorProducto;
    
    
    @Override
    @PostConstruct
    public void inicializar() {
        super.inicializar();
        try{
            this.listaProveedorProducto = proveedorProductoFacade.findAll();
        }catch(Exception ex){
            this.listaProveedorProducto = Collections.EMPTY_LIST;
        }
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
    
    @Override
    public Object clavePorDatos(Producto object) {
        if (object != null) {
            return object.getIdProducto();
        }
        return null;
    }

    @Override
    public Producto datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdProducto().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return productoFacade;
    }
    
    @Override
    public Producto registroNew(){
    return new Producto();
    }

    public List<ProveedorProducto> getListaProveedorProducto() {
        return listaProveedorProducto;
    }
    
}
