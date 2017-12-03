/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

/**
 *
 * @author sergio
 */
public class Alumno {
    private Materia mat;
    private String nombre,numC;
    private int edad;
    public Alumno() {
        mat=new Materia();
        nombre=numC="";
        edad=0;
    }

    public Alumno(String nombre, String numC,Materia mat,int edad) {
        this.nombre = nombre;
        this.numC = numC;
        this.edad=edad;
        this.mat=mat;
    }
    
    public Materia getMat() {
        return mat;
    }

    public void setMat(Materia mat) {
        this.mat = mat;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumC() {
        return numC;
    }

    public void setNumC(String numC) {
        this.numC = numC;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
     
}
