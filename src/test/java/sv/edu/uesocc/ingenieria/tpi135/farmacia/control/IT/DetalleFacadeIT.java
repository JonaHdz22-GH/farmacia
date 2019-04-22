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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Detalle;

/**
 *
 * @author luis
 */
public class DetalleFacadeIT {

    DetalleFacade detalleFacade = new DetalleFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", detalleFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Detalle detalle = new Detalle(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(detalle);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Detalle detalle = new Detalle(1);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalle);
        Detalle modificacion = new Detalle(1);
        facade().edit(modificacion);
        assertEquals(modificacion.getIdDetalle(), modificacion.getIdDetalle());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Detalle detalleUno = new Detalle(1);
        Detalle detalleDos = new Detalle(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);
        facade().remove(new Detalle(1));
        assertEquals(detalleDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Detalle detalle = new Detalle(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalle);

        assertEquals(detalle, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Detalle detalleUno = new Detalle(1);
        Detalle detalleDos = new Detalle(2);

        List<Detalle> list = new ArrayList<>();
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
        Detalle detalleUno = new Detalle(1);
        Detalle detalleDos = new Detalle(2);

        List<Detalle> list = new ArrayList<>();
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
        Detalle detalleUno = new Detalle(1);
        Detalle detalleDos = new Detalle(2);

        List<Detalle> list = new ArrayList<>();
        list.add(detalleUno);
        list.add(detalleDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(detalleUno);
        facade().getEntityManager().persist(detalleDos);
        
        assertEquals(list.size(), facade().count());
    }

}
