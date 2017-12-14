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
public class Materia {
    private String unidad1,unidad2,unidad3,unidad4,unidad5;
    public Materia(){}

    public Materia(String unidad1, String unidad2, String unidad3,String unidad4, String unidad5) {
        this.unidad1 = unidad1;
        this.unidad2 = unidad2;
        this.unidad3 = unidad3;
        this.unidad4 = unidad4;
        this.unidad5 = unidad5;
    }
    public int getCal(int i){
        int cal=0;
        switch(i){
            case 1:
                if(unidad1.equals("")){
                    return 0;
                }
                else{
                cal=Integer.parseInt(unidad1);
                }
            break;
            case 2:
                if(unidad2.equals("")){
                    return 0;
                }
                else{
                cal=Integer.parseInt(unidad2);
                }
            break;
            case 3:
                if(unidad3.equals("")){
                    return 0;
                }
                else{
                cal=Integer.parseInt(unidad3);
                }
            break;
            case 4: 
                if(unidad4.equals("")){
                    return 0;
                }
                else{
                cal=Integer.parseInt(unidad4);
                }
            break;
            case 5: 
                if(unidad5.equals("")){
                    return 0;
                }
                else{
                cal=Integer.parseInt(unidad5);
                }
            break;
            default:
                System.out.println("aaaa");
            break;
        }
        return cal;
    }
    public int getProm(){
        int suma=0;
        for(int i=1;i<=5;i++){
            suma=suma+getCal(i);
        }
        return suma/5;
    }
    public String getUni(String cad){
        String uni="";
        if(cad.equals("Unidad1")){
            uni="Unidad1";
        }
        else{
            if(cad.equals("Unidad2")){
                uni="Unidad2";
            }
            else{
                if(cad.equals("Unidad3")){
                    uni="Unidad3";
                }
                else{
                    if(cad.equals("Unidad4")){
                        uni="Unidad4";
                    }
                    else{
                        if(cad.equals("Unidad5")){
                            uni="Unidad5";
                        }
                    }
                }
            }
        }
        return uni;
    }
    public String getUnidad1() {
        return unidad1;
    }

    public void setUnidad1(String unidad1) {
        this.unidad1 = unidad1;
    }

    public String getUnidad2() {
        return unidad2;
    }

    public void setUnidad2(String unidad2) {
        this.unidad2 = unidad2;
    }

    public String getUnidad3() {
        return unidad3;
    }

    public void setUnidad3(String unidad3) {
        this.unidad3 = unidad3;
    }

    public String getUnidad4() {
        return unidad4;
    }

    public void setUnidad4(String unidad4) {
        this.unidad4 = unidad4;
    }

    public String getUnidad5() {
        return unidad5;
    }

    public void setUnidad5(String unidad5) {
        this.unidad5 = unidad5;
    }
    
    
}
