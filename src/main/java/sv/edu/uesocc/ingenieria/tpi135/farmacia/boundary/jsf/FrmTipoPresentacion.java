package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoPresentacionFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmTipoPresentacion extends AbstractFrmDataModel<TipoPresentacion>implements Serializable{
        
    @Inject
    private TipoPresentacionFacade tipoPresentacionFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(TipoPresentacion object) {
        if (object != null) {
            return object.getIdTipoPresentacion();
        }
        return null;
    }

    @Override
    public TipoPresentacion datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdTipoPresentacion().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {
                throw new IllegalStateException();
            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return tipoPresentacionFacade;
    }
    
    @Override
    public TipoPresentacion registroNew(){
    return new TipoPresentacion();
    }

    
}
