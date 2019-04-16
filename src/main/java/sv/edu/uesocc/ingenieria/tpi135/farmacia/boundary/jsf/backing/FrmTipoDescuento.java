package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.backing;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoDescuentoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmTipoDescuento extends AbstractFrmDataModel<TipoDescuento> implements Serializable{
    
    @Inject
    private TipoDescuentoFacade tipoDescuentoFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(TipoDescuento object) {
        if (object != null) {
            return object.getIdTipoDescuento();
        }
        return null;
    }

    @Override
    public TipoDescuento datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdTipoDescuento().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return tipoDescuentoFacade;
    }
    
    @Override
    public TipoDescuento registroNew(){
    return new TipoDescuento();
    }

    
    
}
