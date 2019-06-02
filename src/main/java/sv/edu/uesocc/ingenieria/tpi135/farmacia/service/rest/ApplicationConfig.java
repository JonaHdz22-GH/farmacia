/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author luis
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.DetalleVentaResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.FormaPagoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.ProductoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.ProveedorResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.SucursalResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.TipoDescuentoResources.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi135.farmacia.service.rest.UsuarioResources.class);
    }
    
}
