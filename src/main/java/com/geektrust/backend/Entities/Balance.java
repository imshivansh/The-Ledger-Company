package com.geektrust.backend.Entities;

import java.util.Map;

public class Balance {

    private  boolean isAnyPaymentDoneBefore;
    private Map<Integer,Integer>lumSumPaymentHistory; // for each emi no lumsumamount paid..

    public Balance(boolean isAnyPaymentDoneBefore, Map<Integer, Integer> lumSumPaymentHistory) {
        this.isAnyPaymentDoneBefore = isAnyPaymentDoneBefore;
        this.lumSumPaymentHistory = lumSumPaymentHistory;
    }


    public boolean isAnyPaymentDoneBefore() {
        return isAnyPaymentDoneBefore;
    }
    
    public void setAnyPaymentDoneBefore(boolean isAnyPaymentDoneBefore) {
        if(this.isAnyPaymentDoneBefore==false){
        this.isAnyPaymentDoneBefore = isAnyPaymentDoneBefore;
        }
    }


    public Map<Integer, Integer> getLumSumPaymentHistory() {
        return lumSumPaymentHistory;
    }

    public void setLumSumPaymentHistory(Map<Integer, Integer> lumSumPaymentHistory) {
        if(this.lumSumPaymentHistory.size()!=0){
            this.lumSumPaymentHistory = lumSumPaymentHistory;
        }
  
}
}
