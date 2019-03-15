/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.datos.acceso;

import java.util.List;
import javax.ejb.Local;
import sv.edu.uesocc.ingenieria.tpi135.datos.definicion.Contacto;

/**
 *
 * @author jonahdz
 */
@Local
public interface ContactoFacadeLocal {

    void create(Contacto contacto);

    void edit(Contacto contacto);

    void remove(Contacto contacto);

    Contacto find(Object id);

    List<Contacto> findAll();

    List<Contacto> findRange(int[] range);

    int count();
    
}
