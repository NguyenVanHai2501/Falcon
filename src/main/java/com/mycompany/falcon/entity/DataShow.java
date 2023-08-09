/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.falcon.entity;

/**
 *
 * @author hainguyen
 */

public class DataShow {
    private String date;
    private String breakFilter;
    private int impression;

    public DataShow(String date, String breakFilter, int impression) {
        this.date = date;
        this.breakFilter = breakFilter;
        this.impression = impression;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBreakFilter() {
        return breakFilter;
    }

    public void setBreakFilter(String breakFilter) {
        this.breakFilter = breakFilter;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }

    @Override
    public String toString() {
        return "DataShow{" + "date=" + date + ", breakFilter=" + breakFilter + ", impression=" + impression + '}';
    }
    
}

