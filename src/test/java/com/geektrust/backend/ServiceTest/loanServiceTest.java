package com.geektrust.backend.ServiceTest;

import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.LoanDetails;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.LoanRepository;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;
import com.geektrust.backend.Services.LoanServiceFolder.loanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName(" Service Unit Test")
public class loanServiceTest {
    @Test
    @DisplayName("LoanService method Test")
    public void LoanServiceGetLoanTest(){
        IloanRepository loanRepository = new LoanRepository();
        IloanService loanService= new loanService(loanRepository);
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        Integer principalAmount =  5000;
        Integer tenure = 1;
        Integer interestPercentage = 4;
        Loan loan = loanService.getLoan(BankName, borrowerName, principalAmount, tenure, interestPercentage);
        Loan expectedLoan = new Loan(1, BankName, borrowerName, principalAmount, tenure,interestPercentage);
        Assertions.assertEquals(expectedLoan.getId(),loan.getId());  
        
    }

    @Test
    @DisplayName("LoanService Calculate Monthly EMI test")
    public void LoanServiceCalculateMonthlyEMiTest(){

        IloanRepository loanRepository = new LoanRepository();
        IloanService loanService= new loanService(loanRepository);
        loanService loanService2 = new loanService(loanRepository);
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        Integer principalAmount =  5000;
        Integer  tenure = 1;
        Integer interestPercentage = 4;
        Loan loan = loanService.getLoan(BankName, borrowerName, principalAmount, tenure, interestPercentage);
        LoanDetails loanDetails = new LoanDetails(5200, 434, 12, 200);

    


        Assertions.assertEquals(loan.getLoanDetails().getMonthlyEmi(),loanDetails.getMonthlyEmi());  
        
    }
    
}
