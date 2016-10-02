/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import model.ModelCompany;
import model.Request;
import view.ViewMenu;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

/**
 *
 * @author adrianleyva
 */
public class DataManager {
    public static final String INTC = "INTC";
    public static final String BABA = "BABA";
    public static final String TSLA = "TSLA";
    public static final String AIR = "AIR";
    public static final String YHOO = "YHOO";
    public static final String AAPL = "AAPL";
    public static final String GOOG = "GOOG";
    public static final String MAMS = "MAMS";
    public static final String KFFB = "KFFB";
    public static final String TACT = "TACT";
    
    public static final String INDEX_MIN = "MIN";
    public static final String INDEX_MAX = "MAX";
    
    public static final String INSERCION_METHOD = "INSERCION_METHOD";
    public static final String BURBUJA_METHOD = "BURBUJA_METHOD";
    public static final String SHELL_METHOD = "SHELL_METHOD";
    public static final String MERGE_METHOD = "MERGE_METHOD";
    public static final String QUICK_METHOD = "QUICK_METHOD";
    public static final String MEZCLA_DIRECTA_METHOD = "MEZCLA_DIRECTA_METHOD";
    public static final String MEZCLA_EQUILIBRADA_METHOD = "MEZCLA_EQUILIBRADA_METHOD";
    
    private Request requestModel;
    private ArrayList<ModelCompany> companyList;
    
    public DataManager() {
        companyList = new ArrayList<>();
    }

    public DataManager(Request requestModel) {
        this.requestModel = requestModel;
        companyList = new ArrayList<>();
    }
    
    public void verifyRequest() throws IOException{
        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.set(requestModel.getInitialYear(), requestModel.getInitialMonth(), requestModel.getInitialDay());
        to.set(requestModel.getEndYear(), requestModel.getEndMonth(), requestModel.getEndDay());
        
        Stock company = YahooFinance.get(requestModel.getCompanyID());
        List<HistoricalQuote> googleHistQuotes = company.getHistory(from, to, Interval.DAILY);
        
        for(int i=0; i<googleHistQuotes.size(); i++){
            if(requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                ModelCompany modelCompany = new ModelCompany();
                modelCompany.setCompanyName(googleHistQuotes.get(i).getSymbol());
                modelCompany.setIndex(googleHistQuotes.get(i).getLow().doubleValue());
                modelCompany.setDate(googleHistQuotes.get(i).getDate().getTime().toString());
                companyList.add(modelCompany);
            }else{
                ModelCompany modelCompany = new ModelCompany();
                modelCompany.setCompanyName(googleHistQuotes.get(i).getSymbol());
                modelCompany.setIndex(googleHistQuotes.get(i).getHigh().doubleValue());
                modelCompany.setDate(googleHistQuotes.get(i).getDate().getTime().toString());
                companyList.add(modelCompany);
            }
        }
    }
    
    public void sortListCompanies(){
        switch(this.requestModel.getSortMethod()){
            case DataManager.QUICK_METHOD:
                if(this.requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                    new QuickSort(this.companyList).quickSortMin();
                }else{
                    new QuickSort(this.companyList).quickSortMax();
                }
                
                break;
                
            case DataManager.BURBUJA_METHOD:
                if(this.requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                    new BubbleSort(this.companyList).burbujaMenor();
                }else{
                    new BubbleSort(this.companyList).burbujaMayor();
                }
                break;
                
            case DataManager.SHELL_METHOD:
                if(this.requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                    new ShellSort(this.companyList).shellsortMin();
                }else{
                    new ShellSort(this.companyList).shellsortMax();
                }
                break;
                
            case DataManager.MERGE_METHOD:
                if(this.requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                    this.companyList = new MergeSort().ordenaMergeMin(this.companyList);
                }else{
                    this.companyList = new MergeSort().ordenaMergeMax(this.companyList);
                }
                break;
            case DataManager.INSERCION_METHOD:
                if(this.requestModel.getIndex().equals(DataManager.INDEX_MIN)){
                    new Insercion(this.companyList).insercionMin();
                }else{
                    new Insercion(this.companyList).insercionMax();
                }
                
                break;
        }
    }
    
    public void run() throws IOException{
        verifyRequest();
        sortListCompanies();
    }
    
    public ArrayList<ModelCompany> getModelCompany() throws IOException{
        return this.companyList;
    }

    public Request getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(Request requestModel) {
        this.requestModel = requestModel;
    }
    
    
    
}
