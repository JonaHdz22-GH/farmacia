package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;

/**
 *
 * @author jonahdz
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario>{

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }
    
}
