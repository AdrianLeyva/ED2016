/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import model.ModelCompany;

/**
 *
 * @author adrianleyva
 */
public class BubbleSort {
    private int[]A;
    private ArrayList<ModelCompany> arrayCompanies;

    public BubbleSort() {
    }

    public BubbleSort(int[] A) {
        this.A = A;
    }

    public BubbleSort(ArrayList<ModelCompany> arrayCompanies) {
        this.arrayCompanies = arrayCompanies;
    }
    
    
    
    public void burbujaMenor(){
        int i, j;
        ModelCompany aux;
        for(i=1;i<arrayCompanies.size();i++){
            for(j=arrayCompanies.size()-1;j>=i;j--)
                if (arrayCompanies.get(j-1).getIndex() > arrayCompanies.get(j).getIndex()){ //Intercambio los elementos
                    aux = arrayCompanies.get(j-1);
                    arrayCompanies.set(j-1, arrayCompanies.get(j));
                    arrayCompanies.set(j, aux);
                }        
        }
    }
    
    public void burbujaMayor(){
        int i, j;
        ModelCompany aux;
        for(i=1;i<arrayCompanies.size();i++){
            for(j=arrayCompanies.size()-1;j>=i;j--)
                if (arrayCompanies.get(j-1).getIndex() <= arrayCompanies.get(j).getIndex()){ //Intercambio los elementos
                    aux = arrayCompanies.get(j-1);
                    arrayCompanies.set(j-1, arrayCompanies.get(j));
                    arrayCompanies.set(j, aux);
                }        
        }
    }
    
    public void imprimir(){
    for (int i=0;i <A.length;i++)
       System.out.println(A[i]);
    }

    public int[] getA() {
        return A;
    }

    public void setA(int[] A) {
        this.A = A;
    }

    public ArrayList<ModelCompany> getArrayCompanies() {
        return arrayCompanies;
    }

    public void setArrayCompanies(ArrayList<ModelCompany> arrayCompanies) {
        this.arrayCompanies = arrayCompanies;
    }
    
    
}
