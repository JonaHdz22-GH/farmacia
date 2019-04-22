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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoPresentacionFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author luis
 */
public class TipoPresentacionFacadeIT {

    TipoPresentacionFacade tipoPresentacionFacade = new TipoPresentacionFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", tipoPresentacionFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        TipoPresentacion tipoPresentacion = new TipoPresentacion(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(tipoPresentacion);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        TipoPresentacion tipoPresentacion = new TipoPresentacion(1,"Pastilla");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacion);
        TipoPresentacion modificacion = new TipoPresentacion(1, "Pomada");
        facade().edit(modificacion);
        assertEquals(modificacion.getNombre(), modificacion.getNombre());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        TipoPresentacion tipoPresentacionUno = new TipoPresentacion(1);
        TipoPresentacion tipoPresentacionDos = new TipoPresentacion(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacionUno);
        facade().getEntityManager().persist(tipoPresentacionDos);
        facade().remove(new TipoPresentacion(1));
        assertEquals(tipoPresentacionDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        TipoPresentacion tipoPresentacion = new TipoPresentacion(1,"Pastilla");

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacion);

        assertEquals(tipoPresentacion, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        TipoPresentacion tipoPresentacionUno = new TipoPresentacion(1);
        TipoPresentacion tipoPresentacionDos = new TipoPresentacion(2);

        List<TipoPresentacion> list = new ArrayList<>();
        list.add(tipoPresentacionUno);
        list.add(tipoPresentacionDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacionUno);
        facade().getEntityManager().persist(tipoPresentacionUno);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        TipoPresentacion tipoPresentacionUno = new TipoPresentacion(1,"Pastilla");
        TipoPresentacion tipoPresentacionDos = new TipoPresentacion(2,"Pomada");

        List<TipoPresentacion> list = new ArrayList<>();
        list.add(tipoPresentacionUno);
        list.add(tipoPresentacionDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacionUno);
        facade().getEntityManager().persist(tipoPresentacionDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        TipoPresentacion tipoPresentacionUno = new TipoPresentacion(1,"Pastilla");
        TipoPresentacion tipoPresentacionDos = new TipoPresentacion(2,"Pomada");

        List<TipoPresentacion> list = new ArrayList<>();
        list.add(tipoPresentacionUno);
        list.add(tipoPresentacionDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(tipoPresentacionUno);
        facade().getEntityManager().persist(tipoPresentacionDos);

        assertEquals(list.size(), facade().count());
    }

}
