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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.ProveedorProducto;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmProductoTest {

    protected Producto registro;
    protected List<Producto> listProducto;
    protected List<ProveedorProducto> listProveedorProducto;
    
    @InjectMocks
    FrmProducto frmProducto = new FrmProducto();

    @Before
    public void setUp() {
        this.listProducto = new ArrayList<>();
        listProducto.add(new Producto(1));
        registro = new Producto(1);
        registro.setIdProveedorProducto(new ProveedorProducto(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Producto entity = Mockito.mock(Producto.class);
        Object exp = 1;
        Mockito.when(entity.getIdProducto()).thenReturn(1);
        Assert.assertEquals(frmProducto.clavePorDatos(new Producto(1)),exp);
        Assert.assertEquals(frmProducto.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listProducto);
        frmProducto.lazymodel=lazy;
        Assert.assertEquals(frmProducto.datosPorClave("1"),new Producto(1));
        boolean aser=false;
        try{
            frmProducto.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmProducto.datosPorClave(null));
    }
    
    @Test
    public void testGetIdProveedorProductoSeleccionado() {
        System.out.println("testGetIdProveedorProductoSeleccionado");
        Producto producto = Mockito.mock(Producto.class);
        ProveedorProducto proveedorp = Mockito.mock(ProveedorProducto.class);
        Mockito.when(producto.getIdProveedorProducto()).thenReturn(proveedorp);
        Mockito.when(proveedorp.getIdProveedorProducto()).thenReturn(1);
        frmProducto.setRegistro(registro);
        Assert.assertEquals(frmProducto.getIdProveedorProductoSeleccionado(),new Integer(1));
        registro.setIdProveedorProducto(null);
        Assert.assertNull(frmProducto.getIdProveedorProductoSeleccionado());
    }
    
    @Test
    public void testSetIdProveedorProductoSeleccionado(){
        System.out.println("testSetIdProveedorProductoSeleccionado");
        FrmProducto frm = Mockito.spy(frmProducto);
        Producto reg = Mockito.mock(Producto.class);
        List<ProveedorProducto> list = Mockito.mock(List.class);
        listProveedorProducto = new ArrayList<>();
        listProveedorProducto.add(new ProveedorProducto(1));
        frmProducto.setRegistro(registro);
        frmProducto.setListaProveedorProducto(listProveedorProducto);
        frmProducto.registro = reg;
        frmProducto.listaProveedorProducto = listProveedorProducto;
        frmProducto.setIdProveedorProductoSeleccionado(1);
        Mockito.verify(reg).setIdProveedorProducto(new ProveedorProducto(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmProducto.setIdProveedorProductoSeleccionado(2);
        }catch(Exception ex){
            aser=true; 
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testInicioListas(){
        System.out.println("testInicioLista");
        ProveedorProductoFacade facade = Mockito.mock(ProveedorProductoFacade.class);
        frmProducto.proveedorProductoFacade=facade;
        frmProducto.inicioLista();
        Mockito.verify(facade).findAll();
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmProducto frm = Mockito.spy(frmProducto);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmProducto frm = Mockito.spy(frmProducto);
        Assert.assertEquals(frm.registroNew(),new Producto());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmProducto frm = Mockito.spy(frmProducto);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }
    
    @Test
    public void testGetListaProveedorProducto(){
        System.out.println("testGetListaProveedorProducto");
        FrmProducto frm = Mockito.mock(FrmProducto.class);
        List<ProveedorProducto> lista = Mockito.mock(List.class);
        Mockito.when(frm.getListaProveedorProducto()).thenReturn(lista);
        Assert.assertEquals(frmProducto.getListaProveedorProducto(),listProveedorProducto);
    }
}
