package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleVenta;

/**
 *
 * @author jonahdz
 */
@Stateless
public class DetalleVentaFacade extends AbstractFacade<DetalleVenta>{

    @PersistenceContext(unitName = "FarmaciaPU")
    public EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DetalleVentaFacade() {
        super(DetalleVenta.class);
    }
    
}
