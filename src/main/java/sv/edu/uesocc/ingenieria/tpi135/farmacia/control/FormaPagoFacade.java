package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago;

/**
 *
 * @author jonahdz
 */
@Stateless
public class FormaPagoFacade extends AbstractFacade<FormaPago> {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FormaPagoFacade() {
        super(FormaPago.class);
    }
    
}
