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
public class Insercion {
    private int[]A;
    private ArrayList<ModelCompany> arrayCompanies;

    public Insercion() {
    }

    
    
    public Insercion(ArrayList<ModelCompany> arrayCompanies) {
        this.arrayCompanies = arrayCompanies;
    }

    public Insercion(int[] A) {
        this.A = A;
    }
    
    
    
    public void insercionMin(){
        int i,k;
        ModelCompany aux;
        for(i=1;i<arrayCompanies.size();i++){
            aux = arrayCompanies.get(i);
            k = i-1;
            while(k>=0 && aux.getIndexMin() < arrayCompanies.get(k).getIndexMin()){
                arrayCompanies.set(k+1, arrayCompanies.get(k));
                k--;
            }
            arrayCompanies.set(k+1, aux);
        }
    }
    
    public void insercionMax(){
        int i,k;
        ModelCompany aux;
        for(i=1;i<arrayCompanies.size();i++){
            aux = arrayCompanies.get(i);
            k = i-1;
            while(k>=0 && aux.getIndexMax() >= arrayCompanies.get(k).getIndexMax()){
                arrayCompanies.set(k+1, arrayCompanies.get(k));
                k--;
            }
            arrayCompanies.set(k+1, aux);
        }
    }
    
    public void imprimir(){
        for(int i=0;i<A.length;i++){
            System.out.println(A[i]);
        }
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
