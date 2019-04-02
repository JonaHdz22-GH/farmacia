/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author jonahdz
 */
@Stateless
public class ProveedorFacade extends AbstractFacade<Proveedor>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorFacade() {
        super(Proveedor.class);
    }
    
    
    public List<Proveedor> proveedorPorContacto(Integer idContacto){
        List<Proveedor> lista = new ArrayList<>();
        try{
            if( em!=null && idContacto != null && idContacto>0){
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
            if(em!= null && idProducto!=null && idProducto>0){
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

