package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor>{

    @PersistenceContext(unitName = "FarmaciaPU")
    public EntityManager em;

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    
    public List<Proveedor> proveedorPorContacto(Integer idContacto){
        List<Proveedor> lista = new ArrayList<>();
        try{
            if(idContacto != null){
                Query query = em.createQuery("SELECT p FROM Proveedor p JOIN p.medioContactoList mc WHERE mc.idContacto.idContacto = "+idContacto);
                lista = query.getResultList();
                return lista;
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
            return Collections.EMPTY_LIST;
        }
    }
    
    public List<Proveedor> proveedorPorProducto(Integer idProducto){
        List<Proveedor> lista = new ArrayList<>();
        try{
            if(idProducto!=null){
                Query query = em.createQuery("SELECT p FROM Proveedor p JOIN p.proveedorProductoList pp JOIN pp.productoList prp WHERE prp.idProducto = "+idProducto+" ORDER BY pp.precioCompra ASC");
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

