package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.MedioContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmMedioContacto implements Serializable {

    @Inject
    MedioContactoFacade medioContactoFacade;
    private MedioContacto registro;

   

    public void insertar() {
        try {
            if (this.medioContactoFacade != null && this.registro != null) {
                this.medioContactoFacade.create(registro);
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(), exp);
        }
    }

    public void eliminar() {
        try {
            if (this.registro != null && this.medioContactoFacade != null) {
                this.medioContactoFacade.remove(registro);
                this.registro = new MedioContacto();
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(), exp);
        }
    }

    public void editar() {
        try {
            if (this.registro != null && this.medioContactoFacade != null) {
                this.medioContactoFacade.edit(registro);
            }
        } catch (Exception exp) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, exp.getMessage(), exp);
        }
    }

}
