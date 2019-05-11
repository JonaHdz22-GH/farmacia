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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.TipoDescuentoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.TipoDescuento;

/**
 *
 * @author luis
 */
@Path("tipodescuento")
@RequestScoped
public class TipoDescuentoResources extends AbstractResources<TipoDescuento> {

    @Inject
    protected TipoDescuentoFacade tipoDescuentoFacade;

    @Override
    protected AbstractFacade<TipoDescuento> facade() {
        return tipoDescuentoFacade;
    }

    @Override
    protected TipoDescuento nuevo() {
        return new TipoDescuento();
    }

}
