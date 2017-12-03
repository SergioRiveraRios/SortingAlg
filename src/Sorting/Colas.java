package Sorting;


import static javax.swing.JOptionPane.*;

public class Colas{
   private int tam,tope,frente;
   public Alumno A[];
   public Colas(){
      frente=0;   
      tope=0;
   }//Constructor1
   public Colas(int t){
      tam=t;
      tope=-1;
      A=new Alumno[tam];
   }
   public boolean llena(){return tope==tam-1;}
   public boolean vacia(){return tope==-1;}

   public void meter(Alumno d){
      if(!llena()){
        A[++tope]=d;
        }
      else showMessageDialog(null,"La cola est� llena");
   }
   public int sacar(){
      int a=0;
      if(!vacia()){
         a=A[0].getEdad();
         for(int i=0;i<tope;i++){
         A[i]=A[i+1];
         }
         tope--;
      }
      return a;
   }
   public int getTope(){return tope;}
   public Alumno getDato(int i){
      return A[i];
   }
   public static void main(String ar[]){
      int v=Integer.parseInt(showInputDialog(null,"Ingresa el tama�o"));
      Colas a=new Colas(v);
      
      a.sacar();
      
   }
}