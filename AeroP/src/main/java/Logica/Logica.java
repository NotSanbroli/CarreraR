/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;


import Utilitarios.Avion;
import Utilitarios.AvionB;
import Utilitarios.AvionG;
import Utilitarios.AvionV;
import Utilitarios.Persona;

import Utilitarios.Silla;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Familia
 */
public class Logica {

    Map<Integer,Persona> personas;
    public static BufferedReader entrada=new BufferedReader(new InputStreamReader(System.in));
    AvionV aVip=new AvionV("AvionVip");
    AvionG aGr=new AvionG("AvionGrande");
    AvionB APq=new AvionB("AvionPequeño");
    
    int i=0;
    String puesto="              ";


    public Logica() throws IOException {
        personas=new HashMap<Integer,Persona>();
        menu();
                
    }  
    /**
     * @author Familia
     * 
     * 
     */
    public void menu() {
    System.out.print("Que avion a comprar?\n"+"Avion Vip 1.\n"
            + "Avion Grande 2.\n"
            + "Avion Pequeño 3.\n"
            +"Despegar avion 4.\n"
            + "Agregar cliente 5.\n"
            + "Salir 0.\n");
    Integer id=0;
    String silla="";
    try{
    int opcion=Integer.parseInt(entrada.readLine());
    switch(opcion){
        case 1:
            if(!aVip.isDespegado()==true){
                imprimirAvionVip();
                id=leerUsuario();
                silla=leerSilla();
                comprarSillaVip(silla, id);
            }else{
                System.out.println("El avion ya despego");
            }
            menu();
            break;
        case 2:
            if(!aGr.isDespegado()==true){
                imprimirAvionG();
                id=leerUsuario();
                silla=leerSilla();
                comprarSillaG(silla, id);
            }else{
                System.out.println("El avion ya despego");
            }
            menu();
            break;
        case 3:
            if(!APq.isDespegado()==true){
                imprimirAvionB();
                id=leerUsuario();
                silla=leerSilla();
                comprarSillaB(silla, id);
            }else{
                System.out.println("El avion ya despego");
            }
            menu();
            break;
        case 4:
           menuDespegados();
            menu();
            break;
        case 5:
            agregarPasajeros();
            menu();
            break;
        case 0:
            System.out.println("terminando programa...");
            System.exit(0);
             break;
        default:
            System.out.println("Opcion incorrecta");
            menu();
    }
    }catch(Exception ex){
            System.out.println("Escriba un numero");
            menu();
            }
    
    /**
     * @author Familia
     * 
     * 
     */
    }
    public String leerSilla(){
        String silla="";
        System.out.println("Digite la silla \n");
        try{
           silla=entrada.readLine().toUpperCase();
         }catch(Exception ex){
             System.out.println(ex);
         }
        return silla;
    }
    /**
     * @author Familia
     *
     * 
     */
    
    public Integer leerUsuario(){
        Integer cedula=0;
        System.out.println("Digite el ID\n");
        try{
           cedula=Integer.parseInt(entrada.readLine());
         }catch(Exception ex){
             System.out.println(ex);
         }
        return cedula;
    }
    /**
     * @author Famila
     * 
     * 
     */
    
    public void comprarSillaB(String code,Integer id){
        if(!personas.containsKey(id)){
            System.out.println("No existe el ID: "+id);
            menu();
        }
        Persona comprador = personas.get(id);
        if(!APq.getSillas().containsKey(code)){
            System.out.println("silla no encotrada");
        }if(APq.getSillas().containsKey(code)){
            if(!APq.getSillas().get(code).isOcupada()){
                APq.getSillas().get(code).setPersona(comprador);
                APq.getSillas().get(code).setOcupada(true);                
            }else{                
                System.out.println("Silla Ocupada");
            }
        }
    }
    /**
     * @author Failia
     * 
     * 
     */
    public void comprarSillaVip(String code,Integer id){
        if(!personas.containsKey(id)){
            System.out.println("No existe el ID: "+id);
            menu();
        }
        Persona comprador = personas.get(id);
        if(!aVip.getSillas().containsKey(code)){
            System.out.println("silla no encotrada");
        }
        if(aVip.getSillas().containsKey(code)){
            if(!aVip.getSillas().get(code).isOcupada()){
                aVip.getSillas().get(code).setPersona(comprador);
                aVip.getSillas().get(code).setOcupada(true);                
            }else{                
                System.out.println("Silla Ocupada");
            }
        }
    }
    /**
     * @author Famila
     * 
     * 
     */
    public void comprarSillaG(String code,Integer id){
        if(!personas.containsKey(id)){
            System.out.println("No existe el ID: "+id);
            menu();
        }
        Persona comprador = personas.get(id);
        if(!aGr.getSillas().containsKey(code)){
            System.out.println("silla no encotrada");
        }if(aGr.getSillas().containsKey(code)){
            if(!aGr.getSillas().get(code).isOcupada()){
                aGr.getSillas().get(code).setPersona(comprador);
                aGr.getSillas().get(code).setOcupada(true);                
            }else{                
                System.out.println("Silla Ocupada");
            }
        }
    }
    /**
     * @author Familia
     *
     * 
     */
    public void agregarPasajeros(){
        System.out.println("agregar el Pasajeros");
        String nombre="";
        int cedula=0;
        String fecha="";
        
        System.out.println("digite el nombre");
        try {
            nombre = (entrada.readLine());
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Digite el ID");
        try {
            cedula = (Integer.parseInt(entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("digite fecha de nacimiento");
        try {
            fecha = ((entrada.readLine()));
        } catch (IOException ex) {
            Logger.getLogger(Logica.class.getName()).log(Level.SEVERE, null, ex);
        }
        SimpleDateFormat fecha1=new SimpleDateFormat(fecha);
        Persona nuevo=new Persona(nombre,cedula,fecha1);
        personas.put(cedula, nuevo);
    }

    private void imprimirAvionG() {
        
        Map<String, Silla> mapaO = new TreeMap<String, Silla>(aGr.getSillas());
        Set<String> llaves = mapaO.keySet();
        System.out.println("                   /\\");
        System.out.println("                  /  \\");
        System.out.println("                 /    \\");
        System.out.println("                /      \\");
        System.out.println("               /        \\");
        System.out.println("              /          \\");
        System.out.println("             /            \\");
        System.out.println("            /______________\\");
        System.out.println("            |               |");
        
        for(String llav : llaves){
            if(mapaO.get(llav).isOcupada()){
                mapaO.get(llav).setNombre("//");
            }
        }
        
        for(String llav : llaves){
            if(mapaO.get(llav).isVip()){
                puesto+=mapaO.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                    puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
        
        System.out.println(" ___________|               |___________");
        System.out.println("/           |               |           \\");
        System.out.println("\\___________|               |___________/");
        for(String llav : llaves){
            if(mapaO.get(llav).isVip()){
                
            }
            else{
                puesto+=mapaO.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                    puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
        System.out.println("\n            |               |");
        System.out.println("            |               |");
    }

    private void imprimirAvionVip() {
         Map<String, Silla> mapaO = new TreeMap<String, Silla>(aVip.getSillas());
        Set<String> llaves = mapaO.keySet();
        System.out.println("                   /\\");
        System.out.println("                  /  \\");
        System.out.println("                 /    \\");
        System.out.println("                /      \\");
        System.out.println("               /        \\");
        System.out.println("              /          \\");
        System.out.println("             /            \\");
        System.out.println("            /______________\\");
        System.out.println("            |               |");
        System.out.println(" ___________|               |___________");
        System.out.println("/           |               |           \\");
        System.out.println("\\___________|               |___________/");
        for(String llav : llaves){
            if(mapaO.get(llav).isOcupada()){
                mapaO.get(llav).setNombre("//");
            }
        }
        
        for(String llav : llaves){
            if(mapaO.get(llav).isVip()){
                puesto+=mapaO.get(llav).getNombre()+"       ";
                System.out.print(puesto);
                i++;
                if(i==1){
                    puesto=" ";
                }
                if(i>1){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
           
        }
        System.out.println("\n            |               |");
        System.out.println("            |               |");
    }

    private void imprimirAvionB() {
      Map<String, Silla> mapaO = new TreeMap<String, Silla>(APq.getSillas());
        Set<String> llaves = mapaO.keySet();
        System.out.println("                   /\\");
        System.out.println("                  /  \\");
        System.out.println("                 /    \\");
        System.out.println("                /      \\");
        System.out.println("               /        \\");
        System.out.println("              /          \\");
        System.out.println("             /            \\");
        System.out.println("            /______________\\");
        System.out.println("            |               |");
        System.out.println(" ___________|               |___________");
        System.out.println("/           |               |           \\");
        System.out.println("\\___________|               |___________/");
        for(String llav : llaves){
            if(mapaO.get(llav).isOcupada()){
                mapaO.get(llav).setNombre("//");
            }
        }
        for(String llav : llaves){
            if(mapaO.get(llav).isVip()){
                
            }
            else{
                puesto+=mapaO.get(llav).getNombre();
                System.out.print(puesto);
                i++;
                puesto="";
                if(i==3){
                    puesto=" ";
                }
                if(i>5){
                    System.out.println();
                    i=0;
                    puesto="              ";
                }
            }
        }
         System.out.println("\n            |               |");
        System.out.println("            |               |");
    }

    private void menuDespegados() {
        System.out.print("Que avion a despegar?\n"+"Avion Vip 1.\n"
            + "Avion Grande 2.\n"
            + "Avion Pequeño 3.\n"
            + "Salir 0.\n");
        try{
    int opcion=Integer.parseInt(entrada.readLine());
    switch(opcion){
       case 1:
           if(aVip.isDespegado()){
           System.out.println("Este avion ya despego");
           }else{
            System.out.println("Ganancias vip\n"+aVip.calcularVuelo()+"\n");
            aVip.setDespegado(true);
            menu();
           }
            break;
        case 2:
            if(aGr.isDespegado()){
             System.out.println("Este avion ya despego");
            } else{
            System.out.println("Ganancias Grande\n"+aGr.calcularVuelo()+"\n");
            aGr.setDespegado(true);
            menu();
            }
            break;
        case 3:
            if(APq.isDespegado()){
             System.out.println("Este avion ya despego");
            }else{
            System.out.println("Ganancias Pequeño\n"+APq.calcularVuelo()+"\n");
            APq.setDespegado(true);
            menu();
            }
            break;
        case 0:
            menu();
            break;
        default:
             System.out.println("Opcion incorrecta");
             menuDespegados();
             break;
    }
     }
    catch(Exception ex){
            System.out.println("Escriba un numero");
            menuDespegados();
            }
    }
}
