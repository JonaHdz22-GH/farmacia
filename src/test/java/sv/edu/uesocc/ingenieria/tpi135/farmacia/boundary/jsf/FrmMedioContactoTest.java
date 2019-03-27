/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import javax.persistence.EntityManager;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.MedioContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;

/**
 *
 * @author jonahdz
 */

@RunWith(MockitoJUnitRunner.class)
public class FrmMedioContactoTest {
    
    @Mock
    private EntityManager em;
    private MedioContacto medioContacto;
    private FrmMedioContacto frmMedioContacto;
    
    @Test
    public void testInsertar(){
        System.out.println("Insertar");
        
    }
}
