/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.UsuarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;

/**
 *
 * @author luis
 */
@Path("usuario")
@RequestScoped
public class UsuarioResources extends AbstractResources<Usuario>{

    @Inject
    protected UsuarioFacade usuarioFacade;
    
   @Override
    protected AbstractFacade<Usuario> facade() {
        return usuarioFacade;
    }

    @Override
    protected Usuario nuevo() {
        return new Usuario();
    }


}
