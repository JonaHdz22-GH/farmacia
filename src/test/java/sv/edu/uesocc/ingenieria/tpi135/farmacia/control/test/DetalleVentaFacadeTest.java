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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleVentaFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleVenta;


/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class DetalleVentaFacadeTest extends AbstractFacadeTest<DetalleVenta>{
    
    @InjectMocks
    private DetalleVentaFacade detalleVentaFacade;

    @Override
    public AbstractFacade facade() {
        return detalleVentaFacade;
    }

    public DetalleVentaFacadeTest() {
        super(DetalleVenta.class, new DetalleVenta());
    }
}
