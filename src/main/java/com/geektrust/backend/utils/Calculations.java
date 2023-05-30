package com.geektrust.backend.utils;

import com.geektrust.backend.Constants.Constants;

public class Calculations {
    private static final Integer noOfMonthsInAYear =Constants.TWELVE;
    
    public static Integer calculateEmi(Integer totalAmount,Integer noOfEmis){
        Integer emiModuloForMonthlyEmi = (totalAmount%noOfEmis);
        return (emiModuloForMonthlyEmi>Constants.ZERO)?(totalAmount/noOfEmis)+Constants.ONE:(totalAmount/noOfEmis);
    }

    
    public static  Integer calculateInterestAmount(Integer principal_amount,Integer tenure,Integer interestPercent){
        Integer interestAmountModulo =  (principal_amount*tenure*interestPercent)%Constants.HUNDRED;
        return (interestAmountModulo>Constants.ZERO)?((principal_amount*tenure*interestPercent)/Constants.HUNDRED)+Constants.ONE:((principal_amount*tenure*interestPercent)/Constants.HUNDRED);
    }


    public static Integer calculateNoOfEmiLeft(Integer totalAmount,Integer amountPaidTillNow,Integer monthlyEmi){
        Integer emiModulo = (totalAmount-amountPaidTillNow)%monthlyEmi;
        return(emiModulo>Constants.ZERO)?((totalAmount-amountPaidTillNow)/monthlyEmi)+Constants.ONE:(totalAmount-amountPaidTillNow)/monthlyEmi;
    }

    public static Integer calculateNoOfEmis(Integer tenure ){
        return tenure*noOfMonthsInAYear;
    }

}
