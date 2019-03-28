/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.then;
import org.mockito.Matchers;
import org.mockito.Mockito;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author luis21
 */
public class MedioContactoFacadeTest {

    /**
     * Test of create method, of class MedioContactoFacade.
     */
    @Test
    public void testCreate() {
        System.out.println("testCreate");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        MedioContactoFacade mcf = new MedioContactoFacade();
        mcf.em = entityManager;
        mcf.create(new MedioContacto());
        Mockito.verify(entityManager).persist(Matchers.anyObject());

    }

    /**
     * Test of edit method, of class MedioContactoFacade.
     */
    @Test
    public void testEdit() {
        System.out.println("testEdit");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        MedioContactoFacade mcf = new MedioContactoFacade();
        MedioContacto mcm = new MedioContacto(1, "Telefono");
        mcf.em = entityManager;
        mcf.edit(mcm);
        Mockito.verify(entityManager).merge(Matchers.any(MedioContacto.class));
    }

    /**
     * Test of remove method, of class MedioContactoFacade.
     */
    @Test
    public void testRemove() {
        System.out.println("testRemove");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        MedioContactoFacade mcf = new MedioContactoFacade();
        MedioContacto mcm = new MedioContacto(1);
        mcf.em = entityManager;
        mcf.remove(mcm);
        Mockito.verify(entityManager).remove(Matchers.any(MedioContacto.class));

    }

    @Test
    public void testFindById() {
        System.out.println("testFindById");
        Object id=1;
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(entityManager.find(MedioContacto.class,1)).thenReturn(new MedioContacto(1));
        MedioContacto expResult = new MedioContacto(1);
        MedioContactoFacade mcf = new MedioContactoFacade();
        mcf.em = entityManager;
        MedioContacto result = mcf.findById(id);
        Assert.assertEquals(expResult,result);
    }

    //@Test
    public void testFindAll() {
        System.out.println("testFindAll");
        MedioContactoFacade mcf = new MedioContactoFacade();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        mcf.em = entityManager;
        mcf.findAll();
        
        
//        TypedQuery consulta = Mockito.mock(TypedQuery.class);
//        
//        Mockito.when(consulta.getResultList()).thenReturn();
//        
//        List<MedioContacto> listMedioContacto = mcf.findAll();
//        
//        assertEquals(listMedioContacto, this.);
        
        
        
        

    }

//    /**
//     * Test of findRange method, of class MedioContactoFacade.
//     */
//    @Test
//    public void testFindRange() throws Exception {
//        System.out.println("findRange");
//        int inicio = 0;
//        int tamanio = 0;
//        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
//        MedioContactoFacade instance = (MedioContactoFacade)container.getContext().lookup("java:global/classes/MedioContactoFacade");
//        List<MedioContacto> expResult = null;
//        List<MedioContacto> result = instance.findRange(inicio, tamanio);
//        assertEquals(expResult, result);
//        container.close();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of count method, of class MedioContactoFacade.
     */
    @Test
    public void testCount(){
        System.out.println("testCount");
        MedioContactoFacade mcf = new MedioContactoFacade();
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Mockito.when(mcf.count()).thenReturn(new Integer(25));
        mcf.em=entityManager;
        Integer esperado = 25;
        Integer retornado = mcf.count();
        Assert.assertEquals(esperado,retornado);
    }
}
