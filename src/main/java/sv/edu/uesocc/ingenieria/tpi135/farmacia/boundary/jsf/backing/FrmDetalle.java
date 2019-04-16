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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Detalle;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleProducto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmDetalle extends AbstractFrmDataModel<Detalle> implements Serializable{
    
    @Inject
    DetalleFacade detalleFacade;
    @Inject
    DetalleProductoFacade detalleProductoFacade;
    
    protected List<DetalleProducto> listaDetalleProducto;
    
   @Override
   @PostConstruct
   public void inicializar(){
       super.inicializar();
       try{
           this.listaDetalleProducto = detalleProductoFacade.findAll();
       }catch(Exception ex){
           this.listaDetalleProducto = Collections.EMPTY_LIST;
       }
   }
   
   public Integer getIdDetalleProductoSeleccionado(){
       if(this.registro != null && this.registro.getIdDetalleProducto() != null){
           return this.registro.getIdDetalleProducto().getIdDetalleProducto();
       }
       return null;
   }
   
   public void setIdDetalleProductoSeleccionado(Integer idDetalleProductoSeleccionado){
       if(this.registro != null && this.listaDetalleProducto != null){
           try{
               this.registro.setIdDetalleProducto(this.listaDetalleProducto.stream().filter(r -> r.getIdDetalleProducto().compareTo(idDetalleProductoSeleccionado)==0).collect(Collectors.toList()).get(0));
           }catch(Exception ex){
           }
       }
   }
   
   @Override
   public Object clavePorDatos(Detalle object) {
        if (object != null) {
            return object.getIdDetalle();
        }
        return null;
    }

    @Override
    public Detalle datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdDetalle().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return detalleFacade;
    }
    
    @Override
    public Detalle registroNew(){
    return new Detalle();
    }

    public List<DetalleProducto> getListaDetalleProducto() {
        return listaDetalleProducto;
    }
    
    
}
