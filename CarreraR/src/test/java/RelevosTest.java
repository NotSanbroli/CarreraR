/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Utilitarios.Equipo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static Utilitarios.Random.random;

/**
 *
 * @author Familia
 */
public class RelevosTest {
    public RelevosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
    public void randomTest(){
        int j = random();
        if(j==0){
         assertEquals(0,j);
        }
        if(j==1){
         assertEquals(1,j);
        }
        if(j==2){
         assertEquals(2,j);
        }
        if(j==3){
         assertEquals(3,j);
        }
    
    }
    @Test
    public void EquiposTest(){
    Equipo eq1 = new Equipo("A", 0, 100);
        Integer posicionA = eq1.getPosicionAt1();
        posicionA += eq1.getPosicionAt2();
        posicionA += eq1.getPosicionAt3();
        String posicionAS=posicionA.toString();
        assertEquals("99",posicionAS);
        
    }
    @Test
    public void ImprimirTest(){
     Equipo eq1 = new Equipo("A", 0, 100);
        String imprimir = eq1.imprimir();
        assertEquals("Equipo: A 1________________________________2________________________________3__________________________________",imprimir);
        
    }
}
