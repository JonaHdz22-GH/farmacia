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
public class ProveedorProductoFacadeTest {
    
    @EJB
    ProveedorProductoFacade ppf = new ProveedorProductoFacade();

    @Test
    public void testPrecioCompraProducto() {
        System.out.println("testPrecioCompraProducto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Double exp=135.5;
        ppf.em = entityManager;
        Mockito.when(entityManager.createQuery("SELECT pc.precioCompra FROM ProveedorProducto AS pc JOIN pc.productoList p WHERE p.idProducto = 1"))
               .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new Double(135.5));
        Assert.assertEquals(exp,ppf.precioCompraProducto(1));
    }
    
}
