package com.geektrust.backend.RepositoryTest;

import java.util.List;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.LoanRepository;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;
import com.geektrust.backend.Services.LoanServiceFolder.loanService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Repository Unit test")
public class loanRepositoryTest {
    @Test
    @DisplayName("LoanRepository Save method Test")
    public void loanRepositorySaveAndMethodTest(){
        IloanRepository loanRepository = new LoanRepository();
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        String principalAmount =  "5000";
        String  tenure = "1";
        String interestPercentage = "4";
        
        Loan expectedLoan = new Loan(1, BankName, borrowerName, Integer.parseInt(principalAmount), Integer.parseInt(tenure), Integer.parseInt(interestPercentage));
        loanRepository.save(expectedLoan);

        Loan loan = loanRepository.findById(expectedLoan.getId());
        boolean ans = expectedLoan.equals(loan);

        Assertions.assertTrue(ans);
        

    }

    @Test
    @DisplayName("Loan Repository findByNames method test")
    public void loanRepositoryFindByNamesMethodTest(){
        IloanRepository loanRepository = new LoanRepository();
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        String principalAmount =  "8000";
        String  tenure = "1";
        String interestPercentage = "4";
        
        Loan expectedLoan = new Loan(1, BankName, borrowerName, Integer.parseInt(principalAmount), Integer.parseInt(tenure), Integer.parseInt(interestPercentage));
        loanRepository.save(expectedLoan);

        Loan actualLoan = loanRepository.findLoanByNames(expectedLoan.getBankName(), expectedLoan.getBorrowerName());

        Assertions.assertEquals(expectedLoan, actualLoan);


    }

    @Test
    @DisplayName("Loan Repository findIfLoanExist method test")
    public void loanRepositoryFindIfLoanExistTest(){
        IloanRepository loanRepository = new LoanRepository();
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        String principalAmount =  "8000";
        String  tenure = "1";
        String interestPercentage = "4";
        
        Loan expectedLoan = new Loan(1, BankName, borrowerName, Integer.parseInt(principalAmount), Integer.parseInt(tenure), Integer.parseInt(interestPercentage));
        loanRepository.save(expectedLoan);


        Assertions.assertTrue(loanRepository.loanExistByNames(expectedLoan.getBankName(), expectedLoan.getBorrowerName()));


    }
    @Test
    @DisplayName("Loan Repository findById method test")
    public void loanRepositoryFindById(){
        IloanRepository loanRepository = new LoanRepository();
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        String principalAmount =  "8000";
        String  tenure = "1";
        String interestPercentage = "4";
        
        Loan expectedLoan = new Loan(1, BankName, borrowerName, Integer.parseInt(principalAmount), Integer.parseInt(tenure), Integer.parseInt(interestPercentage));  loanRepository.save(expectedLoan);

        Loan loan  = loanRepository.findById(1);

        Assertions.assertEquals(expectedLoan, loan);

    }

    @Test
    @DisplayName("Loan Repository findAllmethod test")
    public void loanRepositoryFindAllMethodtTest(){
        IloanRepository loanRepository = new LoanRepository();
        IloanService loanservice = new loanService(loanRepository);
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        Integer principalAmount = 8000;
        Integer  tenure = 1;
       Integer interestPercentage = 4;
        Loan loan1 = loanservice.getLoan(BankName, borrowerName, principalAmount, tenure, interestPercentage);
        Loan loan2 = loanservice.getLoan("ICICI", "NEHA", 10000, 5, 4);

        List<Loan>ans  = loanRepository.findAll();
        int expectedAnswer =2;
        Assertions.assertEquals(expectedAnswer,ans.size());


    }

    
}
