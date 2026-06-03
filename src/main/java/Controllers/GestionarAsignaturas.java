/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import Logica.ILogica;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.Application;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIViewRoot;
import jakarta.faces.context.ExternalContext;
import jakarta.faces.context.FacesContext;
import jakarta.faces.context.ResponseStream;
import jakarta.faces.context.ResponseWriter;
import jakarta.faces.lifecycle.Lifecycle;
import jakarta.faces.render.RenderKit;
import java.io.Serializable;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Asignatura;

/**
 *
 * @author Sala Sistemas
 */
@Named
@SessionScoped
public class GestionarAsignaturas implements Serializable{
    
    //@Inject
    private ILogica iLogica;
    
    private Asignatura asignatura = new Asignatura("740014C", "FPOE", (byte)3, (byte)4);

    public Asignatura getAsignatura() {
        return asignatura;
    }
    
    public void cancelar(){
        this.asignatura = new Asignatura();
    }
    
    public void guardar(){
        try {
            this.iLogica.crearAsignatua(asignatura);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("El producto " + this.asignatura.getNombre() +
                            "De codigo " + this.asignatura.getCodigo() + "Fue Guardada"));
        } catch (SQLIntegrityConstraintViolationException ex) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error de restricciones", ex.getLocalizedMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }catch(Exception ex){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error No Identificado", ex.getLocalizedMessage()));
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        
    }
      
}
