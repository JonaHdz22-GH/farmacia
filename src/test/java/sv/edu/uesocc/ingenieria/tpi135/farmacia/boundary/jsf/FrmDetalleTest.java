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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Detalle;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleProducto;

/**
 *
 * @author luis
 */
@RunWith(MockitoJUnitRunner.class)
public class FrmDetalleTest {
    
    protected Detalle registro;
    protected List<Detalle> listDetalle;
    protected List<DetalleProducto> listDetalleProducto;
    
    @InjectMocks
    FrmDetalle frmDetalle = new FrmDetalle();

    @Before
    public void setUp() {
        this.listDetalle = new ArrayList<>();
        listDetalle.add(new Detalle(1));
        registro = new Detalle();
        registro.setIdDetalleProducto(new DetalleProducto(1));
    }
    
    @Test
    public void testClavePorDatos(){
        System.out.println("testClavePorDatos");
        Detalle entity = Mockito.mock(Detalle.class);
        Object exp = 1;
        Mockito.when(entity.getIdDetalle()).thenReturn(1);
        Assert.assertEquals(frmDetalle.clavePorDatos(new Detalle(1)),exp);
        Assert.assertEquals(frmDetalle.clavePorDatos(null),null);
    }
    
   @Test
    public void testDatosPorClave(){
        System.out.println("testDatosPorClave");
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Mockito.when(lazy.getWrappedData()).thenReturn(listDetalle);
        frmDetalle.lazymodel=lazy;
        Assert.assertEquals(frmDetalle.datosPorClave("1"),new Detalle(1));
        boolean aser=false;
        try{
            frmDetalle.datosPorClave("null");
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        Assert.assertNull(frmDetalle.datosPorClave(null));
    }
    
    @Test
    public void testGetIdDetalleProductoSeleccionado() {
        System.out.println("testGetIdDetalleProductoSeleccionado");
        Detalle detalle = Mockito.mock(Detalle.class);
        DetalleProducto detallep = Mockito.mock(DetalleProducto.class);
        Mockito.when(detalle.getIdDetalleProducto()).thenReturn(detallep);
        Mockito.when(detallep.getIdDetalleProducto()).thenReturn(1);
        frmDetalle.setRegistro(registro);
        Assert.assertEquals(frmDetalle.getIdDetalleProductoSeleccionado(),new Integer(1));
        registro.setIdDetalleProducto(null);
        Assert.assertNull(frmDetalle.getIdDetalleProductoSeleccionado());
    }
    
    @Test
    public void testSetIdDetalleProductoSeleccionado(){
        System.out.println("testSetIdProveedorProductoSeleccionado");
        FrmDetalle frm = Mockito.spy(frmDetalle);
        Detalle reg = Mockito.mock(Detalle.class);
        List<DetalleProducto> list = Mockito.mock(List.class);
        listDetalleProducto = new ArrayList<>();
        listDetalleProducto.add(new DetalleProducto(1));
        frmDetalle.setRegistro(registro);
        frmDetalle.setListaDetalleProducto(listDetalleProducto);
        frmDetalle.registro = reg;
        frmDetalle.listaDetalleProducto = listDetalleProducto;
        frmDetalle.setIdDetalleProductoSeleccionado(1);
        Mockito.verify(reg).setIdDetalleProducto(new DetalleProducto(1));
        Mockito.when(list.stream()).thenThrow(Exception.class);
        boolean aser=false;
        try{
            frmDetalle.setIdDetalleProductoSeleccionado(2);
        }catch(Exception ex){
            aser=true; 
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testInicioLista(){
        System.out.println("testInicioLista");
        DetalleProductoFacade facade = Mockito.mock(DetalleProductoFacade.class);
        frmDetalle.detalleProductoFacade = facade;
        frmDetalle.inicioLista();
        Mockito.verify(facade).findAll();
    }
    
    @Test
    public void testGetFacade(){
        System.out.println("testGetFacade");
        FrmDetalle frm = Mockito.spy(frmDetalle);
        frm.getFacade();
        Mockito.verify(frm).getFacade();
    }
    
    @Test
    public void testRegistroNew(){
        System.out.println("testRegistroNew");
        FrmDetalle frm = Mockito.spy(frmDetalle);
        Assert.assertEquals(frm.registroNew(),new Detalle());
    }
    
    @Test
    public void testInicializar(){
        System.out.println("testInicializar");
        FrmDetalle frm = Mockito.spy(frmDetalle);
        frm.inicializar();
        Mockito.verify(frm).inicializar();
    }
    
    @Test
    public void testGetListaDetalleProducto(){
        System.out.println("testGetListaDetalleProducto");
        FrmDetalle frm = Mockito.mock(FrmDetalle.class);
        List<DetalleProducto> lista = Mockito.mock(List.class);
        Mockito.when(frm.getListaDetalleProducto()).thenReturn(lista);
        Assert.assertEquals(frmDetalle.getListaDetalleProducto(),listDetalleProducto);
    }
}
