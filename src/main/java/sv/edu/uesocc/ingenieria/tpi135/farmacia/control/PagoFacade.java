package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Pago;

/**
 *
 * @author jonahdz
 */
@Stateless
public class PagoFacade extends AbstractFacade<Pago> {

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public PagoFacade() {
        super(Pago.class);
    }
    
}
