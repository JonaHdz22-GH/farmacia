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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleProducto;

/**
 *
 * @author luis
 */
public class DetalleProductoFacadeIT {

    DetalleProductoFacade detalleProductoFacade = new DetalleProductoFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", detalleProductoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        DetalleProducto detalleProducto = new DetalleProducto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(detalleProducto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        DetalleProducto detalleProducto = new DetalleProducto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleProducto);
        DetalleProducto modificacion = new DetalleProducto(1);
        facade().edit(modificacion);
        assertEquals(modificacion.getIdProducto(), modificacion.getIdProducto());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        DetalleProducto detalleUno = new DetalleProducto(1);
        DetalleProducto detalleDos = new DetalleProducto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);
        facade().remove(new DetalleProducto(1));
        assertEquals(detalleDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        DetalleProducto detalleProducto = new DetalleProducto(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleProducto);

        assertEquals(detalleProducto, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        DetalleProducto detalleUno = new DetalleProducto(1);
        DetalleProducto detalleDos = new DetalleProducto(2);

        List<DetalleProducto> list = new ArrayList<>();
        list.add(detalleUno);
        list.add(detalleDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        DetalleProducto detalleUno = new DetalleProducto(1);
        DetalleProducto detalleDos = new DetalleProducto(2);

        List<DetalleProducto> list = new ArrayList<>();
        list.add(detalleUno);
        list.add(detalleDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        DetalleProducto detalleUno = new DetalleProducto(1);
        DetalleProducto detalleDos = new DetalleProducto(2);

        List<DetalleProducto> list = new ArrayList<>();
        list.add(detalleUno);
        list.add(detalleDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);

        assertEquals(list.size(), facade().count());
    }

}
