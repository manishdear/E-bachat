package com.wordpress.uniquecoder.hackathon;

public class Gstr3_data {

    String gstin, bussiness_name, for_year, return_period;
    String dueDate;

    public Gstr3_data() {
    }

    public Gstr3_data(String gstin, String bussiness_name, String for_year, String return_period, String dueDate) {
        this.gstin = gstin;
        this.bussiness_name = bussiness_name;
        this.for_year = for_year;
        this.return_period = return_period;
//        this._status = _status;
        this.dueDate = dueDate;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getBussiness_name() {
        return bussiness_name;
    }

    public void setBussiness_name(String bussiness_name) {
        this.bussiness_name = bussiness_name;
    }

    public String getFor_year() {
        return for_year;
    }

    public void setFor_year(String for_year) {
        this.for_year = for_year;
    }

    public String getReturn_period() {
        return return_period;
    }

    public void setReturn_period(String return_period) {
        this.return_period = return_period;
    }

//    public String get_status() {
//        return _status;
//    }
//
//    public void set_status(String _status) {
//        this._status = _status;
//    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }
}
