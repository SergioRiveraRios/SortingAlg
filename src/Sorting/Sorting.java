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
public class Sorting {
    private int tam, tope = -1;
    public Sorting() {
        tam = 0;
        tope = -1;

    }
    public Sorting(int tam) {
        this.tam = tam;
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
    public Alumno[] BubbleSort(Alumno C[],String cad) {
        for (int p = 1; p < tam; p++) {
            for (int i = 0; i < tam - p; i++) {
                if (cad.equals("Nombre")) {
                    if (C[i].getNombre().compareTo(C[i + 1].getNombre()) > 0) {
                        Alumno t = C[i];
                        C[i] = C[i + 1];
                        C[i + 1] = t;
                    }
                }//if nombre
                else {
                    if (cad.equals("Edad")) {
                        if (C[i].getEdad() > C[i + 1].getEdad()) {
                            Alumno t = C[i];
                            C[i] = C[i + 1];
                            C[i + 1] = t;
                        }
                    }//if edad
                    else {
                        if (cad.equals("NumC")) {
                            if (C[i].getNumC().compareTo(C[i + 1].getNumC()) > 0) {
                                Alumno t = C[i];
                                C[i] = C[i + 1];
                                C[i + 1] = t;
                            }
                        }//if numC
                        else{
                            if (C[i].getMat().getProm()>C[i+1].getMat().getProm()) {
                                Alumno t = C[i];
                                C[i] = C[i + 1];
                                C[i + 1] = t;
                            }
                        }
                    }
                }//else
            }//for i
        }//for p
        
        return C;
    }//BubbleSortEdad
    public int Hash(Alumno C[],String n) {
        int s = 0;
        for (int i = 0; i < n.length(); i++) {
            s += n.charAt(i);
        }
        return s % C.length;
    }
    public int SumCarac(String n) {
        int s = 0;
        for (int i = 0; i < n.length(); i++) {
            s += n.charAt(i);
        }
        return s;
    }
    public Alumno getMax(Alumno C[],String cad) {
        Alumno m = C[0];
        for (int i = 1; i <C.length; i++) {
                if(cad.equals("Edad")){
                    if (C[i].getEdad()>m.getEdad()) {
                        m = C[i];
                    }
                }
                else{
                    if(cad.equals("Prom")){
                        if (C[i].getNumC().compareToIgnoreCase(m.getNumC())>0) {
                            m = C[i];
                        }
                    }
                    else{
                        if(cad.equals("Nombre")){
                            if(C[i].getNombre().compareToIgnoreCase(m.getNombre())>0){
                                m=C[i];
                            }
                        }
                        else{
                            if(Integer.parseInt(C[i].getNumC())>Integer.parseInt(m.getNumC())){
                                m=C[i];
                            }
                        }
                    }
                }

        }
        return m;
    }
    public Alumno[] radixSort(Alumno C[],String cad) {
        int div = 1, r = 0, num;
        Colas []D=new Colas[10];
        String mayor=getMax(C,cad)+"";
        do {
            for (int c = 0; c < 10; c++) {
                D[c] = new Colas(tam);
            }//Tamaño de cola
            for (int i = 0; i <C.length; i++) {
                if(cad.equals("Promedio")){
                    num = C[i].getMat().getProm() / div;
                    num = num % 10;
                    D[num].meter(C[i]);
                }
                else{
                    if(cad.equals("Edad")){
                        num = C[i].getEdad()/ div;
                        num = num % 10;
                        D[num].meter(C[i]);
                    }
                    else{
                        if(cad.equals("NumC")){
                            num = Integer.parseInt(C[i].getNumC())/ div;
                            num = num % 10;
                            D[num].meter(C[i]);
                        }
                        else{
                            num=SumCarac(C[i].getNombre())/div;
                            num = num % 10;
                            D[num].meter(C[i]); 
                        }
                    }
                }
            }//Los mete a la cola
            int a = 0;
            while (a <tam) {
                for (int c = 0; c < 10; c++) {
                    int i = 0;
                    while (i <= D[c].getTope()) {
                        C[a++] = D[c].getDato(i++);
                    }
                }
            }
            div = div * 10;
            r++;
        }//do
        while (r < mayor.length());
        return C;
    }//radixSortProm
    public Alumno[] QuickSort(Alumno C[], int inicio, int fin,String cad) {
        int i = inicio, j = fin;
        Alumno p = C[inicio];
        Alumno aux;
        while (i < j) {
            if(cad.equals("Nombre")){
                while (C[i].getNombre().compareToIgnoreCase(p.getNombre())<=0 && i < j) {i++;}
                while (C[j].getNombre().compareToIgnoreCase(p.getNombre())>0) {j--;}
            }
            else{
                if(cad.equals("Edad")){
                    while (C[i].getEdad() <= p.getEdad() && i < j) {i++;}
                    while (C[j].getEdad() > p.getEdad()) {j--;}
                }
                else{
                    if(cad.equals("NumC")){
                        while (C[i].getNumC().compareToIgnoreCase(p.getNumC())<=0 && i < j) {i++;}
                        while (C[j].getNumC().compareToIgnoreCase(p.getNumC())>0) {j--;}
                    }
                    else{
                            while (C[i].getMat().getProm() <= p.getMat().getProm() && i < j) {i++;}
                            while (C[j].getMat().getProm() > p.getMat().getProm()) {j--;}
                        
                        }
                    }
                }
            
            if (i < j) {
                aux = C[i];
                C[i] = C[j];
                C[j] = aux;
            }
        }//while
        C[inicio] = C[j];
        C[j] = p;
        if (inicio < j - 1) {
            QuickSort(C, inicio, j - 1,cad);
        }
        if (j + 1 < fin) {
            QuickSort(C, j + 1, fin,cad);
        }
        return C;
    }
    public void QuickSort(Alumno C[],String cad) {
        QuickSort(C, 0, C.length - 1,cad);
    }
    public Alumno[] shellSort(Alumno A[],String cad) {
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
        return A;
    }//ShellSortNombre
    public Alumno[] Intercalacion(Alumno C[], Alumno D[]) {
        int i,j,k;
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
    public Alumno[] Mezcla(Alumno A[],String cad) {
        mergesort(A, 0, tam - 1,cad);
        return A;
    }
    public void mergesort(Alumno A[], int izq, int der,String cad) {
        if (izq < der) {
            int m = (izq + der) / 2;
            mergesort(A, izq, m,cad);
            mergesort(A, m + 1, der,cad);
            merge(A, izq, m, der,cad);
        }
    }
    public void merge(Alumno A[], int izq, int m, int der,String cad) {
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
            if(cad.equals("Nombre")){
                if (B[i].getNombre().compareToIgnoreCase(B[j].getNombre())<0) {
                    A[k++] = B[i++];
                } else {
                    A[k++] = B[j++];
                }
            }//nombre
            else{
                if(cad.equals("Edad")){
                    if (B[i].getEdad()<B[j].getEdad()) {
                        A[k++] = B[i++];
                    } else {
                        A[k++] = B[j++];
                    }
                }
                else{
                    if(cad.equals("NumC")){
                        if (Integer.parseInt(B[i].getNumC())<Integer.parseInt(B[j].getNumC())) {
                            A[k++] = B[i++];
                        } else {
                            A[k++] = B[j++];
                        }
                    }else{
                        if (B[i].getMat().getProm()< B[j].getMat().getProm()) {
                            A[k++] = B[i++];
                        } else {
                            A[k++] = B[j++];
                        }
                    }
                }
            }
            
        }
        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }
    
}
