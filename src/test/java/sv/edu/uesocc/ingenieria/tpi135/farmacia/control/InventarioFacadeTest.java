/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class InventarioFacadeTest {
    
    @EJB
    InventarioFacade ifa = new InventarioFacade();
   
    @Test
    public void testCantidadProducto() {
        System.out.println("testCantidadProducto");
        EntityManager entitymanager = Mockito.mock(EntityManager.class);
        Integer exp=0;
        Assert.assertEquals(exp,ifa.cantidadProducto(1));
        Query query = Mockito.mock(Query.class);
        ifa.em = entitymanager;
        Assert.assertEquals(exp,ifa.cantidadProducto(null));
        exp = 100;
        Mockito.when(entitymanager.createQuery("SELECT i.cantidad FROM Inventario i JOIN i.idProducto p WHERE p.idProducto = 1"))
               .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new Integer(100));
        Assert.assertEquals(exp,ifa.cantidadProducto(1));
        
    }
    
}
