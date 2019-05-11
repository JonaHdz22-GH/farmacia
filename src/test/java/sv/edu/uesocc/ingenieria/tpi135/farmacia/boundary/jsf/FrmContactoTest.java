/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmContactoTest extends AbstractFrmDataModelTest<Contacto>{
    
    protected List<Contacto> listContacto;
    
    @InjectMocks
    FrmContacto frmContacto = new FrmContacto();
    @InjectMocks
    ContactoFacade contactoFacade = new ContactoFacade();
    @InjectMocks
    Contacto cotacto = new Contacto();
    
    @Override
    public AbstractFacade getFacade() {
        return contactoFacade;
    }
    
    public FrmContactoTest() {
        super(new Contacto(1));
    }
    
    @Before
    public void setUp() {
        this.listContacto = new ArrayList<>();
        listContacto.add(new Contacto(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Contacto entity = Mockito.mock(Contacto.class);
        Object exp = 1;
        Mockito.when(entity.getIdContacto()).thenReturn(1);
        Assert.assertEquals(frmContacto.clavePorDatos(new Contacto(1)),exp);
        Assert.assertEquals(frmContacto.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listContacto);
        frmContacto.lazymodel=lazy;
        Assert.assertEquals(frmContacto.datosPorClave("1"),new Contacto(1));
        boolean aser=false;
        try{
            frmContacto.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmContacto.datosPorClave(null));
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmContacto fre = Mockito.spy(frmContacto);
        fre.getFacade();
        Mockito.verify(fre).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmContacto fre = Mockito.spy(frmContacto);
        Assert.assertEquals(fre.registroNew(),new Contacto());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmContacto fre = Mockito.spy(frmContacto);
        fre.inicializar();
        Mockito.verify(fre).inicializar();
    }
}
