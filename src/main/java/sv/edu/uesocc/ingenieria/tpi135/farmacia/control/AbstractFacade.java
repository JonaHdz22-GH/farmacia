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

    public void create(T entity) {

        if (entity != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.persist(entity);
            } else {
                throw new IllegalStateException("em null");
            }
        } else {
            throw new IllegalArgumentException("entity null");
        }

    }

    public void edit(T entity) {
        if (entity != null) {
            EntityManager em = getEntityManager();
            if (em != null) {
                em.merge(entity);
            } else {
                throw new IllegalStateException("em null");
            }
        } else {
            throw new IllegalArgumentException("entity null");
        }
    }

    public void remove(T entity) {
        if(entity != null){
            EntityManager em = getEntityManager();
            if (em != null) {
                em.remove(em.merge(entity));   
            } else {
                throw new IllegalStateException("em null");
            }
        }else{
            throw new IllegalArgumentException("entity null");
        }
    }

    public T findById(Object id) {
        EntityManager em = getEntityManager();
        if (id != null) {
            if (em != null) {
                return (T) em.find(entityClass,id);
            }
            throw new IllegalStateException("em null");
        }
        throw new IllegalArgumentException("id null");
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
