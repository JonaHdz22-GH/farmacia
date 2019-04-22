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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;

/**
 *
 * @author luis
 */
public class ProductoFacadeIT {

    ProductoFacade productoFacade = new ProductoFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", productoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Producto producto = new Producto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(producto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Producto producto = new Producto(1,"Pomada Alcohol");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(producto);
        Producto modificacion = new Producto(1,"Gel alcohol");
        facade().edit(modificacion);
        assertEquals(modificacion.getNombre(), modificacion.getNombre());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Producto productoUno = new Producto(1);
        Producto productoDos = new Producto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(productoUno);
        facade().getEntityManager().persist(productoDos);
        facade().remove(new Producto(1));
        assertEquals(productoDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Producto producto = new Producto(1,"Pomada Alcohol");

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(producto);

        assertEquals(producto, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Producto productoUno = new Producto(1);
        Producto productoDos = new Producto(2);

        List<Producto> list = new ArrayList<>();
        list.add(productoUno);
        list.add(productoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(productoUno);
        facade().getEntityManager().persist(productoDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Producto productoUno = new Producto(1);
        Producto productoDos = new Producto(2);

        List<Producto> list = new ArrayList<>();
        list.add(productoUno);
        list.add(productoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(productoUno);
        facade().getEntityManager().persist(productoDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        Producto productoUno = new Producto(1);
        Producto productoDos = new Producto(2);

        List<Producto> list = new ArrayList<>();
        list.add(productoUno);
        list.add(productoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(productoUno);
        facade().getEntityManager().persist(productoDos);

        assertEquals(list.size(), facade().count());
    }

}
