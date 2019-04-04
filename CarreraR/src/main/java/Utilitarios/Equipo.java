/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

/**
 *
 * @author Familia
 */
public class Equipo extends Thread {

    private String nombre;
    private int inicio;
    private int fin;
    private int posicionAt1;
    private int posicionAt2;
    private int posicionAt3;

    public Equipo(String nombre, int inicio, int fin) {
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        this.posicionAt1 = 0;
        this.posicionAt2 = 33;
        this.posicionAt3 = 66;
    }

    public synchronized String imprimir() {
        String tramo = "Equipo: "+nombre+" ";
        for (int i = inicio; i <= fin; i++) {
            if (i == posicionAt1) {
                tramo += "1";
            } else if (i == posicionAt2) {
                tramo += "2";
            } else if (i == posicionAt3) {
                tramo += "3";
            } else {
                tramo += "_";
            }
        }

        return tramo;
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getPosicionAt1() {
        return posicionAt1;
    }

    public void setPosicionAt1(int posicionAt1) {
        this.posicionAt1 = posicionAt1;
    }

    public int getPosicionAt2() {
        return posicionAt2;
    }

    public void setPosicionAt2(int posicionAt2) {
        this.posicionAt2 = posicionAt2;
    }

    public int getPosicionAt3() {
        return posicionAt3;
    }

    public void setPosicionAt3(int posicionAt3) {
        this.posicionAt3 = posicionAt3;
    }
    
    

}
