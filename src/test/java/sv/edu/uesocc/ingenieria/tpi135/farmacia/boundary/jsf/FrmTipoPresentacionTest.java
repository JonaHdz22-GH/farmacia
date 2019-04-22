/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoPresentacion;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmTipoPresentacionTest {

    protected List<TipoPresentacion> listTipoPresentacion;
    
    @InjectMocks
    FrmTipoPresentacion frmTipoPresentacion = new FrmTipoPresentacion();

    @Before
    public void setUp() {
        this.listTipoPresentacion = new ArrayList<>();
        listTipoPresentacion.add(new TipoPresentacion(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        TipoPresentacion entity = Mockito.mock(TipoPresentacion.class);
        Object exp = 1;
        Mockito.when(entity.getIdTipoPresentacion()).thenReturn(1);
        Assert.assertEquals(frmTipoPresentacion.clavePorDatos(new TipoPresentacion(1)),exp);
        Assert.assertEquals(frmTipoPresentacion.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listTipoPresentacion);
        frmTipoPresentacion.lazymodel=lazy;
        Assert.assertEquals(frmTipoPresentacion.datosPorClave("1"),new TipoPresentacion(1));
        boolean aser=false;
        try{
            frmTipoPresentacion.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmTipoPresentacion.datosPorClave(null));
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmTipoPresentacion frm = Mockito.spy(frmTipoPresentacion);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmTipoPresentacion frm = Mockito.spy(frmTipoPresentacion);
        Assert.assertEquals(frm.registroNew(),new TipoPresentacion());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmTipoPresentacion frm = Mockito.spy(frmTipoPresentacion);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }

}
