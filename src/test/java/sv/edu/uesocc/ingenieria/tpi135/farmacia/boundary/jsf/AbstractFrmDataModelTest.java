package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel.EstadosCRUD;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ContactoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;

/**
 *
 * @author jonahdz
 * @param <T>
 */
public abstract class AbstractFrmDataModelTest<T> {
    
    protected T registro;
    protected abstract AbstractFacade<T> getFacade();
    protected FrmContacto frm = new FrmContacto();
    protected Map<String,Object> filters = new HashMap<>();
    protected List<Contacto> lista = new ArrayList<>();
    
    @Mock
    private EntityManager entityManager;
    
    public AbstractFrmDataModelTest(T entity) {
        this.registro = entity;
    }
    
    @Test
    public void testLoadDatos(){
        System.out.println("testLoadDatos");
        FrmContacto frmc = Mockito.spy(frm);
        ContactoFacade fc = Mockito.mock(ContactoFacade.class);
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        Map<String,Object> filtro = Mockito.spy(filters);
        Assert.assertEquals(frmc.loadDatos(1,10,"null", SortOrder.UNSORTED, filters),new ArrayList<>());
        Mockito.when(frmc.getFacade()).thenReturn(fc);
        List<Contacto> list = Mockito.spy(lista);
        frmc.setLazymodel(lazy);
        Mockito.when(fc.findRange(1,100)).thenReturn(new ArrayList<>());
        Assert.assertEquals(frmc.loadDatos(1,100,"String",SortOrder.UNSORTED,filtro),lista);
        boolean aser = false;
        try{
            Mockito.when(fc.findRange(1,20)).thenThrow(Exception.class);
            frmc.loadDatos(1,20,"ex", SortOrder.UNSORTED, filters);
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
    }
    
    @Test
    public void testGuardar(){
        System.out.println("testGuardar");
        FrmContacto frmc = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Contacto reg = Mockito.mock(Contacto.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmc.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
        frmc.guardar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmc.setRegistro(reg);
        frmc.guardar();
        Mockito.verify(fac).create(reg);
        Mockito.when(frmc.getFacade()).thenReturn(null);
        frmc.guardar();
    }
    
    @Test
    public void testEditar(){
        System.out.println("testEditar");
        frm.editar();
        FrmContacto frmc = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Contacto reg = Mockito.mock(Contacto.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmc.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
            frmc.setRegistro(null);
            frmc.editar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmc.setRegistro(reg);
        frmc.editar();
        Mockito.verify(fac).edit(reg);
        Mockito.when(frmc.getFacade()).thenReturn(null);
        frmc.editar();
    }
    
    @Test
    public void testEliminar(){
        System.out.println("testEliminar");
        FrmContacto frmc = Mockito.spy(frm);
        AbstractFacade fac = Mockito.spy(getFacade());
        Contacto reg = Mockito.mock(Contacto.class);
        EntityManager emm = Mockito.mock(EntityManager.class);
        Mockito.when(frmc.getFacade()).thenReturn(fac);
        Mockito.when(fac.getEntityManager()).thenReturn(emm);
        boolean aser=false;
        try{
        frmc.eliminar();
        }catch(Exception ex){
            aser=true;
        }
        Assert.assertTrue(aser);
        frmc.setRegistro(reg);
        frmc.eliminar();
        Mockito.verify(fac).remove(reg);
        Mockito.when(frmc.getFacade()).thenReturn(null);
        frmc.eliminar();
    }
    
    @Test
    public void testNuevoEstado(){
        System.out.println("testNuevoEstado");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.nuevoEstado();
        Mockito.verify(frmc).nuevoEstado();
    }
    
    @Test
    public void testGetEstado(){
        System.out.println("testGetEstado");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.getEstado();
        Mockito.verify(frmc).getEstado();
    }
    
    @Test
    public void testCambiarSeleccion(){
        System.out.println("testCambiarSeleccion");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.cambiarSeleccion();
        Mockito.verify(frmc).cambiarSeleccion();
    }
    
    @Test
    public void testBtnCancelar(){
        System.out.println("testBtnCancelar");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.btnCancelar();
        Mockito.verify(frmc).btnCancelar();
    }
    
    @Test
    public void testSetLazyModel(){
        System.out.println("testSetLazyModel");
        FrmContacto frmc = Mockito.spy(frm);
        LazyDataModel lazy = Mockito.mock(LazyDataModel.class);
        frmc.setLazymodel(lazy);
        Mockito.verify(frmc).setLazymodel(lazy);
    }
    
    @Test
    public void testGetRegistro(){
        System.out.println("testGetRegistro");
        FrmContacto frmc = Mockito.spy(frm);
        Mockito.when(frmc.getRegistro()).thenReturn(new Contacto());
        Assert.assertEquals(frmc.getRegistro(),new Contacto());
    }
    
    @Test
    public void testIsSeleccion(){
        System.out.println("testGeneral");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.isSeleccion();
        Mockito.verify(frmc).isSeleccion();
    }
    
    @Test
    public void testSetSeleccion(){
        System.out.println("testSetSeleccion");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.setSeleccion(true);
        Mockito.verify(frmc).setSeleccion(true);
    }
    
    @Test
    public void testIsBtnAgregar(){
        System.out.println("testIsBtnAgregar");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.isBotonAgregar();
        Mockito.verify(frmc).isBotonAgregar();
    }
    
    @Test
    public void testSetBtnAgregar(){
        System.out.println("testSetBtnAgregar");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.setBotonAgregar(true);
        Mockito.verify(frmc).setBotonAgregar(true);
    }
    
    @Test
    public void testIsBotones(){
        System.out.println("testIsBotones");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.isBotones();
        Mockito.verify(frmc).isBotones();
    }
    
    @Test
    public void testSetBotones(){
        System.out.println("testSetBotones");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.setBotones(true);
        Mockito.verify(frmc).setBotones(true);
    }
    
    @Test
    public void testGetStdCrud(){
        System.out.println("testGetStdCrud");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.getStdCrud();
        Mockito.verify(frmc).getStdCrud();
    }
    
    @Test
    public void testSetStdCrud(){
        System.out.println("testSetStdCrud");
        FrmContacto frmc = Mockito.spy(frm);
        frmc.setStdCrud(EstadosCRUD.ADD);
        Mockito.verify(frmc).setStdCrud(EstadosCRUD.ADD);
    }
    
}
