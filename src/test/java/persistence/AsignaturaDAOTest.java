/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package persistence;

import com.sun.istack.logging.Logger;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
import modelo.Asignatura;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sala Sistemas
 */
public class AsignaturaDAOTest {
    private AsignaturaDAO asignaturaDAO;
    private long id;
    
    public AsignaturaDAOTest() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectPU");
        this.asignaturaDAO = new AsignaturaDAO(emf);
    }
    
    @Test
    public void testBuscarPorCodigo(){
        try{
            System.out.println("insetar");
            Asignatura asig = new Asignatura ("750014C", "FPOE", (byte)3, (byte)3);
            asignaturaDAO.create(asig);
            this.id = asig.getId();
            System.out.println(this.id);
            String codigo = asig.getCodigo();
            asig = null;
            Assert.assertNotNull(this.id);
            
            System.out.println("buscar : " + this.id);
            asig = this.asignaturaDAO.buscarPorCodigo(codigo);
            Assert.assertEquals("750014C", codigo);
        }
        catch(Exception ex){
            Logger.getLogger(Asignatura.class).log(Level.SEVERE, null, ex);
            Assert.fail();
        }
    }

    /**
     * Test of buscarPorEscuela method, of class AsignaturaDAO.
     */
    @Test
    public void testBuscarPorEscuela() {
        System.out.println("buscarPorEscuela");
        String codigoEscuela = "";
        AsignaturaDAO instance = null;
        List<Asignatura> expResult = null;
        List<Asignatura> result = instance.buscarPorEscuela(codigoEscuela);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
