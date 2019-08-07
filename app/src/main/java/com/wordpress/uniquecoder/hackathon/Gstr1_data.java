package com.wordpress.uniquecoder.hackathon;

public class Gstr1_data {

    String gstin ,legal_name , trade_name , for_year , return_period ;
    String dueDate , previous_year , month;

    public Gstr1_data() {
    }

    public Gstr1_data(String gstin, String legal_name, String trade_name,
                      String for_year, String return_period,
                      String dueDate, String previous_year, String month) {
        this.gstin = gstin;
        this.legal_name = legal_name;
        this.trade_name = trade_name;
        this.for_year = for_year;
        this.return_period = return_period;
//        this.status = status;
        this.dueDate = dueDate;
        this.previous_year = previous_year;
        this.month = month;
    }

    public String getGstin() {
        return gstin;
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
    }

    public String getLegal_name() {
        return legal_name;
    }

    public void setLegal_name(String legal_name) {
        this.legal_name = legal_name;
    }

    public String getTrade_name() {
        return trade_name;
    }

    public void setTrade_name(String trade_name) {
        this.trade_name = trade_name;
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

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPrevious_year() {
        return previous_year;
    }

    public void setPrevious_year(String previous_year) {
        this.previous_year = previous_year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
