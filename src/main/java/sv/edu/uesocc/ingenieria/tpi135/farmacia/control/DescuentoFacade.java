package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Descuento;

/**
 *
 * @author jonahdz
 */
@Stateless
public class DescuentoFacade extends AbstractFacade<Descuento>{

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DescuentoFacade() {
        super(Descuento.class);
    }
    
}
