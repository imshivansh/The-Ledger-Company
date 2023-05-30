package com.geektrust.backend.EntitiesTest;

import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.LoanDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Unit Test")
public class loan {
  
    @Test
    @DisplayName("Loan Entity Test")
    public void creatingLoanEntityTest(){
        Integer id =1;
        String BankName = "ICICI";
        String borrowerName = "Shivansh";
        Integer  principalAmount =  8000;
        Integer tenure = 5;
        Integer interestPercentage = 4;

        Loan expectedOutput = new Loan(id, BankName, borrowerName, principalAmount, tenure, interestPercentage);

Assertions.assertEquals(1,expectedOutput.getId());
    }



    
}
