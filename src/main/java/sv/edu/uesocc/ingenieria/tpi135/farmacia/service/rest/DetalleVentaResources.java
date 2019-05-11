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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.DetalleVentaFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.DetalleVenta;

/**
 *
 * @author luis
 */
@Path("detalleventa")
@RequestScoped
public class DetalleVentaResources extends AbstractResources<DetalleVenta> {

    @Inject
    protected DetalleVentaFacade detalleVentaFacade;

    @Override
    protected AbstractFacade<DetalleVenta> facade() {
        return detalleVentaFacade;
    }

    @Override
    protected DetalleVenta nuevo() {
        return new DetalleVenta();
    }
}
