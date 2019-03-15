/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.ProveedorProducto;

/**
 *
 * @author jonahdz
 */
@Local
public interface ProveedorProductoFacadeLocal {

    void create(ProveedorProducto proveedorProducto);

    void edit(ProveedorProducto proveedorProducto);

    void remove(ProveedorProducto proveedorProducto);

    ProveedorProducto find(Object id);

    List<ProveedorProducto> findAll();

    List<ProveedorProducto> findRange(int[] range);

    int count();
    
}
