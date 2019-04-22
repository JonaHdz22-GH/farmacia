/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.UsuarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioFacadeTest extends AbstractFacadeTest<Usuario>{
    
    @InjectMocks
    private UsuarioFacade usuarioFacade;

    @Override
    public AbstractFacade facade() {
        return usuarioFacade;
    }

    public UsuarioFacadeTest() {
        super(Usuario.class, new Usuario());
    }
}
