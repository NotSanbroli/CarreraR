/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class Atleta extends Thread {

    Equipo equipo;
    private int posicion;
    private int fin;
    private String stA;
    private String stR;
    private String stV;
    

    public Atleta(Equipo equipo, int posicion, int fin) {
        this.equipo = equipo;
        this.posicion = posicion;
        this.fin = fin;
    }

    @Override
    public void run() {
        if (posicion == 0) {
            while (true) {
                int pActual = correr(1);
                if (pActual >= 33) {
                    equipo.setPosicionAt1(33);
                    synchronized (equipo) {
                        equipo.notifyAll();
                        posicion = 33;
                    }
                    break;
                }
            }
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (posicion == 33) {
            while (true) {
                int pActual = correr(2);
                if (pActual >= 66) {
                    equipo.setPosicionAt2(66);
                    synchronized (equipo) {
                        equipo.notify();
                    }
                    break;
                }
            }
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
        if (posicion == 66) {
            while (true) {
                int pActual = correr(3);
                if (pActual >= 100) {
                    equipo.setPosicionAt3(100);
                    System.out.println("Equipo ganador: "+equipo.getNombre());
                    System.exit(0);
                    break;
                }
            }
        } else {
            synchronized (equipo) {
                try {
                    equipo.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public int correr(int nAtleta) {
        try {
            Thread.sleep(500);            
        } catch (InterruptedException ex) {
            Logger.getLogger(Atleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        int vAvance = Random.random();
        if (nAtleta == 1) {
            equipo.setPosicionAt1(equipo.getPosicionAt1() + vAvance);
            if(equipo.imprimir().contains("A")){
                stA=equipo.imprimir();
            }else if(equipo.imprimir().contains("V")){
                stV=equipo.imprimir();
            }else if(equipo.imprimir().contains("R")){
                stR=equipo.imprimir();
            }
            if(stA!=null){
                System.out.println(stA);
            }
            if(stR!=null){
                System.out.println(stR);
            }
            if(stV!=null){
                System.out.println(stV);
            }            
            return equipo.getPosicionAt1();
        }
        if (nAtleta == 2) {
            equipo.setPosicionAt2(equipo.getPosicionAt2() + vAvance);
            if(equipo.imprimir().contains("A")){
                stA=equipo.imprimir();
            }else if(equipo.imprimir().contains("V")){
                stV=equipo.imprimir();
            }else if(equipo.imprimir().contains("R")){
                stR=equipo.imprimir();
            }
            if(stA!=null){
                System.out.println(stA);
            }
            if(stR!=null){
                System.out.println(stR);
            }
            if(stV!=null){
                System.out.println(stV);
            }
            return equipo.getPosicionAt2();
        }
        if (nAtleta == 3) {
            equipo.setPosicionAt3(equipo.getPosicionAt3() + vAvance);
            if(equipo.imprimir().contains("A")){
                stA=equipo.imprimir();
            }else if(equipo.imprimir().contains("V")){
                stV=equipo.imprimir();
            }else if(equipo.imprimir().contains("R")){
                stR=equipo.imprimir();
            }
            if(stA!=null){
                System.out.println(stA);
            }
            if(stR!=null){
                System.out.println(stR);
            }
            if(stV!=null){
                System.out.println(stV);
            }
            
            return equipo.getPosicionAt3();
        }
        return 0;
    }
}
