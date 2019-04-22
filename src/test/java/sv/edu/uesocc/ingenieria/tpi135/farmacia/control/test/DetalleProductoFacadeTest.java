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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleProducto;


/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class DetalleProductoFacadeTest extends AbstractFacadeTest<DetalleProducto> {
    
    @InjectMocks
    private DetalleProductoFacade detalleProductoFacade;

    @Override
    public AbstractFacade facade() {
        return detalleProductoFacade;
    }

    public DetalleProductoFacadeTest() {
        super(DetalleProducto.class, new DetalleProducto());
    }
    
}
