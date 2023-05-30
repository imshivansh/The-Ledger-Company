package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;

public class loanCommand implements Icommand{

    private IloanService loanService;

    public loanCommand(IloanService loanService) {
        this.loanService =loanService;
    }

    @Override
    public void execute(List<String> tokens) {

     // LOAN BANK_NAME BORROWER_NAME PRINCIPAL_AMOUNT LOAN_TENURE LOAN_INTEREST_RATE
     //TODO
     //apply try catch and remove magic numbers

//
        String bankName = tokens.get(Constants.ONE);
        String borrowerName = tokens.get(Constants.TWO);
        Integer principleAmount = Integer.parseInt(tokens.get(Constants.THREE));
        Integer loanTenure = Integer.parseInt(tokens.get(Constants.FOUR));
        Integer loanInterestPercent = Integer.parseInt(tokens.get(Constants.FIVE));
        try{
             loanService.getLoan(bankName,borrowerName,principleAmount,loanTenure,loanInterestPercent);
        }catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }

   
    
}
