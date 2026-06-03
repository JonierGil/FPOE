/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import co.edu.uvpalmira.fpoe.jpalib.AbstractEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/**
 *
 * @author Sala Sistemas
 */
@Entity
@NamedQueries({
     @NamedQuery(name="Asignatura.buscarPorCodigo",
                query="SELECT a FROM Asignatura a WHERE a.codigo = :codigo"),
    @NamedQuery(name="Asignatura.buscarPorEscuela",
                query="SELECT a FROM Asignatura a WHERE a.codigo LIKE :prefijo ORDER BY a.codigo ASC"),
})
public class Asignatura extends AbstractEntity {
    @Column(nullable = false, length = 7,unique = true)
    private String codigo;
    @Column(nullable = false, length = 150,unique = true)
    private String nombre;
    @Column(nullable = false)
    private byte creditos;
    @Column(nullable = false)
    private byte intensidad;

    public Asignatura(String codigo, String nombre, byte creditos, byte intensidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.intensidad = intensidad;
    }
    
    public Asignatura(){
        
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public byte getCreditos() {
        return creditos;
    }

    public byte getIntensidad() {
        return intensidad;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCreditos(byte creditos) {
        this.creditos = creditos;
    }

    public void setIntensidad(byte intensidad) {
        this.intensidad = intensidad;
    }
}