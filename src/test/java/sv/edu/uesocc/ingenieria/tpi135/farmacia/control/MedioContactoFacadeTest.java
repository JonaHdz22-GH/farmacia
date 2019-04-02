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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.junit.Assert;
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
    
//    @Mock
//    CriteriaBuilder cb;
//    @Mock
//    CriteriaQuery cq;
    
    //@Test
    public void testFindAll(){
        System.out.println("testFindAll");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        mcf.em = entityManager;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<MedioContacto> cq = cb.createQuery(MedioContacto.class);
        Mockito.when(entityManager.getCriteriaBuilder()).thenReturn(cb);
        Mockito.when(cb.createQuery(MedioContacto.class)).thenReturn(cq);
        Mockito.when(entityManager.createQuery(cq).getResultList()).thenReturn(new ArrayList());
        List<MedioContacto> expResult = new ArrayList();
        Assert.assertEquals(expResult,mcf.findAll());
    }

}
