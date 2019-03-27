/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
