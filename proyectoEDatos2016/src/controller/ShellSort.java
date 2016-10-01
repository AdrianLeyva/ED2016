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
public class ShellSort {
    int[]A;
    private ArrayList<ModelCompany> arrayCompanies;
    
    public ShellSort() {
    }

    
    
    public ShellSort(int[] A) {
        this.A = A;
    }

    public ShellSort(ArrayList<ModelCompany> arrayCompanies) {
        this.arrayCompanies = arrayCompanies;
    }
    
    
    
    public void shellsortMin(){
        int intervalo, i;
        ModelCompany aux;
        boolean band;
        intervalo = arrayCompanies.size();
        while(intervalo>1){
            intervalo /= 2; //equivale a intervalo = intervalo/2;
            band = true;
            while (band){
                band = false;
                i=0;
                while((intervalo+i) < arrayCompanies.size()){
                    if (arrayCompanies.get(i).getIndex() > arrayCompanies.get(i+intervalo).getIndex()){
                        aux = arrayCompanies.get(i);
                        arrayCompanies.set(i, arrayCompanies.get(i+intervalo));
                        arrayCompanies.set(i+intervalo, aux);
                        band = true;
                    }
                    i++;
                }
            }       
        }
    }
    
    public void shellsortMax(){
        int intervalo, i;
        ModelCompany aux;
        boolean band;
        intervalo = arrayCompanies.size();
        while(intervalo>1){
            intervalo /= 2; //equivale a intervalo = intervalo/2;
            band = true;
            while (band){
                band = false;
                i=0;
                while((intervalo+i) < arrayCompanies.size()){
                    if (arrayCompanies.get(i).getIndex() < arrayCompanies.get(i+intervalo).getIndex()){
                        aux = arrayCompanies.get(i);
                        arrayCompanies.set(i, arrayCompanies.get(i+intervalo));
                        arrayCompanies.set(i+intervalo, aux);
                        band = true;
                    }
                    i++;
                }
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
