/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class ProveedorFacadeTest extends AbstractFacadeTest<Proveedor> {

    @InjectMocks
    private ProveedorFacade proveedorFacade;

    @Override
    public AbstractFacade facade() {
        return proveedorFacade;
    }

    public ProveedorFacadeTest() {
        super(Proveedor.class, new Proveedor());
    }

    @Test
    public void testProveedorPorContacto() {
        System.out.println("testProveedorPorContacto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Assert.assertEquals(Collections.EMPTY_LIST, proveedorFacade.proveedorPorContacto(1));
        proveedorFacade.em = entityManager;
        List<Proveedor> exp = new ArrayList<>();
        List<Proveedor> salida = new ArrayList<>();
        exp.add(new Proveedor(1, "", "", ""));
        salida.add(new Proveedor(1, "", "", ""));
        Mockito.when(entityManager.createQuery("SELECT p FROM Proveedor p JOIN p.medioContactoList mc WHERE mc.idContacto.idContacto = 1")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp, proveedorFacade.proveedorPorContacto(1));
        Assert.assertEquals(Collections.EMPTY_LIST, proveedorFacade.proveedorPorContacto(null));
    }

    @Test
    public void testProveedorPorProducto() {
        System.out.println("testProveedorPorProducto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Assert.assertEquals(Collections.EMPTY_LIST, proveedorFacade.proveedorPorProducto(1));
        proveedorFacade.em = entityManager;
        List<Proveedor> exp = new ArrayList<>();
        List<Proveedor> salida = new ArrayList<>();
        exp.add(new Proveedor(1));
        salida.add(new Proveedor(1));
        Mockito.when(entityManager.createQuery("SELECT p FROM Proveedor p JOIN p.proveedorProductoList pp JOIN pp.productoList prp WHERE prp.idProducto = 1 ORDER BY pp.precioCompra ASC"))
                .thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp, proveedorFacade.proveedorPorProducto(1));
        Assert.assertEquals(Collections.EMPTY_LIST, proveedorFacade.proveedorPorProducto(null));
    }

}
