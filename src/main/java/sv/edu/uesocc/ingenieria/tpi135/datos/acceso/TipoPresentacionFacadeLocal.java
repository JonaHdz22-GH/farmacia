/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.TipoPresentacion;

/**
 *
 * @author jonahdz
 */
@Local
public interface TipoPresentacionFacadeLocal {

    void create(TipoPresentacion tipoPresentacion);

    void edit(TipoPresentacion tipoPresentacion);

    void remove(TipoPresentacion tipoPresentacion);

    TipoPresentacion find(Object id);

    List<TipoPresentacion> findAll();

    List<TipoPresentacion> findRange(int[] range);

    int count();
    
}
