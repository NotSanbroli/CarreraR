/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Utilitarios.*;

/**
 *
 * @author Familia
 */
public class Core {

    Equipo eq1 = new Equipo("A", 0, 100);
    Equipo eq2 = new Equipo("V", 0, 100);
    Equipo eq3 = new Equipo("R", 0, 100);

    Atleta at1 = new Atleta(eq1, 0, 33);
    Atleta at2 = new Atleta(eq1, 33, 66);
    Atleta at3 = new Atleta(eq1, 66, 100);
    Atleta at4 = new Atleta(eq2, 0, 33);
    Atleta at5 = new Atleta(eq2, 33, 66);
    Atleta at6 = new Atleta(eq2, 66, 100);
    Atleta at7 = new Atleta(eq3, 0, 33);
    Atleta at8 = new Atleta(eq3, 33, 66);
    Atleta at9 = new Atleta(eq3, 66, 100);

    public void core(){
        at1.start ();

        at4.start ();

        at7.start ();

        at2.start ();

        at5.start ();

        at8.start ();

        at3.start ();

        at6.start ();

        at9.start ();
    }
}
