/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ModelCompany;
import model.Request;
import view.ViewMenu;

/**
 *
 * @author Marco
 */
public class controllerMenu implements ActionListener{
    
    ViewMenu view = new ViewMenu();
    
    public controllerMenu (ViewMenu view){
        this.view=view;
        this.view.btnRefrescar.addActionListener(this);
        this.view.btnOrdenar.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent e){
        
            if(e.getSource()==view.btnOrdenar){
                
                try {
                    //Obtenemos las fechas seleccionadas
                    SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
                    String fechaInicial = formatoFecha.format(view.DateChooserInicial.getDate());
                    String fechaFinal = formatoFecha.format(view.DateChooserFinal.getDate());
                    
                    int diaInicial = Integer.parseInt(fechaInicial.substring(8, 10));
                    
                    int diaFinal = Integer.parseInt(fechaFinal.substring(8, 10));
                    
                    int mesInicial = Integer.parseInt(fechaInicial.substring(5, 7));
                    
                    int mesFinal = Integer.parseInt(fechaFinal.substring(5, 7));
                    
                    int añoInicial = Integer.parseInt(fechaInicial.substring(0, 4));
                    
                    int añoFinal = Integer.parseInt(fechaFinal.substring(0, 4));
                    
                    
                    
                    Request requestModel = new Request();
                    //Obtenemos y asignamos la empresa que fue seleccionada
                    switch(view.ComboboxEmpresas.getSelectedIndex()){
                        case 0:
                            requestModel.setCompanyID(DataManager.INTC);
                            break;
                            
                        case 1:
                            requestModel.setCompanyID(DataManager.BABA);
                            break;
                            
                        case 2:
                            requestModel.setCompanyID(DataManager.TSLA);
                            break;
                            
                        case 3:
                            requestModel.setCompanyID(DataManager.AIR);
                            break;
                            
                        case 4:
                            requestModel.setCompanyID(DataManager.YHOO);
                            break;
                            
                        case 5:
                            requestModel.setCompanyID(DataManager.AAPL);
                            break;
                            
                        case 6:
                            requestModel.setCompanyID(DataManager.GOOG);
                            break;
                            
                        case 7:
                            requestModel.setCompanyID(DataManager.MAMS);
                            break;
                            
                        case 8:
                            requestModel.setCompanyID(DataManager.KFFB);
                            break;
                            
                        case 9:
                            requestModel.setCompanyID(DataManager.TACT);
                            break;
                    }
                    
                    //Asignamos las fechas seleccionadas
                    requestModel.setInitialDay(diaInicial);
                    requestModel.setEndDay(diaFinal);
                    requestModel.setInitialMonth(mesInicial);
                    requestModel.setEndMonth(mesFinal);
                    requestModel.setInitialYear(añoInicial);
                    requestModel.setEndYear(añoFinal);
                    
                    //obtenemos y asignamos "maximo" o "minimo"
                    if (view.radioMaximo.isSelected()){
                        requestModel.setIndex(DataManager.INDEX_MAX);
                    }
                    else{
                        requestModel.setIndex(DataManager.INDEX_MIN);
                    }
                    
                    
                    //obtenemos y asignamos el metodo de ordenamiento seleccionado
                    switch(view.ComboBoxOrdenamiento.getSelectedIndex()){
                        
                        case 0:
                            requestModel.setSortMethod(DataManager.INSERCION_METHOD);
                            break;
                            
                        case 1:
                            requestModel.setSortMethod(DataManager.BURBUJA_METHOD);
                            break;
                            
                        case 2:
                            requestModel.setSortMethod(DataManager.SHELL_METHOD);
                            break;
                            
                        case 3:
                            requestModel.setSortMethod(DataManager.MERGE_METHOD);
                            break;
                            
                        case 4:
                            requestModel.setSortMethod(DataManager.QUICK_METHOD);
                            break;
                    }
                    
                    //Instanciamos el metodo final
                    DataManager dataManager = new DataManager(requestModel);
                    dataManager.run();
                    ArrayList<ModelCompany> companyArray = dataManager.getModelCompany();
                    
                    //se imprime los resultados ya ordenados
                    for(int j=0; j<companyArray.size(); j++){
                        System.out.println(companyArray.get(j).getIndex());
                    }   
                    
                } catch (IOException ex) {
                    Logger.getLogger(controllerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
    }
}