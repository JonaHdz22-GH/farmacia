package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.List;

/**
 *
 * @author luis21
 * @param <T>
 */
public interface AbstractInterface<T> {
    
    public void create(T entity);
    
    public void edit(T entity);
    
    public void remove(T entity);
    
    public T findById(Object id);
    
    public List<T> findAll();
    
    public List<T> findRange(int inicio, int tamanio);
    
    public int count();
}
