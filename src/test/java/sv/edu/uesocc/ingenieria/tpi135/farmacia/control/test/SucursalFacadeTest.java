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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class SucursalFacadeTest extends AbstractFacadeTest<Sucursal> {

    @InjectMocks
    private SucursalFacade sucursalFacade;

    @Override
    public AbstractFacade facade() {
        return sucursalFacade;
    }

    public SucursalFacadeTest() {
        super(Sucursal.class, new Sucursal());
    }

}
