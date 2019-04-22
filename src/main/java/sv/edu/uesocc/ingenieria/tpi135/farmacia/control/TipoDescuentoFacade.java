package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;

/**
 *
 * @author jonahdz
 */
@Stateless
public class TipoDescuentoFacade extends AbstractFacade<TipoDescuento>{

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public TipoDescuentoFacade() {
        super(TipoDescuento.class);
    }
    
}
