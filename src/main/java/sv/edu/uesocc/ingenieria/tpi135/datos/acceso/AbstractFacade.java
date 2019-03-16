/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jonahdz
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void crear(T entity) {
        //getEntityManager().persist(entity);
        EntityManager em = getEntityManager();
        try {
            if (entity != null) {
                if (em != null) {
                    em.persist(entity);
                }
                throw new IllegalStateException("El entity manager es nulo");
            }
            throw new IllegalArgumentException("La entidad recibida es nula");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void editar(T entity) {
        //getEntityManager().merge(entity);
        EntityManager em = getEntityManager();
        try {
            if (entity != null) {
                if (em != null) {
                    em.merge(entity);
                }
                throw new IllegalStateException("El entity manager es nulo");
            }
            throw new IllegalArgumentException("La entidad recibida es nula");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public void remover(T entity) {
        //getEntityManager().remove(getEntityManager().merge(entity));
        EntityManager em = getEntityManager();
        try {
            if (entity != null) {
                if (em != null) {
                    em.remove(getEntityManager().merge(entity));
                }
                throw new IllegalStateException("El entity manager es nulo");
            }
            throw new IllegalArgumentException("La entidad recibida es nula");
        } catch (Exception ex) {
            System.out.println("ERROR: " + ex);
        }
    }

    public T findById(Object id) {
        //return getEntityManager().find(entityClass, id);
        if (id != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                return (T) em.find(entityClass, id);
            }
            throw new IllegalStateException("El entity manager es nulo");
        }
        throw new IllegalArgumentException("La id es nulo" + id);
    }

    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public List<T> findRange(int inicio, int tamanio) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(tamanio);
        q.setFirstResult(inicio);
        return q.getResultList();
    }

    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

}
