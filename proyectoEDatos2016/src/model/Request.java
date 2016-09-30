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
public class Request {
    
    
    private String companyID;
    private int initialDay;
    private int endDay;
    private int initialMonth;
    private int endMonth;
    private int initialYear;
    private int endYear;
    private String SortMethod;
    private String index;

    public String getCompanyID() {
        return companyID;
    }

    public void setCompanyID(String companyID) {
        this.companyID = companyID;
    }


    public String getSortMethod() {
        return SortMethod;
    }

    public void setSortMethod(String SortMethod) {
        this.SortMethod = SortMethod;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public int getInitialDay() {
        return initialDay;
    }

    public void setInitialDay(int initialDay) {
        this.initialDay = initialDay;
    }

    public int getEndDay() {
        return endDay;
    }

    public void setEndDay(int endDay) {
        this.endDay = endDay;
    }

    public int getInitialMonth() {
        return initialMonth;
    }

    public void setInitialMonth(int initialMonth) {
        this.initialMonth = initialMonth;
    }

    public int getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(int endMonth) {
        this.endMonth = endMonth;
    }

    public int getInitialYear() {
        return initialYear;
    }

    public void setInitialYear(int initialYear) {
        this.initialYear = initialYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

   
    
    
    
}
