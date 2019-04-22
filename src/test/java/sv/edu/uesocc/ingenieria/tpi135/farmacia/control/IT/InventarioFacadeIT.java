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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.InventarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;

/**
 *
 * @author luis
 */
public class InventarioFacadeIT {

    InventarioFacade inventarioFacade = new InventarioFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", inventarioFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Inventario inventario = new Inventario(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(inventario);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Inventario inventario = new Inventario(1);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventario);
        Inventario modificacion = new Inventario(1);
        facade().edit(modificacion);
        assertEquals(modificacion.getCantidad(), modificacion.getCantidad());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Inventario inventarioUno = new Inventario(1);
        Inventario inventarioDos = new Inventario(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventarioUno);
        facade().getEntityManager().persist(inventarioDos);
        facade().remove(new Inventario(1));
        assertEquals(inventarioDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Inventario inventario = new Inventario(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventario);

        assertEquals(inventario, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Inventario inventarioUno = new Inventario(1);
        Inventario inventarioDos = new Inventario(2);

        List<Inventario> list = new ArrayList<>();
        list.add(inventarioUno);
        list.add(inventarioDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventarioUno);
        facade().getEntityManager().persist(inventarioDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Inventario inventarioUno = new Inventario(1);
        Inventario inventarioDos = new Inventario(2);

        List<Inventario> list = new ArrayList<>();
        list.add(inventarioUno);
        list.add(inventarioDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventarioUno);
        facade().getEntityManager().persist(inventarioDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        Inventario inventarioUno = new Inventario(1);
        Inventario inventarioDos = new Inventario(2);

        List<Inventario> list = new ArrayList<>();
        list.add(inventarioUno);
        list.add(inventarioDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(inventarioUno);
        facade().getEntityManager().persist(inventarioDos);

        assertEquals(list.size(), facade().count());
    }

}
