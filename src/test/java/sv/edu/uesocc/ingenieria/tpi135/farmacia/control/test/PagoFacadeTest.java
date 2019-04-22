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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.PagoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Pago;


/**
 *
 * @author jonahdz
 */@RunWith(MockitoJUnitRunner.class)
public class PagoFacadeTest extends AbstractFacadeTest<Pago>{
    
     @InjectMocks
    private PagoFacade pagoFacade;

    @Override
    public AbstractFacade facade() {
        return pagoFacade;
    }

    public PagoFacadeTest() {
        super(Pago.class, new Pago());
    }
    
}
