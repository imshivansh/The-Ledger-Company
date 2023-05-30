package com.geektrust.backend.Services.BalanceServiceFolder;

public interface IbalanceService {

    void showBalance(String string, String string2, Integer emiNo);
    void updateBalanceDetailsForLumSumPayment( Integer loanId,Integer emiNoOfThePayment, Integer amountToBePaid);
    
    
}
