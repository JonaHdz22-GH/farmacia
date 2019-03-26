package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

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

    public boolean create(T entity) {
        try {
            getEntityManager().persist(entity);
            return true;
        } catch (Exception e) {
            return false;
        }   
    }

    public boolean edit(T entity) {
        try {
            getEntityManager().merge(entity);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean remove(T entity) {
        try {
            getEntityManager().remove(getEntityManager().merge(entity));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public T findById(Object id) {
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
