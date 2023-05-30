package com.geektrust.backend.Commands;

import java.util.List;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Services.PaymentServiceFolder.IpaymentService;

public class loanPaymentCommand implements Icommand {

    private IpaymentService paymentService;

    public loanPaymentCommand(IpaymentService paymentService) {
        this.paymentService =paymentService;
    }

    @Override
    public void execute(List<String> tokens) {
        // PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO

        //TODO
        //try catch and magic num

        String bankName = tokens.get(Constants.ONE);
        String borrowerName = tokens.get(Constants.TWO);
        Integer lumSumAmount = Integer.parseInt(tokens.get(Constants.THREE));
        Integer emiNo = Integer.parseInt(tokens.get(Constants.FOUR));
        try{
            paymentService.makeLoanPayment(bankName,borrowerName,lumSumAmount,emiNo);

        }catch(RuntimeException e){
            System.out.println(e.getMessage());

        }

        
    }

   
    
}
