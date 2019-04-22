package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class ProductoFacade extends AbstractFacade<Producto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    public EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ProductoFacade() {
        super(Producto.class);
    }
 
    public List<Producto> productoPorProveedor(Integer idProveedor){
        List<Producto> salida = new ArrayList<>();
        try{
            if(idProveedor!=null){
                Query query = em.createQuery("SELECT p FROM Producto p JOIN p.idProveedorProducto.idProveedor pp WHERE pp.idProveedor = "+idProveedor);
                salida = query.getResultList();
                return salida;
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
            return Collections.EMPTY_LIST;
        }
    }
    
    public List<Producto> findLikeProducto(String text){
        List<Producto> lista = new ArrayList<>();
        try{
            if(text != null){
                Query query = em.createQuery("SELECT p FROM Producto p WHERE (p.nombre LIKE '%"+text+"%') OR (p.descripcion LIKE '%"+text+"%')");
                lista = query.getResultList();
                return lista;
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
            return Collections.EMPTY_LIST;
        }
    }
    
    public List<Producto> productoPorSucursal(Integer idSucursal){
        List<Producto> lista = new ArrayList<>();
        try{
            if(idSucursal!=null){
                Query query = em.createQuery("SELECT p FROM Producto p JOIN p.inventarioList s WHERE s.idSucursal.idSucursal = "+idSucursal);
                lista = query.getResultList();
                return lista;
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
            return Collections.EMPTY_LIST;
        }
    }
}
