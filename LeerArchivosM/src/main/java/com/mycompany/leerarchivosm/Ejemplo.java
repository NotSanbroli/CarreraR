/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.leerarchivosm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.HashMap;
import com.mycompany.leerarchivosm.Persona;
import com.mycompany.leerarchivosm.Reporte;

/**
 *
 * @author fetec
 */
public class Ejemplo implements Serializable{
    
    public BufferedReader datos=new BufferedReader(new InputStreamReader (System.in));
    private HashMap<Integer,Persona> personas;
    private String nombrep;
    private String apellido;
    boolean t;
    private int i;

    public Ejemplo() {
        personas= new HashMap();
        
    }
    
    public void menu(){
        try{
            leerArchivo();
            int i;
            System.out.println("****************");
            System.out.println("");
            System.out.println("Crear persona 1 ");
            System.out.println("Agregar reporte 2 ");
            System.out.println("Ver reportes Personas 3 ");
            System.out.println("Eliminar reporte 4 ");
            i =Integer.parseInt(datos.readLine());
            if(i==1){
                System.out.println("Nombre Persona: ");
                nombrep=datos.readLine();
                System.out.println("Apellido Persona: ");
                apellido=datos.readLine();
                System.out.println("ID Persona: ");
                int idp=Integer.parseInt(datos.readLine());
                agregarPersona(idp,apellido,nombrep);
                guardarArchivo();
                menu();    
            }else if(i==2){
                System.out.println("ID Persona: ");
                int idp=Integer.parseInt(datos.readLine());
                System.out.println("Codigo reporte: ");
                int cr=Integer.parseInt(datos.readLine());
                System.out.println("Nombre REporte: ");
                String nr=datos.readLine();
                System.out.println("Descripcion: ");
                String de=datos.readLine();                              
                do{
                    System.out.println("Positivo P/Negativo N ");
                    String p=datos.readLine();                                 
                    if(p.equalsIgnoreCase("p")){
                        t=true;
                        i=1;
                    }else if(p.equalsIgnoreCase("n")){
                        t=false;
                        i=1;
                    }                        
                }while(i!=1);
                System.out.println("Valor: ");
                int v=Integer.parseInt(datos.readLine());
                agregarReporte(idp,cr,nr,de,t,v);
                guardarArchivo();
                menu();
            }else if(i==3){
                leerArchivo();
                System.out.println("Codigo persona");
                int ide=Integer.parseInt(datos.readLine());
                verReportes(ide);
                menu();
            }else if(i==4){                
                System.out.println("ID Persona: ");
                int idp=Integer.parseInt(datos.readLine());
                System.out.println("Codigo reporte: ");
                int cr=Integer.parseInt(datos.readLine());
                eliminarReporte(idp,cr);
                guardarArchivo();
                menu();        
            }
            else if(i<1&&i>4){
                menu();
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            menu();
        }
    }
    
    public void agregarPersona(int id, String apellido, String nombre){
        Persona p=new Persona(id,apellido,nombre);
        if(personas.containsKey(id)){
            System.out.println("Codigo ya usado previamente");
            menu();
        }else
        personas.put(id, p);            
    }
    public void eliminarReporte(int idp, int codigo){
        if(personas.containsKey(idp)){
            if(personas.get(idp).getReporte().containsKey(codigo)){
                System.out.println("Elimino");
                personas.get(idp).getReporte().remove(codigo);                
            }else
            System.out.println("Reporte no existente en esta persona");
        }else
            System.out.println("La persona no esta en la base");
    }
    public void agregarReporte(int id,int codigo, String nombre, String descripcion, boolean tipo, int valor){
    Reporte r=new Reporte(codigo,nombre,descripcion,tipo,valor);
        if(personas.containsKey(id)){
            personas.get(id).getReporte().put(codigo, r);            
        }else{
            System.out.println("No se encuentra la persona");
        }
    }
    
    public void verReportes(int ide){
        if(personas.containsKey(ide)){
            if(personas.get(ide).reporte.isEmpty()){
                System.out.println("La persona no tiene reportes");
            }else{                
                System.out.print("Reportes de: ");
                System.out.println(personas.get(ide).getNombre());
                System.out.println("Codigo Reprote:Nombre Rreporte: Descripcion: Tipo   : valor");
                int j=1;
                for (Reporte r : personas.get(ide).getReporte().values()) {
                    System.out.print(j+". ");
                    System.out.print(" "+r.getCodigo()+"       ");
                    System.out.print(" "+r.getNombre()+"     ");
                    System.out.print(" "+r.getDescripcion()+"   ");
                    if(r.isTipo()){
                        System.out.print("Positivo");
                    }else
                        System.out.print("Negativo");
                    System.out.println(r.getValor());
                    j++;
                }
            }                    
        }else
            System.out.println("La persona no existe");
    }
    
    public void leerArchivo() throws FileNotFoundException, IOException{
        
        File f;
        f=new File("src/main/java/prueba.txt");
        ObjectInputStream entrada=new ObjectInputStream(new FileInputStream(f));
        try{            
            personas=(HashMap)entrada.readObject();
        }catch(Exception ex){
            System.out.println("Error al leer el archivo");
            System.err.println(ex.getMessage());
        }finally{
            entrada.close();
        }
        
    }
    public void guardarArchivo() throws FileNotFoundException, IOException{
        File f;
        f=new File("src/main/java/prueba.txt");
        ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream(f));        
        try{            
            salida.writeObject(personas);
        }catch(Exception ex){
            System.out.println("Error al Guardar el archivo");
            ex.getMessage();
        }finally{
            salida.close();
        }
    }
    
}
