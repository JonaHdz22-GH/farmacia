package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;

/**
 *
 * @author luis
 */
public abstract class AbstractFacadeTest<T> {

    @Mock
    private EntityManager entityManager;
    @Mock
    private CriteriaQuery criteriaQuery;
    @Mock
    private CriteriaBuilder criteriaBuilder;
    @Mock
    protected TypedQuery typedQuery;
    @Mock
    private Root<T> root;

    private final Class<T> entityClass;
    List<T> list;
    T entity;

    public abstract AbstractFacade facade();

    /**
     * Constructor que recibe una clase entidad y una entidad para inicializarla
     * y asignarla a una variable local.
     * @param entityClass
     * @param entity
     */
    public AbstractFacadeTest(Class<T> entityClass, T entity) {
        this.entityClass = entityClass;
        this.entity = entity;
        this.list = new ArrayList();
        list.add(entity);
    }
    
    /**
     * Sobrecarga de resultado resiviendo un valor Long sobre la consulta
     * @param value 
     */
    public void mockResult(Long value) {
        when(typedQuery.getSingleResult()).thenReturn(value);
    }
    
    /**
     * Sobrecarga de resultado resiviendo una list de la entidad recibida sobre la consulta
     * @param list
     * 
     */
    public void mockResult(List<T> list) {
        when(typedQuery.getResultList()).thenReturn(list);
    }

    /**
     * Sobrecarga de resultado resiviendo una entidad sobre la consulta
     * @param entity 
     */
    public void mockResult(T entity) {
        when(typedQuery.getSingleResult()).thenReturn(entity);

    }

    /**
     * Metodo que se ejecuta antes de cada prueba,
     * ejecuta cada consulta necesaria para el test
     */
    @Before
    public void setUp() {
        when(entityManager.getCriteriaBuilder()).thenReturn(criteriaBuilder);
        when(criteriaBuilder.createQuery()).thenReturn(criteriaQuery);
        when(criteriaQuery.from(entityClass)).thenReturn(root);
        when(criteriaQuery.select(root)).thenReturn(criteriaQuery);
        when(entityManager.createQuery(criteriaQuery)).thenReturn(typedQuery);
    }

    /**
     * metodo generico para test de crear
     */
    @Test(expected = IllegalArgumentException.class)
    public void create() {
        System.out.println("testCreate");
        facade().create(entity);
        verify(entityManager, times(1)).persist(entity);
        facade().create(null);
    }

    /**
     * metodo generico para test de editar
     */
    @Test(expected = IllegalArgumentException.class)
    public void edit() {
        System.out.println("testEdit");
        facade().edit(entity);
        verify(entityManager, times(1)).merge(entity);
        facade().edit(null);
    }

    /**
     * metodo generico para test de eliminar
     */
    @Test(expected = IllegalArgumentException.class)
    public void remove() {
        System.out.println("testRemove");
        facade().remove(entity);
        verify(entityManager, times(1)).remove(entityManager.merge(entity));
        facade().remove(null);
    }

    /**
     * metodo generico para test de findbyid
     */
    @Test(expected = IllegalArgumentException.class)
    public void findById() {
        System.out.println("testFindById");
        when(entityManager.find(eq(entityClass), Mockito.any(Integer.class))).thenReturn(entity);
        T result = (T) facade().findById(1);
        assertEquals(entity, result);
        facade().findById(null);
    }

    /**
     * metodo generico para test de findall
     */
    @Test
    public void findAll() {
        System.out.println("testFindAll");
        mockResult(list);
        List<T> result = facade().findAll();
        assertNotNull(result);
        assertEquals(list, result);
    }

    /**
     * metodo generico para test de findrange
     */
    @Test
    public void findRange() {
        System.out.println("testFindRange");
        mockResult(list);
        List<T> result = facade().findRange(1, 1000);
        assertEquals(list, result);
    }

    /**
     * metodo generico para test para count
     */
    @Test
    public void count() {
        System.out.println("testCount");
        mockResult(5L);
        int result = facade().count();
        assertNotNull(result);
    }

}
