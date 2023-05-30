package com.geektrust.backend.Entities;

import java.util.ArrayList;
import java.util.List;

public class Bank extends BaseEntity{

    private final String bankName;
    private List<Borrower>borrowerList;

    /* adding the bank class by looking at future perspective when Marketplace a service can include/add banks into their services. 
 * Eg: marketPlace.add(new Bank());
*/

    public Bank(String bankName) {
        this.bankName = bankName;
        this.borrowerList = new ArrayList<Borrower>();
    }
    public Bank(String bankName, List<Borrower> borrowerList) {
        this.bankName = bankName;
        this.borrowerList = borrowerList;
    }

    public String getBankName() {
        return bankName;
    }
    public List<Borrower> getBorrowerList() {
        return borrowerList;
    }
    public void setBorrower(Borrower borrower) {
        if(borrower!=null){
        this.borrowerList.add(borrower);
        }
    }

   
    @Override
    public String toString() {
        return "Bank [bankName=" + bankName + ", borrowerList=" + borrowerList + "]";
    }

   
    
    
}
