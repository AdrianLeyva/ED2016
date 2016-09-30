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
    public static final String AIRPA = "AIR.PA";
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
    
    public void sortListCompanies(ArrayList<ModelCompany> companyList){
        String quick = DataManager.QUICK_METHOD;
        
        
        switch(this.requestModel.getSortMethod()){
            case DataManager.QUICK_METHOD:
                new QuickSort(companyList).quickSort();
                break;
                
            case DataManager.BURBUJA_METHOD:
                new BubbleSort(companyList).burbujaMenor();
                break;
            case DataManager.SHELL_METHOD:
                new ShellSort(companyList).shellsort();
                break;
            case DataManager.MERGE_METHOD:
                new MergeSort().ordenaMerge(companyList);
                break;
            case DataManager.INSERCION_METHOD:
                new Insercion(companyList).insercion();
                break;
        }
    }
    
    public ArrayList<ModelCompany> getModelCompany() throws IOException{
        verifyRequest();
        return this.companyList;
    }

    public Request getRequestModel() {
        return requestModel;
    }

    public void setRequestModel(Request requestModel) {
        this.requestModel = requestModel;
    }
    
    public static void main(String[] args) throws IOException {
        Request requestModel = new Request();
        requestModel.setCompanyID(DataManager.AAPL);
        requestModel.setInitialDay(12);
        requestModel.setEndDay(15);
        requestModel.setInitialMonth(04);
        requestModel.setEndMonth(11);
        requestModel.setInitialYear(2014);
        requestModel.setEndYear(2015);
        requestModel.setIndex(DataManager.INDEX_MIN);
        requestModel.setSortMethod(DataManager.QUICK_METHOD);
        
        DataManager dataManager = new DataManager(requestModel);
        ArrayList<ModelCompany> companyArray = dataManager.getModelCompany();
        dataManager.sortListCompanies(companyArray);
        
        for(int j=0; j<companyArray.size(); j++){
            System.out.println(companyArray.get(j).getIndex());
        }
    }
    
}