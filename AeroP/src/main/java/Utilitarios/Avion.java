/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Familia
 */
public abstract class Avion {
    
    private String nombre;
    HashMap<String,Silla> sillas;
    private boolean despegado=false;

    public Avion(String nombre) {
        this.nombre = nombre;
        sillas=new HashMap();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public HashMap<String, Silla> getSillas() {
        return sillas;
    }

    public void setSillas(HashMap<String, Silla> sillas) {
        this.sillas = sillas;
    }

    public boolean isDespegado() {
        return despegado;
    }

    public void setDespegado(boolean despegado) {
        this.despegado = despegado;
    }
    /**
     * @author Victor Pardo
Esta funcion calcula cuando pasa  a estado despegado el valor total de silla vendidas
     * 
     */
    public double calcularVuelo(){
        double total=0;
        for (Map.Entry<String, Silla> entry : sillas.entrySet()) {
            String key = entry.getKey();
            Silla value = entry.getValue();
            if(value.isOcupada()==true){
                total+=value.getPrecio();
            }
            
        }
        return total;
    }
}
