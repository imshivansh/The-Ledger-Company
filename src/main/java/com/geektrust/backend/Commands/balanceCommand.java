package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Services.BalanceServiceFolder.IbalanceService;

public class balanceCommand implements Icommand{
   private IbalanceService balanceService;

    public balanceCommand(IbalanceService balanceService) {
        this.balanceService = balanceService;
    }
    // BALANCE BANK_NAME BORROWER_NAME EMI_NO

    @Override
    public void execute(List<String> tokens) {
         String bankName = tokens.get(Constants.ONE);
         String borrowerName = tokens.get(Constants.TWO);
         Integer emiNo = Integer.parseInt(tokens.get(Constants.THREE));

        try{
            balanceService.showBalance(bankName,borrowerName,emiNo);

        }catch(RuntimeException e){
            System.out.println(e.getMessage());

        }
        
    }

   
}
