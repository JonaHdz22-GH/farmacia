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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.FormaPagoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class FormaPagoFacadeTest extends AbstractFacadeTest<FormaPago> {
    
    @InjectMocks
    private FormaPagoFacade formaPagoFacade;

    @Override
    public AbstractFacade facade() {
        return formaPagoFacade;
    }

    public FormaPagoFacadeTest() {
        super(FormaPago.class, new FormaPago());
    }
    
}
