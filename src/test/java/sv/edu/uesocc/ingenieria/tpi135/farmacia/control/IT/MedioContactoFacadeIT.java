/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.IT;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.Test;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.MedioContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author luis
 */
public class MedioContactoFacadeIT {

    MedioContactoFacade medioContactoFacade = new MedioContactoFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", medioContactoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        MedioContacto medioContacto = new MedioContacto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(medioContacto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        MedioContacto medioContacto = new MedioContacto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContacto);
        MedioContacto modificacion = new MedioContacto(1);
        facade().edit(modificacion);
        assertEquals(modificacion.getIdProveedor(), modificacion.getIdProveedor());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        MedioContacto medioContactoUno = new MedioContacto(1);
        MedioContacto medioContactoDos = new MedioContacto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContactoUno);
        facade().getEntityManager().persist(medioContactoDos);
        facade().remove(new MedioContacto(1));
        assertEquals(medioContactoDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        MedioContacto medioContacto = new MedioContacto(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContacto);

        assertEquals(medioContacto, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        MedioContacto medioContactoUno = new MedioContacto(1);
        MedioContacto medioContactoDos = new MedioContacto(2);

        List<MedioContacto> list = new ArrayList<>();
        list.add(medioContactoUno);
        list.add(medioContactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContactoUno);
        facade().getEntityManager().persist(medioContactoDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        MedioContacto medioContactoUno = new MedioContacto(1);
        MedioContacto medioContactoDos = new MedioContacto(2);

        List<MedioContacto> list = new ArrayList<>();
        list.add(medioContactoUno);
        list.add(medioContactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContactoUno);
        facade().getEntityManager().persist(medioContactoDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        MedioContacto medioContactoUno = new MedioContacto(1);
        MedioContacto medioContactoDos = new MedioContacto(2);

        List<MedioContacto> list = new ArrayList<>();
        list.add(medioContactoUno);
        list.add(medioContactoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(medioContactoUno);
        facade().getEntityManager().persist(medioContactoDos);

        assertEquals(list.size(), facade().count());
    }

}
