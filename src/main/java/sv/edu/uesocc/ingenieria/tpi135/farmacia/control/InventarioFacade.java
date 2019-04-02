/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;

/**
 *
 * @author jonahdz
 */
@Stateless
public class InventarioFacade extends AbstractFacade<Inventario>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventarioFacade() {
        super(Inventario.class);
    }
    
    public Integer cantidadProducto(Integer idProducto){
        Integer salida=0;
        try{
            if(em!=null && idProducto!=null && idProducto>0){
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
