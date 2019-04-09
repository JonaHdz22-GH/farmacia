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
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactoFacadeTest {
    
    
    @EJB
    ContactoFacade cf = new ContactoFacade();
    
    @Test
    public void testFindLike(){
        System.out.println("testFindLike");
        EntityManager entityManager= Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,cf.findLike("cn"));
        cf.em = entityManager;
        List<Contacto> expResult= new ArrayList<>();
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT c FROM Contacto c WHERE (c.contacto LIKE '%texto%') OR (c.descripcion LIKE '%texto%')")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());
        Assert.assertEquals(expResult,cf.findLike("texto"));
        Mockito.when(cf.findLike("")).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,cf.findLike(""));
    }
    
    @Test
    public void testContactoPorProveedor(){
        System.out.println("testContactoPorProveedor");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST,cf.contactoPorProveedor(22));
        cf.em = entityManager;
        List<Contacto> expResult = new ArrayList<>();
        expResult.add(new Contacto(1));
        List<Contacto> salida = new ArrayList<>();
        salida.add(new Contacto(1));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT c FROM Contacto c JOIN c.medioContactoList p WHERE p.idProveedor.idProveedor = 1")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult,cf.contactoPorProveedor(1));
        Mockito.when(cf.contactoPorProveedor(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST,cf.contactoPorProveedor(null));
    }
    
}
