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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Inventario;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;


/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmInventarioTest {
    
    protected Inventario registro;
    protected List<Inventario> listInventario;
    protected List<Producto> listProducto;
    protected List<Sucursal> listSucursal;
    
    @InjectMocks
    FrmInventario frmInventario = new FrmInventario();

    @Before
    public void setUp() {
        this.listInventario = new ArrayList<>();
        listInventario.add(new Inventario(1));
        registro = new Inventario(1);
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Inventario entity = Mockito.mock(Inventario.class);
        Object exp = 1;
        Mockito.when(entity.getIdInventario()).thenReturn(1);
        Assert.assertEquals(frmInventario.clavePorDatos(new Inventario(1)),exp);
        Assert.assertEquals(frmInventario.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listInventario);
        frmInventario.lazymodel=lazy;
        Assert.assertEquals(frmInventario.datosPorClave("1"),new Inventario(1));
        boolean aser=false;
        try{
            frmInventario.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmInventario.datosPorClave(null));
    }
    
    @Test
    public void testGetIdProductoSeleccionado() {
        System.out.println("getIdProductoSeleccionado");
        Inventario inventario = Mockito.spy(registro);
        Producto producto = Mockito.spy(Producto.class);
        Mockito.when(inventario.getIdProducto()).thenReturn(new Producto());
        Mockito.when(producto.getIdProducto()).thenReturn(1);
        registro.setIdProducto(new Producto(1));
        frmInventario.setRegistro(registro);
        Assert.assertEquals(frmInventario.getIdProductoSeleccionado(),new Integer(1));
        registro.setIdProducto(null);
        Assert.assertNull(frmInventario.getIdProductoSeleccionado());
    }
    
    @Test
    public void testSetIdProductoSeleccionado(){
        System.out.println("testSetIdProductoSeleccionado");
        Inventario reg = Mockito.mock(Inventario.class);
        List<Producto> list = Mockito.mock(List.class);
        listProducto = new ArrayList<>();
        listProducto.add(new Producto(1));
        frmInventario.setRegistro(new Inventario(1));
        frmInventario.setListaProducto(listProducto);
        frmInventario.registro = reg;
        frmInventario.listaProducto = listProducto;
        frmInventario.setIdProductoSeleccionado(1);
        Mockito.verify(reg).setIdProducto(new Producto(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmInventario.setIdProductoSeleccionado(2);
        }catch(Exception ex){
            aser=true; 
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testGetIdSucursalSeleccionado() {
        System.out.println("getIdSucursalSeleccionado");
        Inventario inventario = Mockito.spy(registro);
        Sucursal sucursal = Mockito.spy(Sucursal.class);
        Mockito.when(inventario.getIdSucursal()).thenReturn(new Sucursal());
        Mockito.when(sucursal.getIdSucursal()).thenReturn(1);
        registro.setIdSucursal(new Sucursal(1));
        frmInventario.setRegistro(registro);
        Assert.assertEquals(frmInventario.getIdSucursalSeleccionado(),new Integer(1));
        registro.setIdSucursal(null);
        Assert.assertNull(frmInventario.getIdSucursalSeleccionado());
    }
    
    @Test
    public void testSetIdSucursalSeleccionado(){
        System.out.println("testSetIdSucursalSeleccionado");
        Inventario reg = Mockito.mock(Inventario.class);
        List<Sucursal> list = Mockito.mock(List.class);
        listSucursal = new ArrayList<>();
        listSucursal.add(new Sucursal(1));
        frmInventario.setRegistro(new Inventario(1));
        frmInventario.setListaSucursal(listSucursal);
        frmInventario.registro = reg;
        frmInventario.listaSucursal = listSucursal;
        frmInventario.setIdSucursalSeleccionado(1);
        Mockito.verify(reg).setIdSucursal(new Sucursal(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmInventario.setIdSucursalSeleccionado(2);
        }catch(Exception ex){
            aser=true; 
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testInicioProducto(){
        System.out.println("testInicioProducto");
        ProductoFacade facade = Mockito.mock(ProductoFacade.class);
        frmInventario.productoFacade=facade;
        frmInventario.inicioProducto();
        Mockito.verify(facade).findAll();
    }
    
    @Test
    public void testInicioListas(){
        System.out.println("testInicioSucursal");
        SucursalFacade facade = Mockito.mock(SucursalFacade.class);
        frmInventario.sucursalFacade = facade;
        frmInventario.inicioSucursal();
        Mockito.verify(facade).findAll();
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmInventario frm = Mockito.spy(frmInventario);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmInventario frm = Mockito.spy(frmInventario);
        Assert.assertEquals(frm.registroNew(),new Inventario());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmInventario frm = Mockito.spy(frmInventario);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }
    
    @Test
    public void testGetListaProducto(){
        System.out.println("testGetListaProducto");
        FrmInventario frm = Mockito.mock(FrmInventario.class);
        List<Producto> lista = Mockito.mock(List.class);
        Mockito.when(frm.getListaProducto()).thenReturn(lista);
        Assert.assertEquals(frmInventario.getListaProducto(),listProducto);
    }
    
    @Test
    public void testGetListaSucursal(){
        System.out.println("testGetListaSucursal");
        FrmInventario frm = Mockito.mock(FrmInventario.class);
        List<Sucursal> lista = Mockito.mock(List.class);
        Mockito.when(frm.getListaSucursal()).thenReturn(lista);
        Assert.assertEquals(frmInventario.getListaSucursal(),listSucursal);
    }
    
}
