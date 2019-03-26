/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class TipoPresentacionFacade extends AbstractFacade<TipoPresentacion>{

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPresentacionFacade() {
        super(TipoPresentacion.class);
    }
    
}
