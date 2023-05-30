package com.geektrust.backend;

import com.geektrust.backend.Commands.Icommand;
import com.geektrust.backend.Commands.balanceCommand;
import com.geektrust.backend.Commands.commandInvoker;
import com.geektrust.backend.Commands.loanCommand;
import com.geektrust.backend.Commands.loanPaymentCommand;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.BalanceRepository;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.IbalanceRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.LoanRepository;
import com.geektrust.backend.Services.BalanceServiceFolder.*;
import com.geektrust.backend.Services.BalanceServiceFolder.IbalanceService;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;
import com.geektrust.backend.Services.LoanServiceFolder.loanService;
import com.geektrust.backend.Services.PaymentServiceFolder.IpaymentService;
import com.geektrust.backend.Services.PaymentServiceFolder.paymentService;

public class AppConfiguration {
    //initializing neccessary repository for the user case
    private final IloanRepository loanRepository =  new LoanRepository();
    private final IbalanceRepository balanceRepository =  new BalanceRepository();

    /*intializing services */ 

    private final IloanService loanService = new loanService(loanRepository);
    private final IbalanceService balanceService = new balanceService(loanRepository, balanceRepository);
    private final IpaymentService paymentService = new paymentService(loanRepository, balanceRepository);

   private final  Icommand loanCommand  = new loanCommand(loanService);
    private final Icommand paymentCommand = new loanPaymentCommand(paymentService);
    private final Icommand balanceCommand = new balanceCommand(balanceService);

    private final commandInvoker CommandInvoker =  new  commandInvoker();

    public commandInvoker getCommandInvoker(){
        CommandInvoker.registerCommand("LOAN", loanCommand);
        CommandInvoker.registerCommand("PAYMENT", paymentCommand);
        CommandInvoker.registerCommand("BALANCE",balanceCommand);
        return CommandInvoker;

    }




    
}
