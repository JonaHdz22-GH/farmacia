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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.PresentacionProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.PresentacionProducto;

/**
 *
 * @author luis
 */
public class PresentacionProductoFacadeIT {

    PresentacionProductoFacade presentacionProductoFacade = new PresentacionProductoFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", presentacionProductoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        PresentacionProducto presentacionProducto = new PresentacionProducto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(presentacionProducto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        PresentacionProducto presentacionProducto = new PresentacionProducto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProducto);
        PresentacionProducto modificacion = new PresentacionProducto(1);
        facade().edit(modificacion);
        assertEquals(modificacion.getIdTipoPresentacion(), modificacion.getIdTipoPresentacion());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        PresentacionProducto presentacionProductoUno = new PresentacionProducto(1);
        PresentacionProducto presentacionProductoDos = new PresentacionProducto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProductoUno);
        facade().getEntityManager().persist(presentacionProductoDos);
        facade().remove(new PresentacionProducto(1));
        assertEquals(presentacionProductoDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        PresentacionProducto presentacionProducto = new PresentacionProducto(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProducto);

        assertEquals(presentacionProducto, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        PresentacionProducto presentacionProductoUno = new PresentacionProducto(1);
        PresentacionProducto presentacionProductoDos = new PresentacionProducto(2);

        List<PresentacionProducto> list = new ArrayList<>();
        list.add(presentacionProductoUno);
        list.add(presentacionProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProductoUno);
        facade().getEntityManager().persist(presentacionProductoDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        PresentacionProducto presentacionProductoUno = new PresentacionProducto(1);
        PresentacionProducto presentacionProductoDos = new PresentacionProducto(2);

        List<PresentacionProducto> list = new ArrayList<>();
        list.add(presentacionProductoUno);
        list.add(presentacionProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProductoUno);
        facade().getEntityManager().persist(presentacionProductoDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        PresentacionProducto presentacionProductoUno = new PresentacionProducto(1);
        PresentacionProducto presentacionProductoDos = new PresentacionProducto(2);

        List<PresentacionProducto> list = new ArrayList<>();
        list.add(presentacionProductoUno);
        list.add(presentacionProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(presentacionProductoUno);
        facade().getEntityManager().persist(presentacionProductoDos);

        assertEquals(list.size(), facade().count());
    }
}
