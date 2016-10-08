/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author adrianleyva
 */
public class ModelCompany {
    private String companyName;
    private double indexMin;
    private double indexMax;

    public double getIndexMin() {
        return indexMin;
    }

    public void setIndexMin(double indexMin) {
        this.indexMin = indexMin;
    }

    public double getIndexMax() {
        return indexMax;
    }

    public void setIndexMax(double indexMax) {
        this.indexMax = indexMax;
    }
    private String date;

    public ModelCompany() {
    }    
    

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getIndex() {
        return indexMin;
    }

    public void setIndex(double index) {
        this.indexMin = index;
    }

    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
