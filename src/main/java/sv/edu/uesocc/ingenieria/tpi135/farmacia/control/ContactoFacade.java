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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 */
@Stateless
public class ContactoFacade extends AbstractFacade<Contacto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    protected EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ContactoFacade() {
        super(Contacto.class);
    }
    
    
    public List<Contacto> findLike(String txt) {
        List<Contacto> lista = new ArrayList<>();
        try {
            if(!txt.isEmpty()){
            Query query = em.createQuery("SELECT c FROM Contacto c WHERE (c.contacto LIKE '%"+txt+"%') OR (c.descripcion LIKE '%"+txt+"%')");
            return lista = query.getResultList();
            }else{
                return Collections.EMPTY_LIST;
            }
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }
    
    public List<Contacto> contactoPorProveedor(Integer id){
        List<Contacto> lista = new ArrayList<>();
        try{
            if(em!=null && id!=null && id>0){
                Query query = em.createQuery("SELECT c FROM Contacto c JOIN c.medioContactoList p WHERE p.idProveedor.idProveedor = "+id);
                return lista = query.getResultList();
            }else{
                return Collections.EMPTY_LIST;
            }
        }catch(Exception e){
                return Collections.EMPTY_LIST;
        }
    }
    
}
