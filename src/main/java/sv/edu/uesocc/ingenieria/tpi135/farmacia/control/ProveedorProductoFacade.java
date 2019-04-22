package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class ProveedorProductoFacade extends AbstractFacade<ProveedorProducto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    public EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ProveedorProductoFacade() {
        super(ProveedorProducto.class);
    }
    
    public Double precioCompraProducto(Integer idProducto){
        double salida=0;
        try{
            if(idProducto!=null){
                Query query = em.createQuery("SELECT pc.precioCompra FROM ProveedorProducto AS pc JOIN pc.productoList p WHERE p.idProducto = "+idProducto);
                salida = (double) query.getSingleResult();
                return salida;
            }else{
                System.err.println("Producto No Encontrado");
                return salida;
            }
        }catch(Exception e){
            System.err.println("Producto No Encontrado");
            return salida;
        }
    }
    
}
