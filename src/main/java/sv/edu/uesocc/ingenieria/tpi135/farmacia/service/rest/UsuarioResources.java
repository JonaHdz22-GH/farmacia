/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    
    @GET
    @Path("like")
    @Produces({MediaType.APPLICATION_JSON})
    public Response findByLike(@QueryParam("filtro") @DefaultValue("") String filtro){
        if (!filtro.isEmpty()) {
            try {
                List<Usuario> lista = usuarioFacade.findByLike(filtro);
                if (lista != null) {
                    return Response.ok(lista).header("Access-Control-Allow-Origin","*").header("Total-Registros", facade().count()).build();
                }
            } catch (Exception ex) {
                Logger.getLogger(getClass().getName()).log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", Collections.EMPTY_LIST).build();
    }

}
