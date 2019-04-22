package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;


import org.junit.Test;
import org.mockito.Mockito;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;

/**
 *
 * @author jonahdz
 * @param <T>
 */
public abstract class AbstractFrmDataModelTest<T> {
    
    protected T registro;
    protected abstract AbstractFacade<T> getFacade();
    protected FrmContacto frm = new FrmContacto();
    
    public AbstractFrmDataModelTest(T entity) {
        this.registro = entity;
    }
    
    @Test
    public void testGuardar(){
        System.out.println("testGuardar");
        frm.guardar();
    }
    
    @Test
    public void testEditar(){
        System.out.println("testEditar");
        frm.editar();
    }
    
    @Test
    public void testEliminar(){
        System.out.println("testEliminar");
        frm.eliminar();
    }
    
}
