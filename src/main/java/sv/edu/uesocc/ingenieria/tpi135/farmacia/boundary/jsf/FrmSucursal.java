package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmSucursal extends AbstractFrmDataModel<Sucursal> implements Serializable{
    
    @Inject
    private SucursalFacade sucursalFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(Sucursal object) {
        if (object != null) {
            return object.getIdSucursal();
        }
        return null;
    }

    @Override
    public Sucursal datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdSucursal().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {
                throw new IllegalStateException();
            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return sucursalFacade;
    }
    
    @Override
    public Sucursal registroNew(){
    return new Sucursal();
    }

    
    
}
