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
public class Random {
    
    public static int random(){
        double i=Math.random()*100;
        int j=(int) i;
        if(j<25){
            j=0;
        }
        else if(j>=25&&j<50){
            j=1;
        }
        else if(j>=50&&j<75){
            j=2;
        }
        else if(j>=75){
            j=3;
        }
        return j;
    }
    
}