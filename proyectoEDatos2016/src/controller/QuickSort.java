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
public class QuickSort {
    private int[]A;
    private ArrayList<ModelCompany> arrayCompany;
    
    public QuickSort() {
    }

    public QuickSort(int[] A) {
        this.A = A;
    }

    public QuickSort(ArrayList<ModelCompany> arrayCompany) {
        this.arrayCompany = arrayCompany;
    }
    
    
    
    
    public void quickSortMin(){
        int ini,fin;
        int pos;
        ArrayList pilaMenor = new ArrayList(), pilaMayor = new ArrayList();
        pilaMenor.add(0);
        pilaMayor.add(arrayCompany.size()-1);
        while(!pilaMenor.isEmpty()){
            ini = (Integer)pilaMenor.remove(pilaMenor.size()-1);
            fin = (Integer)pilaMayor.remove(pilaMayor.size()-1);
            pos = posicionaQuickSortMin(ini,fin);
            if(ini<pos-1){
                pilaMenor.add(ini);
                pilaMayor.add(pos-1);
            }
            if(fin>pos+1){
                pilaMenor.add(pos+1);
                pilaMayor.add(fin);
            }
        }
    }
    
    public int posicionaQuickSortMin(int ini, int fin){
        int pos,izq,der;
        ModelCompany aux;
        boolean band;
        izq = ini;
        der = fin;
        pos = ini;
        band = true;
        
        while(band){
            while(arrayCompany.get(pos).getIndex() <= arrayCompany.get(der).getIndex() && pos!=der)
                der--;
            if(pos == der){
                band = false;
            }else{
                aux = arrayCompany.get(pos);
                arrayCompany.set(pos, arrayCompany.get(der));
                arrayCompany.set(der, aux);
                pos = der;
                while(arrayCompany.get(pos).getIndex() >= arrayCompany.get(izq).getIndex() && pos!=izq)
                    izq++;
                if(pos == izq){
                    band = false;
                }else{
                    aux = arrayCompany.get(pos);
                    arrayCompany.set(pos,arrayCompany.get(izq));
                    arrayCompany.set(izq, aux);
                    pos = izq;
                }
            }
            
        }
        return  pos;
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

    public ArrayList<ModelCompany> getArrayCompany() {
        return arrayCompany;
    }

    public void setArrayCompany(ArrayList<ModelCompany> arrayCompany) {
        this.arrayCompany = arrayCompany;
    }
    
    
}
