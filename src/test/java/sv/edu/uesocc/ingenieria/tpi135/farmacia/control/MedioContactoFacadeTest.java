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
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author luis21
 */
@RunWith(MockitoJUnitRunner.class)
public class MedioContactoFacadeTest {
    
    @EJB
    MedioContactoFacade mcf = new MedioContactoFacade();
    
    
    @Test
    public void testFindAll(){
        System.out.println("testFindAll");
        List<MedioContacto> salida = new ArrayList<>();
        salida.add(new MedioContacto(1));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        mcf.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<MedioContacto> expResult = new ArrayList();
        expResult.add(new MedioContacto(1));
        Assert.assertEquals(expResult,mcf.findAll());
    }
    
    @Test
    public void testFindRange(){
        System.out.println("testFindRange");
        List<MedioContacto> salida = new ArrayList<>();
        salida.add(new MedioContacto(1));
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        mcf.em = entityManager;
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        List<MedioContacto> expResult = new ArrayList();
        expResult.add(new MedioContacto(1));
        Assert.assertEquals(expResult,mcf.findRange(1,1000));
    }
    
    @Test
    public void testCount(){
        System.out.println("testCount");
        Long salida=1l;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        mcf.em = entityManager;
        CriteriaQuery cq = Mockito.mock(CriteriaQuery.class);
        CriteriaBuilder cb = Mockito.mock(CriteriaBuilder.class);
        TypedQuery query = Mockito.mock(TypedQuery.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery()).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq)).thenReturn(query);
        Mockito.when(query.getSingleResult()).thenReturn(salida);
        Assert.assertEquals(1l,mcf.count());
    }

}
