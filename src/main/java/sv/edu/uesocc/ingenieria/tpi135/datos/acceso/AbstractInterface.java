/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;

/**
 *
 * @author luis21
 */
public interface AbstractInterface<T> {
    
    void crear(T entity);
    
    void editar(T entity);
    
    void remover(T entity);
    
    T findById(Object id);

    List<T> findAll();

    List<T> findRange(int inicio, int tamanio);

    int count();

    
}
