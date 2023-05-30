package com.geektrust.backend.EntitiesTest;

import com.geektrust.backend.Entities.Bank;
import com.geektrust.backend.Entities.Borrower;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Bank entity Test")
public class BankTest {
  

    @Test
    @DisplayName("Bank entity  test")
    public void bankEntityTest(){
        String name = "SBI";
        Bank bank =  new Bank(name);
        bank.setBorrower(new Borrower("Shivansh"));
        //we have added a Borrower to the Bank entity and now the borrower list size should be 1
        // Borrower expectedAnswer = bank.getBorrowerList().stream().findAny(c->c.getAccountHolderName().equals("Shivansh"));

        Assertions.assertEquals(1,bank.getBorrowerList().size());
        
    }

  
}
