/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author Sergio
 */
public class Search {
    private int tam;
    private Alumno A[];
    
    public Search(){
        A=new Alumno[99];
    }
    public int Sec(Alumno B[],String dato){
        int pos=-1;
        for(int i=0;i<B.length;i++){
            if(B[i].getNumC().equals(dato)){
                return pos=i;
            }
        }
        return pos;
    }
    public int Bin(Alumno B[],String dato){
        int centro,ini=0,fin=B.length-1,pos=-1;
        while(ini<=fin){
            centro=(fin+ini)/2;
            if(B[centro].getNumC().equals(dato)){
                return pos=centro;
            }
            else{
                if(B[centro].getNumC().compareTo(dato)>0){
                    fin=centro-1;
                }else{
                    ini=centro+1;
                }
            }   
        }
        return pos;
    }
    
    
}
