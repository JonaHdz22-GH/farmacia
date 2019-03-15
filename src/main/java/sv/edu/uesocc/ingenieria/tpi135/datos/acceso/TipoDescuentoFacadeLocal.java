/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.TipoDescuento;

/**
 *
 * @author jonahdz
 */
@Local
public interface TipoDescuentoFacadeLocal {

    void create(TipoDescuento tipoDescuento);

    void edit(TipoDescuento tipoDescuento);

    void remove(TipoDescuento tipoDescuento);

    TipoDescuento find(Object id);

    List<TipoDescuento> findAll();

    List<TipoDescuento> findRange(int[] range);

    int count();
    
}
