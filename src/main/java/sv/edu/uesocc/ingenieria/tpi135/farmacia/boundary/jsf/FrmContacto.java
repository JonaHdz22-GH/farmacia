package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmContacto extends AbstractFrmDataModel<Contacto>implements Serializable {

    @Inject
    private ContactoFacade contactoFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
    @Override
    public Object clavePorDatos(Contacto object) {
        if (object != null) {
            return object.getIdContacto();
        }
        return null;
    }

    @Override
    public Contacto datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdContacto().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {
                throw new IllegalStateException();
            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return contactoFacade;
    }
    
    @Override
    public Contacto registroNew(){
    return new Contacto();
    }
    
}
