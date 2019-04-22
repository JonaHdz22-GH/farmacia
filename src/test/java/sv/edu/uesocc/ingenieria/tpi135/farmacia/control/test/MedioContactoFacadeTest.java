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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.MedioContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.MedioContacto;


/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class MedioContactoFacadeTest extends AbstractFacadeTest<MedioContacto>{
     
    @InjectMocks
    private MedioContactoFacade medioContactoFacade;

    @Override
    public AbstractFacade facade() {
        return medioContactoFacade;
    }

    public MedioContactoFacadeTest() {
        super(MedioContacto.class, new MedioContacto());
    }
    
}
