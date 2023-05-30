package com.geektrust.backend.Services.LoanServiceFolder;

import com.geektrust.backend.Entities.Loan;

public interface IloanService {

    Loan getLoan(String string, String string2, Integer principleAmount, Integer loanTenure, Integer loanInterestPercent);
    
}
