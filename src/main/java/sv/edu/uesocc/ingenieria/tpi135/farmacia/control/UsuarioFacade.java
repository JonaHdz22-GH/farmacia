package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
    
    public List<Usuario> findByLike(String cadena){
        List<Usuario> lista = new ArrayList<>();
        try{
            if(!cadena.isEmpty()){
                Query query = em.createQuery("SELECT u FROM Usuario u WHERE u.nombre LIKE '%"+cadena+"%'");
                return query.getResultList();
            }else{
            return Collections.EMPTY_LIST;
            }
        }catch(Exception ex){
        return Collections.EMPTY_LIST;
        }
    }
}
