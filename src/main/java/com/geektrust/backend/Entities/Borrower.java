package com.geektrust.backend.Entities;

import java.util.ArrayList;
import java.util.List;
/* creating Borrower Account with the refrence of Marketplace by assuming that the borrower may have different loan from different Bank accounts */
// for current needs it is not required.
public class Borrower extends BaseEntity {
    private final String accountHolderName;
    private List<Bank>bankAccounts;
    private List<Loan>noOfLoans;

    public Borrower(String accountHolderName, List<Bank> bankAccounts, List<Loan> noOfLoans) {
        this(accountHolderName,bankAccounts);
        this.noOfLoans = noOfLoans;
    }
    public Borrower (String accountHolderName,List<Bank>bankAccounts){
        this(accountHolderName);
        this.bankAccounts=bankAccounts;
    }
    public Borrower(String accountHolderName){
        this.accountHolderName=accountHolderName;
        this.bankAccounts = new ArrayList<Bank>();
        this.noOfLoans =  new ArrayList<>();
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
    public List<Bank> getBankAccounts() {
        return bankAccounts;
    }
    public void setBankAccount(Bank bankAccount) {
        if(bankAccount!=null){
        this.bankAccounts.add(bankAccount);
        }
    }
    public List<Loan> getNoOfLoans() {
        return noOfLoans;
    }
    public void setNoOfLoans(Loan loan) {
        if(loan!=null){
        this.noOfLoans.add(loan);
        }
    }
  
    @Override
    public String toString() {
        return "Borrower [accountHolderName=" + accountHolderName + ", bankAccounts=" + bankAccounts
                + ", noOfLoans=" + noOfLoans + "]";
    }



    

    
}
