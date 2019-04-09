/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi135.farmacia.boundary.jsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.control.UsuarioFacade;
import sv.edu.uesocc.ingenieria.tpi135.farmacia.entity.Usuario;

/**
 *
 * @author jonahdz
 */
@Named
@ViewScoped
public class FrmUsuario implements Serializable{
    
    @Inject
    private UsuarioFacade usr;
    private LazyDataModel<Usuario> lazymodel;
    private Usuario registrousr;
    private boolean seleccion = false;
    private boolean botonAgregar = true;
    private boolean botones = false;
    
    
    @PostConstruct
    private void inicio() {

        registrousr = new Usuario();

        try {
            this.lazymodel = new LazyDataModel<Usuario>() {
                
                @Override
                public Object getRowKey(Usuario object) {
                    if (object != null) {
                        return object.getIdUsuario();
                    }
                    return null;
                }
                
                @Override
                public Usuario getRowData(String rowKey) {
                    if (rowKey != null && !rowKey.isEmpty() && this.getWrappedData() != null) {
                        try {
                            Integer buscado = new Integer(rowKey);
                            for (Usuario reg : (List<Usuario>) getWrappedData()) {
                                if (reg.getIdUsuario().compareTo(buscado) == 0) {
                                    return reg;
                                }
                            }
                        } catch (Exception e) {
                            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                        }
                    }
                    return null;
                }
                
                @Override
                public List<Usuario> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
                    List<Usuario> salida = new ArrayList();
                    try {
                        if (usr != null) {
                            this.setRowCount(usr.count());
                            salida = usr.findRange(first, pageSize);
                        }
                    } catch (Exception e) {
                        Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    }
                    return salida;
                }
            };
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }
    
    public void guardar(){
        if(usr!=null){
            try{
                usr.create(registrousr);
            }catch(Exception ex){
                
            }
        }
        cancelar();
    }
    
    public void editar(){
        if(usr!=null){
            try{
                usr.edit(this.registrousr);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void eliminar(){
        if(usr!=null){
            try{
                usr.remove(this.registrousr);
            }catch(Exception ex){
            
            }
        }
        cancelar();
    }
    
    public void cambiarSeleccion(){
        this.botones = true;
        this.botonAgregar = false;
    }
    
    public void cancelar(){
        this.registrousr = new Usuario();
        this.botones = false;
        this.botonAgregar = true;
    }

    public UsuarioFacade getUsr() {
        return usr;
    }

    public void setUsr(UsuarioFacade usr) {
        this.usr = usr;
    }

    public LazyDataModel<Usuario> getLazymodel() {
        return lazymodel;
    }

    public void setLazymodel(LazyDataModel<Usuario> lazymodel) {
        this.lazymodel = lazymodel;
    }

    public Usuario getRegistrousr() {
        return registrousr;
    }

    public void setRegistrousr(Usuario registrousr) {
        this.registrousr = registrousr;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }

    public boolean isBotonAgregar() {
        return botonAgregar;
    }

    public void setBotonAgregar(boolean botonAgregar) {
        this.botonAgregar = botonAgregar;
    }

    public boolean isBotones() {
        return botones;
    }

    public void setBotones(boolean botones) {
        this.botones = botones;
    }
    
    
    

}
