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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.SucursalFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Sucursal;

/**
 *
 * @author luis
 */
@Path("sucursal")
@RequestScoped
public class SucursalResources extends AbstractResources<Sucursal> {

    @Inject
    protected SucursalFacade sucursalFacade;

    @Override
    protected AbstractFacade<Sucursal> facade() {
        return sucursalFacade;
    }

    @Override
    protected Sucursal nuevo() {
        return new Sucursal();
    }

}
