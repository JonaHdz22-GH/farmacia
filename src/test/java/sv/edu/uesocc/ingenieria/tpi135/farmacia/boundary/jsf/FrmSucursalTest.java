/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.primefaces.model.LazyDataModel;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmSucursalTest {

    protected List<Sucursal> listSucursal;
    
    @InjectMocks
    FrmSucursal frmSucursal = new FrmSucursal();

    @Before
    public void setUp() {
        this.listSucursal = new ArrayList<>();
        listSucursal.add(new Sucursal(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Sucursal entity = Mockito.mock(Sucursal.class);
        Object exp = 1;
        Mockito.when(entity.getIdSucursal()).thenReturn(1);
        Assert.assertEquals(frmSucursal.clavePorDatos(new Sucursal(1)),exp);
        Assert.assertEquals(frmSucursal.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listSucursal);
        frmSucursal.lazymodel=lazy;
        Assert.assertEquals(frmSucursal.datosPorClave("1"),new Sucursal(1));
        boolean aser=false;
        try{
            frmSucursal.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmSucursal.datosPorClave(null));
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmSucursal frm = Mockito.spy(frmSucursal);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmSucursal frm = Mockito.spy(frmSucursal);
        Assert.assertEquals(frm.registroNew(),new Sucursal());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmSucursal frm = Mockito.spy(frmSucursal);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }

}
