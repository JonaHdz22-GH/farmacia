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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoPresentacionFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class TipoPresentacionFacadeTest extends AbstractFacadeTest<TipoPresentacion> {

    @InjectMocks
    private TipoPresentacionFacade tipoPresentacionFacade;

    @Override
    public AbstractFacade facade() {
        return tipoPresentacionFacade;
    }

    public TipoPresentacionFacadeTest() {
        super(TipoPresentacion.class, new TipoPresentacion());
    }

}
