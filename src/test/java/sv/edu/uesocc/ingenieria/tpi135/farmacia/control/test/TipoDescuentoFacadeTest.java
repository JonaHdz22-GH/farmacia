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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoDescuentoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.test.AbstractFacadeTest;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;


/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class TipoDescuentoFacadeTest extends AbstractFacadeTest<TipoDescuento>{
    
    @InjectMocks
    private TipoDescuentoFacade tipoDescuentoFacade;

    @Override
    public AbstractFacade facade() {
        return tipoDescuentoFacade;
    }

    public TipoDescuentoFacadeTest() {
        super(TipoDescuento.class, new TipoDescuento());
    }
    
}
