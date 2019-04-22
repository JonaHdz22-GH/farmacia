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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class ProveedorProductoFacadeTest extends AbstractFacadeTest<ProveedorProducto> {

    @InjectMocks
    private ProveedorProductoFacade proveedorProductoFacade;

    @Override
    public AbstractFacade facade() {
        return proveedorProductoFacade;
    }

    public ProveedorProductoFacadeTest() {
        super(ProveedorProducto.class, new ProveedorProducto());
    }

    @Test
    public void testPrecioCompraProducto() {
        System.out.println("testPrecioCompraProducto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Double ex = 0.0;
        Assert.assertEquals(ex, proveedorProductoFacade.precioCompraProducto(100));
        Query query = Mockito.mock(Query.class);
        Double exp = 135.5;
        proveedorProductoFacade.em = entityManager;
        Mockito.when(entityManager.createQuery("SELECT pc.precioCompra FROM ProveedorProducto AS pc JOIN pc.productoList p WHERE p.idProducto = 1"))
                .thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(new Double(135.5));
        Assert.assertEquals(exp, proveedorProductoFacade.precioCompraProducto(1));
        Assert.assertEquals(ex, proveedorProductoFacade.precioCompraProducto(null));
    }

}
