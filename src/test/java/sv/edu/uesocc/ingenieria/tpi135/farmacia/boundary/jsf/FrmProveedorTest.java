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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmProveedorTest {

    protected List<Proveedor> listProveedor;
    
    @InjectMocks
    FrmProveedor frmProveedor = new FrmProveedor();

    @Before
    public void setUp() {
        this.listProveedor = new ArrayList<>();
        listProveedor.add(new Proveedor(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Proveedor entity = Mockito.mock(Proveedor.class);
        Object exp = 1;
        Mockito.when(entity.getIdProveedor()).thenReturn(1);
        Assert.assertEquals(frmProveedor.clavePorDatos(new Proveedor(1)),exp);
        Assert.assertEquals(frmProveedor.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listProveedor);
        frmProveedor.lazymodel=lazy;
        Assert.assertEquals(frmProveedor.datosPorClave("1"),new Proveedor(1));
        boolean aser=false;
        try{
            frmProveedor.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmProveedor.datosPorClave(null));
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmProveedor frm = Mockito.spy(frmProveedor);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmProveedor frm = Mockito.spy(frmProveedor);
        Assert.assertEquals(frm.registroNew(),new Proveedor());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmProveedor frm = Mockito.spy(frmProveedor);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }

}
