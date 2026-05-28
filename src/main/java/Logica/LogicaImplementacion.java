/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Asignatura;
import persistence.AsignaturaDAO;

/**
 *
 * @author Sala Sistemas
 */
@ApplicationScoped
public class LogicaImplementacion implements ILogica{
    
    @PersistenceUnit(name = "ProjectP")
    private EntityManagerFactory emf;
    
    private AsignaturaDAO asignaturaDAO;
    
    public LogicaImplementacion(){
        
    }
    
    @PostConstruct
    public void init(){
        this.asignaturaDAO = new AsignaturaDAO(this.emf);
    }
    
    @Override
    public void crearAsignatua(Asignatura asignatura) throws SQLIntegrityConstraintViolationException, Exception{
        this.asignaturaDAO.create(asignatura);
    }

    @Override
    public void modificarAsignatura(Asignatura asignatura) throws NonexistentEntityException, Exception {
        this.asignaturaDAO.edit(asignatura);
    }

    @Override
    public Asignatura buscarAsignatura(String codigo) {
        return this.asignaturaDAO.buscarPorCodigo(codigo);
    }

    @Override
    public List<Asignatura> buscarAsignaturas() {
        return this.asignaturaDAO.findEntities();
    }
    
    
    
    
}
