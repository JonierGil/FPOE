/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ogica;

import co.edu.uvpalmira.fpoe.jpalib.NonexistentEntityException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import modelo.Asignatura;

/**
 *
 * @author Sala Sistemas
 */
public interface ILogica{
    public void crearAsignatua(Asignatura asignatura) throws SQLIntegrityConstraintViolationException, Exception;
    public void modificarAsignatura(Asignatura asignatura) throws NonexistentEntityException, Exception ;
    public Asignatura buscarAsignatura(String codigo);
    public List<Asignatura> buscarAsignaturas();
}
