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
    
    
    
    public void insercion(){
        int i,k;
        double aux;
        for(i=1;i<arrayCompanies.size();i++){
            aux = arrayCompanies.get(i).getIndex();
            k = i-1;
            while(k>=0 && aux<arrayCompanies.get(k).getIndex()){
                arrayCompanies.get(k+1).setIndex(arrayCompanies.get(k).getIndex());
                k--;
            }
            arrayCompanies.get(k+1).setIndex(aux);
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
