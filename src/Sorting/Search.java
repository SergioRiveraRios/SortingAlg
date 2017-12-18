/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author sergio
 */
public class Search {
    private int tam;
    private String dato,Hash[];
    private Alumno HashLl[];
    public Search(int tam){
        this.tam=tam;
        Hash=new String[99];
        HashLl=new Alumno[tam];
    }
    public String opcion(int a) {
        String cat = "";
        switch (a) {
            case 1:
                cat="Nombre";
            break;
            case 2:
                cat="Edad";
            break;
            case 3:
                cat="NumC";
            break;
            case 4:
                cat="Prom";
            break;
            default:
                cat = "aa";
                showMessageDialog(null, cat);
        }
        return cat;
    }
    public int sec(Alumno A[],String OP,String dato){
        int pos=-1;
        for(int i=0;i<A.length;i++){
            if(getDato(A[i],OP).equals(dato)){
                return pos=i;
            }
        }
        return pos;
    }
    public String getDato(Alumno B,String OP){
        String temp="";
        switch(OP){
            case "Nombre":
                temp=B.getNombre();
            break;
            case "Edad":
                temp=B.getEdad()+"";
            break;
            case "NumC":
                temp=B.getNumC();
            break;
            case "Prom":
                temp=B.getMat().getProm()+"";
            break;
            default:
                showMessageDialog(null,"Erros");
            break;
        }
        return temp;
    }
    public int busquedaBinaria(Alumno A[],String OP, String dato) {
        int n = A.length;
        int centro = 0, inf = 0, sup = n - 1;
            while (inf <= sup) {
                centro = (sup + inf) / 2;
                if (getDato(A[centro],OP).equals(dato)) {
                    return centro;
                } else if (dato.compareToIgnoreCase(getDato(A[centro],OP))<0) {
                    sup = centro - 1;
                } else {
                    inf = centro + 1;
                }
            }
        return centro;
    }//BusquedaBinaria
    public void RellenaArrayHash(){
        for(int i=0;i<Hash.length;i++){
            Hash[i]=null;
        }
    }
    public int detHash(String n) {
        int s = 0;
        for (int i = 0; i < n.length(); i++) {
            s += n.charAt(i);
        }
        return s % HashLl.length;
    }
    public void AñadirHash(Alumno A, String B[]){
        int p=detHash(A.getNombre());
        while (B[p] != null) {
            p++;
            if (p==B.length - 1) {
                p = 0;
            }
        }
        B[p]=A.getNumC();
    }
    public void Hash1(String dato){
        RellenaArrayHash();
        for(int i=0;i<HashLl.length;i++){
            AñadirHash(HashLl[i],Hash);
        }
        Buscar(dato,Hash);
    }
    public void Buscar(String cad,String B[]){
     int p = detHash(cad);
        while (B[p] != null && !B[p].equals(cad)) {
            p++;
            if (p == B.length - 1) {
                p = 0;
            }
        }
        if (B[p] != null) {
            showMessageDialog(null,"El alumno " + cad + " se encuentra en la posición " + p + " en la tabla de HASH");
        } else {
            System.out.println("El alumno que está buscando no existe");
        }
    
 }
}
