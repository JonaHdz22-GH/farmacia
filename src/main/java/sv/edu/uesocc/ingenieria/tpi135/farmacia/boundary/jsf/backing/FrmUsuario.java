package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.backing;

import java.io.Serializable;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.UsuarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmUsuario extends AbstractFrmDataModel<Usuario> implements Serializable{
    
    @Inject
    private UsuarioFacade usuarioFacade;
    
    @Override
    @PostConstruct
    public void inicializar(){
        super.inicializar();
    }
    
     @Override
    public Object clavePorDatos(Usuario object) {
        if (object != null) {
            return object.getIdUsuario();
        }
        return null;
    }

    @Override
    public Usuario datosPorClave(String rowkey) {
        if (rowkey != null && !rowkey.trim().isEmpty()) {
            try {
                return this.getLazymodel().getWrappedData().stream().filter(r -> r.getIdUsuario().toString().compareTo(rowkey) == 0).collect(Collectors.toList()).get(0);
            } catch (Exception ex) {

            }
        }
        return null;
    }

    @Override
    public AbstractFacade getFacade() {
        return usuarioFacade;
    }
    
    @Override
    public Usuario registroNew(){
    return new Usuario();
    }

}
