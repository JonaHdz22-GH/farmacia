/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.IT;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import static org.junit.Assert.*;
import org.junit.Rule;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author luis
 */
public class ContactoFacadeIT {

    ContactoFacade contactoFacade = new ContactoFacade();
    
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", contactoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Contacto contacto = new Contacto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(contacto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Contacto contacto = new Contacto(1, "Telefono");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contacto);
        Contacto modificacion = new Contacto(1, "Email");
        facade().edit(modificacion);
        assertEquals(modificacion.getContacto(), modificacion.getContacto());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Contacto contactoUno = new Contacto(1);
        Contacto contactoDos = new Contacto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contactoUno);
        facade().getEntityManager().persist(contactoDos);
        facade().remove(new Contacto(1));
        assertEquals(contactoDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Contacto contactoUno = new Contacto(1, "Email");

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contactoUno);

        assertEquals(contactoUno, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Contacto contactoUno = new Contacto(1, "Email");
        Contacto contactoDos = new Contacto(2, "Telefono");

        List<Contacto> list = new ArrayList<>();
        list.add(contactoUno);
        list.add(contactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contactoUno);
        facade().getEntityManager().persist(contactoDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");

        Contacto contactoUno = new Contacto(1, "Email");
        Contacto contactoDos = new Contacto(2, "Telefono");

        List<Contacto> list = new ArrayList<>();
        list.add(contactoUno);
        list.add(contactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contactoUno);
        facade().getEntityManager().persist(contactoDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        Contacto contactoUno = new Contacto(1, "Email");
        Contacto contactoDos = new Contacto(2, "Telefono");

        List<Contacto> list = new ArrayList<>();
        list.add(contactoUno);
        list.add(contactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(contactoUno);
        facade().getEntityManager().persist(contactoDos);

        assertEquals(list.size(), facade().count());
    }

}
