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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author luis
 */
public class SucursalFacadeIT {

    SucursalFacade sucursalFacade = new SucursalFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", sucursalFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Sucursal sucursal = new Sucursal(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(sucursal);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Sucursal sucursal = new Sucursal(1,"La bendicion", "Santa Ana","2567-5672");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursal);
        Sucursal modificacion = new Sucursal(1,"Doña Barbara", "Santa Ana","2567-5672");
        facade().edit(modificacion);
        assertEquals(modificacion.getNombreSucursal(), modificacion.getNombreSucursal());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Sucursal sucursalUno = new Sucursal(1);
        Sucursal sucursalDos = new Sucursal(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursalUno);
        facade().getEntityManager().persist(sucursalDos);
        facade().remove(new Sucursal(1));
        assertEquals(sucursalDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Sucursal sucursal = new Sucursal(1,"La bendicion", "Santa Ana","2567-5672");

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursal);

        assertEquals(sucursal, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Sucursal sucursalUno = new Sucursal(1);
        Sucursal sucursalDos = new Sucursal(2);

        List<Sucursal> list = new ArrayList<>();
        list.add(sucursalUno);
        list.add(sucursalDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursalUno);
        facade().getEntityManager().persist(sucursalDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Sucursal sucursalUno = new Sucursal(1);
        Sucursal sucursalDos = new Sucursal(2);

        List<Sucursal> list = new ArrayList<>();
        list.add(sucursalUno);
        list.add(sucursalDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursalUno);
        facade().getEntityManager().persist(sucursalDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        Sucursal sucursalUno = new Sucursal(1);
        Sucursal sucursalDos = new Sucursal(2);

        List<Sucursal> list = new ArrayList<>();
        list.add(sucursalUno);
        list.add(sucursalDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(sucursalUno);
        facade().getEntityManager().persist(sucursalDos);

        assertEquals(list.size(), facade().count());
    }

}
