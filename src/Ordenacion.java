/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sorting;

import static javax.swing.JOptionPane.showInputDialog;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author Sergio
 */
public class Ordenacion {

    private int tam, tope = -1;
    private Alumno A[], B;

    private Materia C;

    public Ordenacion() {
        tam = 0;
        tope = -1;

    }
    public Ordenacion(int tam) {
        this.tam = tam;
        A = new Alumno[tam];

    }
    public void BubbleSort(String cad) {
        for (int p = 1; p < tope; p++) {
            for (int i = 0; i < tam - p; i++) {
                if (cad.equals("Nombre")) {
                    if (A[i].getNombre().compareTo(A[i + 1].getNombre()) > 0) {
                        Alumno t = A[i];
                        A[i] = A[i + 1];
                        A[i + 1] = t;
                    }
                }//if nombre
                else {
                    if (cad.equals("Edad")) {
                        if (A[i].getEdad() > A[i + 1].getEdad()) {
                            Alumno t = A[i];
                            A[i] = A[i + 1];
                            A[i + 1] = t;
                        }
                    }//if edad
                    else {
                        if (cad.equals("NumC")) {
                            if (A[i].getNumC().compareTo(A[i + 1].getNumC()) > 0) {
                                Alumno t = A[i];
                                A[i] = A[i + 1];
                                A[i + 1] = t;
                            }
                        }//if numC
                        else{
                            if (A[i].getMat().getProm()>A[i+1].getMat().getProm()) {
                                Alumno t = A[i];
                                A[i] = A[i + 1];
                                A[i + 1] = t;
                            }
                        }
                    }
                }//else
            }//for i
        }//for p
    }//BubbleSortEdad
    public void shellSort(String cad) {
        int salto, i;
        Alumno aux;
        boolean cambios;
        for (salto=A.length/2;salto!=0;salto=salto/2) {
            cambios=true;
            while (cambios) { // Mientras se intercambie alg˙n elemento
                cambios = false;
                for (i = salto; i < A.length; i++) // se da una pasada
                {
                    if(cad.equals("Nombre")){
                        if (A[i - salto].getNombre().compareToIgnoreCase(A[i].getNombre()) > 0) { // y si est·n desordenados
                            aux = A[i]; // se reordenan
                            A[i] = A[i - salto];
                            A[i - salto] = aux;
                            cambios = true; // y se marca como cambio.
                        }//if
                    }
                    else{
                        if(cad.equals("Edad")){
                            if (A[i - salto].getEdad()>A[i].getEdad()){ // y si est·n desordenados
                                aux = A[i]; // se reordenan
                                A[i] = A[i - salto];
                                A[i - salto] = aux;
                                cambios = true; // y se marca como cambio.
                            }//if
                        }
                        else{
                        if(cad.equals("Numc")){
                            if (A[i - salto].getNumC().compareToIgnoreCase(A[i].getNumC())>0){ // y si est·n desordenados
                                aux = A[i]; // se reordenan
                                A[i] = A[i - salto];
                                A[i - salto] = aux;
                                cambios = true; // y se marca como cambio.
                            }//if
                        }
                        else{
                            if (A[i - salto].getMat().getProm()>A[i].getMat().getProm()){ // y si est·n desordenados
                                aux = A[i]; // se reordenan
                                A[i] = A[i - salto];
                                A[i - salto] = aux;
                                cambios = true; // y se marca como cambio.
                            }//if
                        }
                    }
                    }
                }
            }//wile
        }//For
    }//ShellSortNombre
    public Alumno getMax(String cad) {
        Alumno m = A[0];
        for (int i = 1; i < tope; i++) {
                if(cad.equals("Edad")){
                    if (A[i].getEdad()>m.getEdad()) {
                        m = A[i];
                    }
                }
                else{
                    if(cad.equals("Prom")){
                        if (A[i].getNumC().compareToIgnoreCase(m.getNumC())>0) {
                        m = A[i];
                    }
                    }
                }

        }
        return m;
    }
    public void radixSort(String cad) {
        Colas[] C = new Colas[10];
        int div = 1, r = 0, num;
        String mayor=getMax(cad)+"";
        do {
            for (int c = 0; c < 10; c++) {
                C[c] = new Colas(tam);
            }//Tamaño de cola
            for (int i = 0; i <= tope; i++) {
                if(cad.equals("Promedio")){
                    num = A[i].getMat().getProm() / div;
                    num = num % 10;
                    C[num].meter(A[i]);
                }
                else{
                    num = A[i].getEdad()/ div;
                    num = num % 10;
                    C[num].meter(A[i]);
                }
            }//Los mete a la cola
            int a = 0;
            while (a < tope) {
                for (int c = 0; c < 10; c++) {
                    int i = 0;
                    while (i <= C[c].getTope()) {
                        A[a++] = C[c].getDato(i++);
                    }
                }
            }
            div = div * 10;
            r++;
        }//do
        while (r < mayor.length());
    }//radixSortProm
    public void QuickSort(Alumno A[], int inicio, int fin,String cad) {
        int i = inicio, j = fin;
        Alumno p = A[inicio];
        Alumno aux;
        while (i < j) {
            if(cad.equals("Nombre")){
                while (A[i].getNombre().compareToIgnoreCase(p.getNombre())<=0 && i < j) {i++;}
                while (A[j].getNombre().compareToIgnoreCase(p.getNombre())>0) {j--;}
            }
            else{
                if(cad.equals("Edad")){
                    while (A[i].getEdad() <= p.getEdad() && i < j) {i++;}
                    while (A[j].getEdad() > p.getEdad()) {j--;}
                }
                else{
                    if(cad.equals("NumC")){
                        while (A[i].getNumC().compareToIgnoreCase(p.getNumC())<=0 && i < j) {i++;}
                        while (A[j].getNumC().compareToIgnoreCase(p.getNumC())>0) {j--;}
                    }
                    else{
                        while (A[i].getMat().getProm() <= p.getMat().getProm() && i < j) {i++;}
                        while (A[j].getMat().getProm() > p.getMat().getProm()) {j--;}
                    }
                }
            }
            if (i < j) {
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }//while
        A[inicio] = A[j];
        A[j] = p;
        if (inicio < j - 1) {
            QuickSort(A, inicio, j - 1,cad);
        }
        if (j + 1 < fin) {
            QuickSort(A, j + 1, fin,cad);
        }
    }//QUICKSORTCalificacionUnidad
    public void QuickSort(String cad) {
        QuickSort(A, 0, A.length - 1,cad);
    }
    public Alumno[] Intercalacion(Alumno C[], Alumno D[]) {
        int i,//ARREGLO C
                j,//ARREGLO D
                k;//AREGO AUX
        Alumno aux[] = new Alumno[C.length + D.length];
        for (i = j = k = 0; i < C.length && j < D.length; k++) {
            if (C[i].getNombre().compareToIgnoreCase(D[j].getNombre()) < 0) {
                aux[k] = C[i];
                i++;
            } else {
                aux[k] = D[j];
                j++;
            }
        }
        for (; i < C.length; i++, k++) {
            aux[k] = C[i];
        }
        for (; j < D.length; j++, k++) {
            aux[k] = D[j];
        }
        
        return aux;
    }
    public String opcion(int a) {
        String cad = "";
        switch (a) {
            case 1:
                cad = "Nombre";
                break;
            case 2:
                cad = "Edad";
                break;
            case 3:
                cad = "NumC";
                break;
            case 4:
                cad = "Promedio";
                break;
            default:
                showMessageDialog(null, "Selecciona opcion valdia");
                break;
        }
        return cad;
    }
    public void OrdenacionInterna(int a, int b) {
        String cad = opcion(b);
        switch (a) {
            case 1:
                BubbleSort(cad);
                break;
            case 2:
                QuickSort(cad);
                break;
            case 3:
                shellSort(cad);
                break;
            case 4:
                radixSort(cad);
                break;
            default:
                showMessageDialog(null, "Error");
                break;
        }
    }
    public void OrdenacionExterna(int a) {
        switch (a) {
            case 1:
                //Aqui va intercalacion pero marca error alv
                break;
            case 2:
                Mezcla();
                break;
            default:
                showMessageDialog(null, "Error");
                break;
        }
    }
    public void Mezcla() {
        mergesort(A, 0, tam - 1);
    }
    public void mergesort(Alumno A[], int izq, int der) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }
    public void merge(Alumno A[], int izq, int m, int der) {
        int i, j, k;
        Alumno B[] = new Alumno[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar
        {
            B[i] = A[i];
        }
        i = izq;
        j = m + 1;
        k = izq;
        while (i <= m && j <= der) //copia el siguiente elemento más grande
        {
            if (B[i].getEdad() < B[j].getEdad()) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }
    public int getTam() {
        return tam;
    }
    public void setTam(int tam) {
        this.tam = tam;
    }
    public Alumno[] getA() {
        return A;
    }
    public void setA(Alumno[] A) {
        this.A = A;
    }
    public Alumno getB(int i) {
        return A[i];
    }
    public void setB(Alumno B) {
        this.B = B;
    }
    public Materia getC() {
        return C;
    }
    public void setC(Materia C) {
        this.C = C;
    }
    public void añadir(Alumno C) {
        if (tope != tam - 1) {
            A[++tope] = C;
        } else {
            showMessageDialog(null, "lista llena");
        }
    }
    public int getTope() {
        return tope;
    }
}
