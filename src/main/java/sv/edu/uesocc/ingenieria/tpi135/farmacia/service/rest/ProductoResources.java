/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProductoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Producto;

/**
 *
 * @author luis
 */
@Path("producto")
@RequestScoped
public class ProductoResources extends AbstractResources<Producto> {

    @Inject
    protected ProductoFacade productoFacade;

    @Override
    protected AbstractFacade<Producto> facade() {
        return productoFacade;
    }

    @Override
    protected Producto nuevo() {
        return new Producto();
    }
    
    
        /**
     * metodo para contar el total de registro
     *
     * @return total de registro estado OK // error NOT FOUND datos 0
     */
    @GET
    @Path("tabla")
    @Produces(MediaType.APPLICATION_JSON)
    public Response infoProdcuto() {
        if (facade() != null) {
            return Response.ok(productoFacade.infoProducto()).header("Total-Registro", facade().count()).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Error, no se pudo hacer la peticion ", 0).build();
    }

}
