package com.geektrust.backend.Entities;

import java.util.Map;

public class Payment {
    private Map<Integer,Integer>paymentHistory;
    public Payment(Map<Integer, Integer> paymentHistory) {
        this.paymentHistory = paymentHistory;
    }

    public Map<Integer, Integer> getPaymentHistory() {
        return paymentHistory;
    }
    public void addPayment(Integer emiNo,Integer amountBeingPaid) {
        if(emiNo>0 && amountBeingPaid>0){
        this.paymentHistory.put(emiNo,amountBeingPaid);
        }
    }
 
}
