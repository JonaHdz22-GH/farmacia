/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.InventarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class InventarioFacadeTest extends AbstractFacadeTest<Inventario> {

    @InjectMocks
    private InventarioFacade inventarioFacade;

    @Override
    public AbstractFacade facade() {
        return inventarioFacade;
    }

    public InventarioFacadeTest() {
        super(Inventario.class, new Inventario());
    }

    @Test
    public void testCantidadProducto() {
        System.out.println("testCantidadProducto");
        EntityManager entitymanager = Mockito.mock(EntityManager.class);
        Integer exp = 0;
        Assert.assertEquals(exp, inventarioFacade.cantidadProducto(1));
        Query query = Mockito.mock(Query.class);
        inventarioFacade.em = entitymanager;
        Assert.assertEquals(exp, inventarioFacade.cantidadProducto(null));
        exp = 100;
        Mockito.when(entitymanager.createQuery("SELECT i.cantidad FROM Inventario i JOIN i.idProducto p WHERE p.idProducto = 1"))
                .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new Integer(100));
        Assert.assertEquals(exp, inventarioFacade.cantidadProducto(1));

    }

}
