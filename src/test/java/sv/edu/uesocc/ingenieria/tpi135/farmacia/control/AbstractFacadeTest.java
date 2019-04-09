/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.JUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mockito;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 */
@RunWith(JUnit4ClassRunner.class)
public class AbstractFacadeTest {
    
    @EJB
    ContactoFacade cf = new ContactoFacade();
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreate() {
        System.out.println("testCreate");
        boolean ise=false;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        try{
            cf.create(new Contacto());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        cf.em = entityManager;
        cf.create(new Contacto());
        Mockito.verify(entityManager).persist(Matchers.anyObject());
        cf.create(null);
    }
   
    @Test(expected = IllegalArgumentException.class)
    public void testEdit() {
        System.out.println("testEdit");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            cf.edit(new Contacto());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Contacto mcm = new Contacto(1);
        cf.em = entityManager;
        cf.edit(mcm);
        Mockito.verify(entityManager).merge(Matchers.any(Contacto.class));
        cf.edit(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testRemove() {
        System.out.println("testRemove");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            cf.remove(new Contacto());
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Contacto mcm = new Contacto(1);
        cf.em = entityManager;
        cf.remove(mcm);
        Mockito.verify(entityManager).remove(Matchers.any(Contacto.class));
        cf.remove(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testFindById() {
        System.out.println("testFindById");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        boolean ise = false;
        try{
            cf.findById(1);
        }catch(IllegalStateException e){
            ise = true;
        }
        Assert.assertTrue(ise);
        Mockito.when(entityManager.find(Contacto.class,1)).thenReturn(new Contacto(1));
        Contacto expResult = new Contacto(1);
        cf.em = entityManager;
        Object id=1;
        Contacto result = cf.findById(id);
        Assert.assertEquals(expResult,result);
        cf.findById(null);
    }
    
    @Test
    public void testFindAll(){
        System.out.println("testFindAll");
        List<Contacto> salida = new ArrayList<>();
        salida.add(new Contacto(1));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        cf.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<Contacto> expResult = new ArrayList();
        expResult.add(new Contacto(1));
        Assert.assertEquals(expResult,cf.findAll());
    }
    
    @Test
    public void testFindRange(){
        System.out.println("testFindRange");
        List<Contacto> salida = new ArrayList<>();
        salida.add(new Contacto(1));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        cf.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<Contacto> expResult = new ArrayList();
        expResult.add(new Contacto(1));
        Assert.assertEquals(expResult,cf.findRange(1,1000));
    }
    
    @Test
    public void testCount(){
        System.out.println("testCount");
        Long salida=1l;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        cf.em = entityManager;
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(salida);
        Assert.assertEquals(1l,cf.count());
    }
}
