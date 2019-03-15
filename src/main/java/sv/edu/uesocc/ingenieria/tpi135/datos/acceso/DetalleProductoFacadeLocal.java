/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.DetalleProducto;

/**
 *
 * @author jonahdz
 */
@Local
public interface DetalleProductoFacadeLocal {

    void create(DetalleProducto detalleProducto);

    void edit(DetalleProducto detalleProducto);

    void remove(DetalleProducto detalleProducto);

    DetalleProducto find(Object id);

    List<DetalleProducto> findAll();

    List<DetalleProducto> findRange(int[] range);

    int count();
    
}
