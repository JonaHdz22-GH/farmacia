/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.FacturaFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Factura;

/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class FacturaFacadeTest extends AbstractFacadeTest<Factura>{
    
    @InjectMocks
    private FacturaFacade facturaFacade;

    @Override
    public AbstractFacade facade() {
        return facturaFacade;
    }

    public FacturaFacadeTest() {
        super(Factura.class, new Factura());
    }
    
}
