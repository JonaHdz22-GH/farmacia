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
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.FormaPagoFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.FormaPago;

/**
 *
 * @author luis
 */
@Path("formapago")
@RequestScoped
public class FormaPagoResources extends AbstractResources<FormaPago> {

    @Inject
    protected FormaPagoFacade formaPagoFacade;

    @Override
    protected AbstractFacade<FormaPago> facade() {
        return formaPagoFacade;
    }

    @Override
    protected FormaPago nuevo() {
        return new FormaPago();
    }
}
