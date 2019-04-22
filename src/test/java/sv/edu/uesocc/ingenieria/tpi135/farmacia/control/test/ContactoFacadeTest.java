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
import static org.mockito.Mockito.mock;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class ContactoFacadeTest extends AbstractFacadeTest<Contacto> {

    @InjectMocks
    private ContactoFacade contactoFacade;

    @Override
    public AbstractFacade facade() {
        return contactoFacade;
    }

    public ContactoFacadeTest() {
        super(Contacto.class, new Contacto());
    }
    
    @Test
    public void testFindLike() {
        System.out.println("testFindLike");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST, contactoFacade.findLike("cn"));
        contactoFacade.em = entityManager;
        List<Contacto> expResult = new ArrayList<>();
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT c FROM Contacto c WHERE (c.contacto LIKE '%texto%') OR (c.descripcion LIKE '%texto%')")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(new ArrayList());
        Assert.assertEquals(expResult, contactoFacade.findLike("texto"));
        Mockito.when(contactoFacade.findLike("")).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST, contactoFacade.findLike(""));
    }

    @Test
    public void testContactoPorProveedor() {
        System.out.println("testContactoPorProveedor");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Assert.assertEquals(Collections.EMPTY_LIST, contactoFacade.contactoPorProveedor(22));
        contactoFacade.em = entityManager;
        List<Contacto> expResult = new ArrayList<>();
        expResult.add(new Contacto(1));
        List<Contacto> salida = new ArrayList<>();
        salida.add(new Contacto(1));
        Query query = mock(Query.class);
        Mockito.when(entityManager.createQuery("SELECT c FROM Contacto c JOIN c.medioContactoList p WHERE p.idProveedor.idProveedor = 1")).thenReturn(query);
        Mockito.when(query.getResultList()).thenReturn(salida);
        Assert.assertEquals(expResult, contactoFacade.contactoPorProveedor(1));
        Mockito.when(contactoFacade.contactoPorProveedor(null)).thenReturn(Collections.EMPTY_LIST);
        Assert.assertEquals(Collections.EMPTY_LIST, contactoFacade.contactoPorProveedor(null));
    }

}
