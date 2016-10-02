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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ModelCompany;
import model.Request;
import view.ViewMenu;

/**
 *
 * @author Marco
 */
public class controllerMenu implements ActionListener{
    ViewMenu view = new ViewMenu();
    DefaultTableModel tableModel = new DefaultTableModel();
    String[] columnas= {"Empresa", "Máximo", "Mínimo", "Fecha"};
    Object[] filas = new Object[4];
    String companyName;
    
    
    public controllerMenu (ViewMenu view){
        this.view=view;
        this.view.btnRefrescar.addActionListener(this);
        this.view.btnOrdenar.addActionListener(this);
        
        
        tableModel.setColumnIdentifiers(columnas);
        view.jTableEmpresas.setModel(tableModel);
    }
    
    public void actionPerformed(ActionEvent e){
        
        
            if(e.getSource()==view.btnOrdenar && validacionFecha()){
                
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
                            companyName = "Intel Corp";
                            break;
                            
                        case 1:
                            requestModel.setCompanyID(DataManager.BABA);
                            companyName = "Alibaba Group";
                            break;
                            
                        case 2:
                            requestModel.setCompanyID(DataManager.TSLA);
                            companyName = "Tesla Motors";
                            break;
                            
                        case 3:
                            requestModel.setCompanyID(DataManager.AIR);
                            companyName = "Airbus Group";
                            break;
                            
                        case 4:
                            requestModel.setCompanyID(DataManager.YHOO);
                            companyName = "Yahoo! Inc";
                            break;
                            
                        case 5:
                            requestModel.setCompanyID(DataManager.AAPL);
                            companyName = "Apple Inc";
                            break;
                            
                        case 6:
                            requestModel.setCompanyID(DataManager.GOOG);
                            companyName = "Google";
                            break;
                            
                        case 7:
                            requestModel.setCompanyID(DataManager.MAMS);
                            companyName = "Mam Software";
                            break;
                            
                        case 8:
                            requestModel.setCompanyID(DataManager.KFFB);
                            companyName = "Kentucky First Fed";
                            break;
                            
                        case 9:
                            requestModel.setCompanyID(DataManager.TACT);
                            companyName = "Transact Tech Inc";
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
                        System.out.println(companyArray.get(j).getIndex() + " " +
                                            companyArray.get(j).getDate() + " " +
                                            companyArray.get(j).getCompanyName());
                    }   
                    
                    //Llenando la tabla con los datos ordenados
                    if(view.radioMaximo.isSelected()){
                        for(int i=0; i<companyArray.size();i++){
                        filas[0] = companyName;
                        filas[1] = companyArray.get(i).getIndex();
                        filas[2] = null;
                        filas[3] = companyArray.get(i).getDate();
                        tableModel.addRow(filas);
                        }
                    }
                    else if(view.radioMinimo.isSelected()){
                        for(int i=0; i<companyArray.size();i++){
                        filas[0] = companyName;
                        filas[1] = null; 
                        filas[2] = companyArray.get(i).getIndex();
                        filas[3] = companyArray.get(i).getDate();
                        tableModel.addRow(filas);
                        }
                    }
                    
                } catch (IOException ex) {
                    Logger.getLogger(controllerMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if(e.getSource() == view.btnRefrescar){
                //Asociando los botones en grupo para posteriormente limpiarlos
                ButtonGroup group= new ButtonGroup();
                group.add(view.radioMaximo);
                group.add(view.radioMinimo);
                group.clearSelection();
                tableModel.getDataVector().removeAllElements();
                view.revalidate();
                view.repaint();
                view.ComboboxEmpresas.setSelectedIndex(0);
                view.ComboBoxOrdenamiento.setSelectedIndex(0);
                view.DateChooserInicial.setDate(null);
                view.DateChooserFinal.setDate(null); 
            }
    }
    
    public Boolean validacionFecha(){
        Date today = new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("yyyy-MM-dd");
        int añoInicial =Integer.parseInt(formatoFecha.format(view.DateChooserInicial.getDate()).substring(0, 4)) ;
        
        if(view.DateChooserInicial.getDate().before(today) &&
            view.DateChooserFinal.getDate().after(view.DateChooserInicial.getDate()) &&
            añoInicial > 1966){
            return true;
            // && 
            // )
        }
        else {
            JOptionPane.showMessageDialog(view, "Seleccione fechas válidas" , "Fechas no válidas" , JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}