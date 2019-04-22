package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario>{

    @PersistenceContext(unitName = "FarmaciaPU")
    public EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    
    public Integer cantidadProducto(Integer idProducto){
        Integer salida=0;
        try{
            if(idProducto!=null){
                Query query = em.createQuery("SELECT i.cantidad FROM Inventario i JOIN i.idProducto p WHERE p.idProducto = "+idProducto);
                salida = (Integer) query.getSingleResult();
                return salida;
            }else{
                return salida;
            }
        }catch(Exception e){
            return salida;
        }
    }
}
