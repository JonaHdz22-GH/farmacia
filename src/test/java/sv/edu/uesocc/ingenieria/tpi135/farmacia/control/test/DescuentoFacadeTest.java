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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DescuentoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Descuento;


/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class DescuentoFacadeTest extends AbstractFacadeTest<Descuento>{
    
    @InjectMocks
    private DescuentoFacade descuentoFacade;

    @Override
    public AbstractFacade facade() {
        return descuentoFacade;
    }

    public DescuentoFacadeTest() {
        super(Descuento.class, new Descuento());
    }
    
}
