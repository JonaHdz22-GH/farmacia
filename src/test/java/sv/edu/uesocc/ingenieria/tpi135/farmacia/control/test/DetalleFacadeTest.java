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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Detalle;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class DetalleFacadeTest extends AbstractFacadeTest<Detalle>{

    @InjectMocks
    private DetalleFacade detalleFacade;

    @Override
    public AbstractFacade facade() {
        return detalleFacade;
    }

    public DetalleFacadeTest() {
        super(Detalle.class, new Detalle());
    }
    
}
