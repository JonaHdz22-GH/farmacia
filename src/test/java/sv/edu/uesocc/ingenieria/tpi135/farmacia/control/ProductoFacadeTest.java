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
import static org.junit.Assert.*;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class ProductoFacadeTest {
    
    @EJB
    ProductoFacade pf = new ProductoFacade();
    
    
    @Test
    public void testProductoPorProveedor() {
        System.out.println("testProductoPorProveedor");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pf.productoPorProveedor(1));
        Query query = Mockito.mock(Query.class);
        pf.em = entityManager;
        List<Producto> exp = new ArrayList<>();
        List<Producto> salida = new ArrayList<>();
        exp.add(new Producto(1));
        salida.add(new Producto(1,"Producto 1"));
        Mockito.when(entityManager.createQuery("SELECT p FROM Producto p JOIN p.idProveedorProducto.idProveedor pp WHERE pp.idProveedor = 1"))
               .thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp,pf.productoPorProveedor(1));
        Assert.assertEquals(Collections.EMPTY_LIST,pf.productoPorProveedor(null));
    }
    
    @Test
    public void testFindLikeProducto(){
        System.out.println("testFindLikeProducto");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pf.findLikeProducto("text"));
        Query query = Mockito.mock(Query.class);
        pf.em = entityManager;
        List<Producto> exp = new ArrayList<>();
        List<Producto> salida = new ArrayList<>();
        exp.add(new Producto(1));
        salida.add(new Producto(1));
        Mockito.when(entityManager.createQuery("SELECT p FROM Producto p WHERE (p.nombre LIKE '%texto%') OR (p.descripcion LIKE '%texto%')"))
               .thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp,pf.findLikeProducto("texto"));
        Assert.assertEquals(Collections.EMPTY_LIST,pf.findLikeProducto(null));
    }
    
    @Test
    public void testProductoPorSucursal(){
        System.out.println("testProductoPorSucursal");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,pf.productoPorSucursal(1));
        Query query = Mockito.mock(Query.class);
        pf.em = entityManager;
        List<Producto> exp = new ArrayList<>();
        List<Producto> salida = new ArrayList<>();
        exp.add(new Producto(1));
        salida.add(new Producto(1));
        Mockito.when(entityManager.createQuery("SELECT p FROM Producto p JOIN p.inventarioList s WHERE s.idSucursal.idSucursal = 1"))
               .thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(exp,pf.productoPorSucursal(1));
        Assert.assertEquals(Collections.EMPTY_LIST,pf.productoPorSucursal(null));
    }
    
    @Test
    public void testEntityManager(){
        System.out.println("testEM");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        pf.em = entityManager;
        Assert.assertEquals(entityManager,pf.getEntityManager());
    }
}
