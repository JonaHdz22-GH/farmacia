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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author luis
 */
public class ProveedorProductoFacadeIT {

    ProveedorProductoFacade proveedorProductoFacade = new ProveedorProductoFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", proveedorProductoFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        ProveedorProducto proveedorProducto = new ProveedorProducto(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(proveedorProducto);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        ProveedorProducto proveedorProducto = new ProveedorProducto(1, 300.06, 34.05);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProducto);
        ProveedorProducto modificacion = new ProveedorProducto(1, 300.06, 36);
        facade().edit(modificacion);
        assertEquals(modificacion.getDescuentoCompra(), modificacion.getDescuentoCompra());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        ProveedorProducto proveedorProductoUno = new ProveedorProducto(1);
        ProveedorProducto proveedorProductoDos = new ProveedorProducto(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProductoUno);
        facade().getEntityManager().persist(proveedorProductoDos);
        facade().remove(new ProveedorProducto(1));
        assertEquals(proveedorProductoDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        ProveedorProducto proveedorProducto = new ProveedorProducto(1);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProducto);

        assertEquals(proveedorProducto, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll"); 
        ProveedorProducto proveedorProductoUno = new ProveedorProducto(1);
        ProveedorProducto proveedorProductoDos = new ProveedorProducto(2);

        List<ProveedorProducto> list = new ArrayList<>();
        list.add(proveedorProductoUno);
        list.add(proveedorProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProductoUno);
        facade().getEntityManager().persist(proveedorProductoDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");   
        ProveedorProducto proveedorProductoUno = new ProveedorProducto(1);
        ProveedorProducto proveedorProductoDos = new ProveedorProducto(2);

        List<ProveedorProducto> list = new ArrayList<>();
        list.add(proveedorProductoUno);
        list.add(proveedorProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProductoUno);
        facade().getEntityManager().persist(proveedorProductoDos);
        
        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        ProveedorProducto proveedorProductoUno = new ProveedorProducto(1);
        ProveedorProducto proveedorProductoDos = new ProveedorProducto(2);

        List<ProveedorProducto> list = new ArrayList<>();
        list.add(proveedorProductoUno);
        list.add(proveedorProductoDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorProductoUno);
        facade().getEntityManager().persist(proveedorProductoDos);

        assertEquals(list.size(), facade().count());
    }

}
