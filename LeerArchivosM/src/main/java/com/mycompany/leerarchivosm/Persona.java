/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leerarchivosm;

import com.mycompany.leerarchivosm.Reporte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author fetec
 */
public class Persona implements Serializable{
    
    private String nombre;
    private String apellido;
    private int id;
    
    HashMap<Integer,Reporte>reporte;

    public Persona(int id, String apellido, String nombre) {        
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        reporte=new HashMap();
    }
    
    /*@Override
    public String toString(){
        return nombre+","+apellido+","+id;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HashMap<Integer, Reporte> getReporte() {
        return reporte;
    }

    public void setReporte(HashMap<Integer, Reporte> reporte) {
        this.reporte = reporte;
    }
    
}
