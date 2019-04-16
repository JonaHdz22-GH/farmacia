///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;
//
//import javax.ejb.EJB;
//import javax.inject.Inject;
//import org.junit.Assert;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.mockito.runners.MockitoJUnitRunner;
//import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.AbstractFrmDataModel.EstadosCRUD;
//import sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf.backing.FrmContacto;
//import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
//import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Contacto;
//
///**
// *
// * @author jonahdz
// */
//@RunWith(MockitoJUnitRunner.class)
//public class AbstractFrmDataModelTest {
//    
//    @EJB
//    FrmContacto frmContacto = new FrmContacto();
//    
//    @Test
//    public void testGuargar(){
//        System.out.println("testGuardar");
//        AbstractFacade<Contacto> facade = Mockito.mock(AbstractFacade.class);
//        facade.create(new Contacto(1));
//        Mockito.verify(facade).create(new Contacto(1));
//    }
//    
//    @Test
//    public void testGetEstado(){
//        System.out.println("testGetEstado");
//    }
//    
//    @Test
//    public void testNuevoEstado(){
//        System.out.println("testNuevoEstado");
//        
//    }
//    
//    
//}
