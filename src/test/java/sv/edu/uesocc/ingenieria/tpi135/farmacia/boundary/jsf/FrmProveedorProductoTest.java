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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;


/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmProveedorProductoTest {
    
    protected ProveedorProducto registro;
    protected List<ProveedorProducto> listProveedorProducto;
    protected List<Proveedor> listProveedor;
    
    @InjectMocks
    FrmProveedorProducto frmProveedorProducto = new FrmProveedorProducto();

    @Before
    public void setUp() {
        this.listProveedorProducto = new ArrayList<>();
        listProveedorProducto.add(new ProveedorProducto(1));
        registro = new ProveedorProducto(1);
        registro.setIdProveedor(new Proveedor(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        ProveedorProducto entity = Mockito.mock(ProveedorProducto.class);
        Object exp = 1;
        Mockito.when(entity.getIdProveedorProducto()).thenReturn(1);
        Assert.assertEquals(frmProveedorProducto.clavePorDatos(new ProveedorProducto(1)),exp);
        Assert.assertEquals(frmProveedorProducto.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listProveedorProducto);
        frmProveedorProducto.lazymodel=lazy;
        Assert.assertEquals(frmProveedorProducto.datosPorClave("1"),new ProveedorProducto(1));
        boolean aser=false;
        try{
            frmProveedorProducto.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmProveedorProducto.datosPorClave(null));
    }
    
    @Test
    public void testGetIdProveedorSeleccionado() {
        System.out.println("testGetIdProveedorSeleccionado");
        Proveedor proveedor = Mockito.mock(Proveedor.class);
        ProveedorProducto proveedorp = Mockito.mock(ProveedorProducto.class);
        Mockito.when(proveedorp.getIdProveedor()).thenReturn(proveedor);
        Mockito.when(proveedor.getIdProveedor()).thenReturn(1);
        frmProveedorProducto.setRegistro(registro);
        Assert.assertEquals(frmProveedorProducto.getIdProveedorSeleccionado(),new Integer(1));
        registro.setIdProveedor(null);
        Assert.assertNull(frmProveedorProducto.getIdProveedorSeleccionado());
    }
    
    @Test
    public void testSetIdProveedorSeleccionado(){
        System.out.println("testSetIdProveedorSeleccionado");
        FrmProveedorProducto frm = Mockito.spy(frmProveedorProducto);
        ProveedorProducto reg = Mockito.mock(ProveedorProducto.class);
        List<Proveedor> list = Mockito.mock(List.class);
        listProveedor = new ArrayList<>();
        listProveedor.add(new Proveedor(1));
        frmProveedorProducto.setRegistro(registro);
        frmProveedorProducto.setListaProveedor(listProveedor);
        frmProveedorProducto.registro = reg;
        frmProveedorProducto.listaProveedor = listProveedor;
        frmProveedorProducto.setIdProveedorSeleccionado(1);
        Mockito.verify(reg).setIdProveedor(new Proveedor(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmProveedorProducto.setIdProveedorSeleccionado(2);
        }catch(Exception ex){
            aser=true; 
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testInicioLista(){
        System.out.println("testInicioLista");
        ProveedorFacade facade = Mockito.mock(ProveedorFacade.class);
        frmProveedorProducto.proveedorFacade=facade;
        frmProveedorProducto.inicioLista();
        Mockito.verify(facade).findAll();
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmProveedorProducto frm = Mockito.spy(frmProveedorProducto);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmProveedorProducto frm = Mockito.spy(frmProveedorProducto);
        Assert.assertEquals(frm.registroNew(),new ProveedorProducto());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmProveedorProducto frm = Mockito.spy(frmProveedorProducto);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }
    
    @Test
    public void testGetListaProveedor(){
        System.out.println("testGetListaProveedor");
        FrmProveedorProducto frm = Mockito.mock(FrmProveedorProducto.class);
        List<Proveedor> lista = Mockito.mock(List.class);
        Mockito.when(frm.getListaProveedor()).thenReturn(lista);
        Assert.assertEquals(frmProveedorProducto.getListaProveedor(),listProveedor);
    }
}
