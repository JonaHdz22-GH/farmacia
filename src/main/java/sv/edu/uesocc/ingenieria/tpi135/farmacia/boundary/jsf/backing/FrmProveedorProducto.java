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
public class FrmProveedorProducto extends AbstractFrmDataModel<ProveedorProducto> implements Serializable{
    
    @Inject
    ProveedorFacade proveedorFacade;
    @Inject
    ProveedorProductoFacade proveedorProductoFacade;
    
    protected List<Proveedor> listaProveedor;
    
    
    @Override
    @PostConstruct
    public void inicializar() {
        super.inicializar();
        try{
            this.listaProveedor = proveedorFacade.findAll();
        }catch(Exception ex){
            this.listaProveedor = Collections.EMPTY_LIST;
        }
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
   
    @Override
    public Object clavePorDatos(ProveedorProducto object) {
        if (object != null) {
            return object.getIdProveedorProducto();
        }
        return null;
    }
    
    
    @Override
    public ProveedorProducto datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdProveedorProducto().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }
    
    @Override
    public AbstractFacade getFacade() {
        return proveedorProductoFacade;
    }
    
    @Override
    public ProveedorProducto registroNew(){
    return new ProveedorProducto();
    }

    public List<Proveedor> getListaProveedor() {
        return listaProveedor;
    }
    
    
}
