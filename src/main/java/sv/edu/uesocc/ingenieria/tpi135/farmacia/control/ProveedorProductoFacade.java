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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author jonahdz
 */
@LocalBean
@Stateless
public class ProveedorProductoFacade extends AbstractFacade<ProveedorProducto>{

    @PersistenceContext(unitName = "FarmaciaPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ProveedorProductoFacade() {
        super(ProveedorProducto.class);
    }
    
}
