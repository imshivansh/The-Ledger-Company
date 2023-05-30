package com.geektrust.backend.EntitiesTest;

import com.geektrust.backend.Entities.Bank;
import com.geektrust.backend.Entities.Borrower;
import com.geektrust.backend.Entities.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Borrower entity Test")
public class BorrowerTest {

    @Test
    @DisplayName("Borrower entity creation test")
    public void checkBorrowerCreation(){

        Borrower borrower = new Borrower("Shivansh");
        Assertions.assertEquals(borrower.getAccountHolderName(), "Shivansh");

    }

    @Test
    @DisplayName("Borrower Entity Method Check")
    public void checkBorrowerMethods(){
        Borrower borrower = new Borrower("Shivansh");
        borrower.setBankAccount(new Bank("HDFC"));
        borrower.setNoOfLoans(new Loan(1, "SBI", "Shivansh", 1000, 4, 5));

       Bank bank = borrower.getBankAccounts().stream().findAny().get();
       Assertions.assertEquals(bank.getBankName(),"HDFC");

       Loan loan = borrower.getNoOfLoans().stream().findFirst().get();
       Assertions.assertEquals(loan.getBorrowerName(),"Shivansh");
    }

    
}
