package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author jonahdz
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public abstract EntityManager getEntityManager();

    public void create(T entity) {

        if (entity != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.persist(entity);
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException();
        }

    }

    public void edit(T entity) {
        if (entity != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.merge(entity);
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void remove(T entity) {
        if (entity != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.remove(em.merge(entity));
            } else {
                throw new IllegalStateException();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    /**
     * metodo para CREAR un archivo mediante los servicios REST
     * @param entity
     * @return 
     */
    public T crear(T entity) {
        EntityManager em = getEntityManager();
        try {
            if (em != null && entity != null) {
                em.persist(entity);
                return entity;
            } else {
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    /**
     * metodo para EDITAR un archivo mediante los servicios REST
     * @param entity
     * @return 
     */
    public T editar(T entity) {
        EntityManager em = getEntityManager();
        try {
            if (em != null && entity != null) {
                em.merge(entity);
                return entity;
            } else {
                System.out.println("algo es nulo");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

        return null;
    }

    /**
     * metodo para ELIMINAR un archivo mediante los servicios REST
     * @param entity
     * @return 
     */
    public T remover(T entity) {
        EntityManager em = getEntityManager();
        try {
            if (em != null && entity != null) {
                em.remove(getEntityManager().merge(entity));
                return entity;
            } else {
                System.out.println("algo es nulo");
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }
        return null;
    }

    public T findById(Object id) {
        EntityManager em = getEntityManager();
        if (id != null) {
            if (em != null) {
                return (T) em.find(entityClass, id);
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }

    public List<T> findAll() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int inicio, int tamanio) {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(tamanio);
        q.setFirstResult(inicio);
        return q.getResultList();
    }

    public int count() {
        CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
