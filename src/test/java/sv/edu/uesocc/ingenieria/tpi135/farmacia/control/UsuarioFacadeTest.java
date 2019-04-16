/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.control;

import java.util.ArrayList;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Factura;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;


/**
 *
 * @author jonahdz
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioFacadeTest {
    
    @EJB
    UsuarioFacade usr = new UsuarioFacade();
    
    @Test
    public void testEntityManager(){
        System.out.println("testEM");
        EntityManager entityManager = Mockito.mock(EntityManager.class);
        Usuario usuario1 = new Usuario();
        Usuario usuario2 = new Usuario(1);
        Usuario usuario3 = new Usuario(1,"usr","usr");
        usuario1.getIdUsuario();
        usuario1.setIdUsuario(1);
        usuario1.getNombre();
        usuario1.setNombre("usr");
        usuario1.getApellido();
        usuario1.setApellido("usr");
        usuario1.getEstado();
        usuario1.setEstado(true);
        usuario1.getObservaciones();
        usuario1.setObservaciones("nada");
        usuario1.getFacturaList();
        usuario1.setFacturaList(new ArrayList<Factura>());
        usuario1.hashCode();
        Object nue = 1;
        usuario1.equals(nue);
        usuario1.toString();
        usr.em = entityManager;
        Assert.assertEquals(entityManager,usr.getEntityManager());
    }
    
}
