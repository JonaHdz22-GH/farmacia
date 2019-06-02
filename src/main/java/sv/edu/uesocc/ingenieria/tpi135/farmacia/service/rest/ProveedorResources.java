package sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.AbstractFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.ProveedorFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Proveedor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author luis
 */
@Path("proveedor")
@RequestScoped
public class ProveedorResources extends AbstractResources<Proveedor> {

    @Inject
    protected ProveedorFacade proveedorFacade;

    @Override
    protected AbstractFacade<Proveedor> facade() {
        return proveedorFacade;
    }

    @Override
    protected Proveedor nuevo() {
        return new Proveedor();
    }
}
