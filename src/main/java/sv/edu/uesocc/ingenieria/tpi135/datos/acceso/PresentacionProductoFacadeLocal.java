/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.PresentacionProducto;

/**
 *
 * @author jonahdz
 */
@Local
public interface PresentacionProductoFacadeLocal {

    void create(PresentacionProducto presentacionProducto);

    void edit(PresentacionProducto presentacionProducto);

    void remove(PresentacionProducto presentacionProducto);

    PresentacionProducto find(Object id);

    List<PresentacionProducto> findAll();

    List<PresentacionProducto> findRange(int[] range);

    int count();
    
}
