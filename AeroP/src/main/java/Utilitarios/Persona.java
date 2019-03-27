/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Familia
 */
public class Persona {
    private String nombre;
    private Integer id;
    private SimpleDateFormat  fechaN;

    public Persona(String nombre, int cedula, SimpleDateFormat  fechaNacimiento) {
        this.nombre = nombre;
        this.id = cedula;
        this.fechaN = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return id;
    }

}
