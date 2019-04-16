package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;

/**
 *
 * @author jonahdz
 */
@Stateless
@LocalBean
public class TipoDescuentoFacade extends AbstractFacade<TipoDescuento>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoDescuentoFacade() {
        super(TipoDescuento.class);
    }
    
}