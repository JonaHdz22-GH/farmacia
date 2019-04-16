package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.backing;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.FormaPagoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmFormaPago extends AbstractFrmDataModel<FormaPago> implements Serializable{
    
    @Inject
    private FormaPagoFacade formaPagoFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(FormaPago object) {
        if (object != null) {
            return object.getIdFormaPago();
        }
        return null;
    }

    @Override
    public FormaPago datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdFormaPago().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return formaPagoFacade;
    }
    
    @Override
    public FormaPago registroNew(){
    return new FormaPago();
    }
    
}
