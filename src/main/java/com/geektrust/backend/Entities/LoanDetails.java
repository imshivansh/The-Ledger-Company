package com.geektrust.backend.Entities;
public class LoanDetails {
    private final Integer totalAmountToBePaid;
    private final Integer interestAmount;
    private Integer monthlyEmi;
    private Integer noOfEmi;
    

   
    public LoanDetails( Integer totalAmountToBePaid, Integer monthlyEmi,
    Integer noOfEmi, Integer interestAmount) {
        this.totalAmountToBePaid = totalAmountToBePaid;
        this.monthlyEmi = monthlyEmi;
        this.noOfEmi = noOfEmi;
        this.interestAmount=interestAmount;
    }
    
    public Integer getInterestAmount() {
        return interestAmount;
    }
    public Integer getTotalAmountToBePaid() {
        return totalAmountToBePaid;
    }
  
    public Integer getMonthlyEmi() {
        return monthlyEmi;
    }
    public void setMonthlyEmi(Integer monthlyEmi) {
        if(monthlyEmi>0){
        this.monthlyEmi = monthlyEmi;
        }
    }
    public Integer getNoOfEmi() {
        return noOfEmi;
    }
    public void setNoOfEmi(Integer noOfEmi) {
        if(noOfEmi<this.noOfEmi && noOfEmi>0){
        this.noOfEmi = noOfEmi;
        }
    }




    
}
