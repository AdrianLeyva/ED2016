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
public class MergeSort {
    
    public ArrayList<ModelCompany> ordenaMerge(ArrayList<ModelCompany> L){
        int n = L.size(), i,m;
        ArrayList<ModelCompany> L1 = new ArrayList<>(),
                L2 = new ArrayList<>();
        if(n>1){
            m = n/2;
            for (i = 0; i < m; i++)
                L1.add(L.get(i));
            for (i = m; i < n; i++)
                L2.add(L.get(i));    
            L = merge(ordenaMerge(L1),ordenaMerge(L2));
            
        }
        
        return L;
    }
    
    public ArrayList merge(ArrayList<ModelCompany> L1, ArrayList<ModelCompany> L2){
        ArrayList<ModelCompany> lista = new ArrayList<>();
        while (!L1.isEmpty() && !L2.isEmpty()){
            
            if ((Double)L2.get(0).getIndex() < (Double)L1.get(0).getIndex()){
                
                lista.add(L1.get(0));
                L1.remove(0);
                if(L1.isEmpty()){
                    lista.addAll(L2);
                    L2.clear();
                }
            }
            else{
                lista.add(L2.get(0));
                L2.remove(0);
                if (L2.isEmpty()){
                lista.addAll(L1);
                L1.clear();
                }
            }
        }
        return lista;
    }
}
