package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Factura;

/**
 *
 * @author jonahdz
 */
@Stateless
public class FacturaFacade extends AbstractFacade<Factura> {

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public FacturaFacade() {
        super(Factura.class);
    }
    
}
