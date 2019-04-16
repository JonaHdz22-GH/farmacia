/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class ProveedorFacadeTest {
    
    @EJB
    ProveedorFacade pf = new ProveedorFacade();
    
    
    @Test
    public void testProveedorPorContacto(){
        System.out.println("testProveedorPorContacto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pf.proveedorPorContacto(1));
        pf.em = entityManager;
        List<Proveedor> exp = new ArrayList<>();
        List<Proveedor> salida = new ArrayList<>();
        exp.add(new Proveedor(1,"","",""));
        salida.add(new Proveedor(1,"","",""));
        Mockito.when(entityManager.createQuery("SELECT p FROM Proveedor p JOIN p.medioContactoList mc WHERE mc.idContacto.idContacto = 1")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp,pf.proveedorPorContacto(1));
        Assert.assertEquals(Collections.EMPTY_LIST,pf.proveedorPorContacto(null));
    }
    
    @Test
    public void testProveedorPorProducto(){
        System.out.println("testProveedorPorProducto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Query query = Mockito.mock(Query.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pf.proveedorPorProducto(1));
        pf.em = entityManager;
        List<Proveedor> exp = new ArrayList<>();
        List<Proveedor> salida = new ArrayList<>();
        exp.add(new Proveedor(1));
        salida.add(new Proveedor(1));
        Mockito.when(entityManager.createQuery("SELECT p FROM Proveedor p JOIN p.proveedorProductoList pp JOIN pp.productoList prp WHERE prp.idProducto = 1 ORDER BY pp.precioCompra ASC"))
               .thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp,pf.proveedorPorProducto(1));
        Assert.assertEquals(Collections.EMPTY_LIST,pf.proveedorPorProducto(null));
    }
    
    @Test
    public void testEntityManager(){
        System.out.println("testEM");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        pf.em = entityManager;
        Assert.assertEquals(entityManager,pf.getEntityManager());
    }
    
}
