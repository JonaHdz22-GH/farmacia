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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author luis
 */
public class ProveedorFacadeIT {

    ProveedorFacade proveedorFacade = new ProveedorFacade();
    @Rule
    public EntityManagerProvider emp = EntityManagerProvider.getInstance("integration-test-farmacia", proveedorFacade);

    public AbstractFacade facade() {
        return emp.getFacade();
    }

    @Test
    public void testCreate() {
        System.out.println("create");
        Proveedor proveedor = new Proveedor(1);
        facade().getEntityManager().getTransaction().begin();
        facade().create(proveedor);
        List list = facade().findAll();
        assertEquals(1, list.size());
    }

    @Test
    public void testEdit() {
        System.out.println("edit");
        Proveedor proveedor = new Proveedor(1,"Susana","Morches","Santa Ana");
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedor);
        Proveedor modificacion = new Proveedor(1,"Susana","Morches-VJ","Santa Ana");
        facade().edit(modificacion);
        assertEquals(modificacion.getNombreEmpresa(), modificacion.getNombreEmpresa());
    }

    @Test
    public void testDelete() {
        System.out.println("delete");
        Proveedor proveedorUno = new Proveedor(1);
        Proveedor proveedorDos = new Proveedor(2);
        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorUno);
        facade().getEntityManager().persist(proveedorDos);
        facade().remove(new Proveedor(1));
        assertEquals(proveedorDos, facade().findById(2));
    }

    @Test
    public void testFindById() {
        System.out.println("findById");
        Proveedor proveedor = new Proveedor(1,"Susana","Morches","Santa Ana");

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedor);

        assertEquals(proveedor, facade().findById(1));
    }

    @Test
    public void testFindAll() {
        System.out.println("findAll");
        Proveedor proveedorUno = new Proveedor(1);
        Proveedor proveedorDos = new Proveedor(2);

        List<Proveedor> list = new ArrayList<>();
        list.add(proveedorUno);
        list.add(proveedorDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorUno);
        facade().getEntityManager().persist(proveedorDos);

        assertEquals(list, facade().findAll());
    }

    @Test
    public void testFindRange() {
        System.out.println("findRange");
        Proveedor proveedorUno = new Proveedor(1);
        Proveedor proveedorDos = new Proveedor(2);

        List<Proveedor> list = new ArrayList<>();
        list.add(proveedorUno);
        list.add(proveedorDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorUno);
        facade().getEntityManager().persist(proveedorDos);

        int inicio = 1;
        int tamanio = 2;
        assertEquals(list.get(0), facade().findRange(inicio, tamanio).get(0));
    }

    @Test
    public void testCount() {
        System.out.println("count");
        Proveedor proveedorUno = new Proveedor(1);
        Proveedor proveedorDos = new Proveedor(2);

        List<Proveedor> list = new ArrayList<>();
        list.add(proveedorUno);
        list.add(proveedorDos);

        facade().getEntityManager().getTransaction().begin();
        facade().getEntityManager().persist(proveedorUno);
        facade().getEntityManager().persist(proveedorDos);

        assertEquals(list.size(), facade().count());
    }

}
