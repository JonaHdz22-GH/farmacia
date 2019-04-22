package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class MedioContactoFacade extends AbstractFacade<MedioContacto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public MedioContactoFacade() {
        super(MedioContacto.class);
    }
    
    
}