package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleProducto;

/**
 *
 * @author jonahdz
 */
@Stateless
@LocalBean
public class DetalleProductoFacade extends AbstractFacade<DetalleProducto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public DetalleProductoFacade() {
        super(DetalleProducto.class);
    }
    
}
