package com.geektrust.backend.Services.LoanServiceFolder;

import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.LoanDetails;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.utils.Calculations;

public class loanService implements IloanService {
    private IloanRepository loanRepository;
    public loanService(IloanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    // LOAN BANK_NAME BORROWER_NAME PRINCIPAL NO_OF_YEARS RATE_OF_INTEREST
    public Loan getLoan(String bankName, String borrowerName, Integer principalAmount, Integer loanTenure,
            Integer rateOfInterest) {

            Integer interestAmount = Calculations.calculateInterestAmount(principalAmount,loanTenure,rateOfInterest);
            Integer total_amount = interestAmount + principalAmount;
            Integer noOfEmis = Calculations.calculateNoOfEmis(loanTenure);
            Integer monthlyEmi = Calculations.calculateEmi( total_amount, noOfEmis);
            

            Loan loan =loanRepository.save(new Loan(bankName, borrowerName, principalAmount,loanTenure,rateOfInterest));
            LoanDetails loanDetails = new LoanDetails(total_amount, monthlyEmi, noOfEmis, interestAmount);
            loan.setLoanDetails(loanDetails);
     
          return loan;     
    }

}
