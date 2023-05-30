package com.geektrust.backend.Services.PaymentServiceFolder;

import java.util.HashMap;
import java.util.Map;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.LoanDetails;
import com.geektrust.backend.Entities.Payment;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.IbalanceRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.PaymentRepositoryFolder.IpaymentRespository;
import com.geektrust.backend.Repositories.PaymentRepositoryFolder.PaymentRepository;
import com.geektrust.backend.Services.BalanceServiceFolder.*;
import com.geektrust.backend.Services.BalanceServiceFolder.IbalanceService;

public class paymentService implements IpaymentService {
    private final IloanRepository loanRepository;
    private final IbalanceRepository balanceRepository;
    private final IpaymentRespository paymentRepository;
    private final IbalanceService balanceService;

    public paymentService(IloanRepository loanRepository,IbalanceRepository balanceRepository) {
        this.loanRepository = loanRepository;
        this.balanceRepository = balanceRepository;
        this.paymentRepository = new PaymentRepository();
        this.balanceService = new balanceService(loanRepository,balanceRepository);
    }
    // PAYMENT BANK_NAME BORROWER_NAME LUMP_SUM_AMOUNT EMI_NO

    @Override
    public Payment makeLoanPayment(String bankName, String borrowerName, Integer amountBeingPaid, Integer  emiNoOfThePayment)throws RuntimeException {
       boolean loanExist = loanRepository.loanExistByNames(bankName, borrowerName);
           if(loanExist){
            Payment payment = fetchLoanAndMakePayment(bankName,borrowerName,amountBeingPaid,emiNoOfThePayment);
            return payment;
            }
            else{
                  throw new RuntimeException("Loan account could not be found");
          }

    }

    private Payment fetchLoanAndMakePayment(String bankName, String borrowerName,
            Integer amountBeingPaid, Integer emiNoOfThePayment) {
            Loan loan = loanRepository.findLoanByNames(bankName, borrowerName);
            LoanDetails loanDetails = loan.getLoanDetails();
                 if(amountBeingPaid>loanDetails.getMonthlyEmi()){
                  balanceService.updateBalanceDetailsForLumSumPayment(loan.getId(),emiNoOfThePayment,amountBeingPaid);
                  Map<Integer,Integer>paymentMap = new HashMap<>();
                  paymentMap.put(emiNoOfThePayment,amountBeingPaid);
                  Payment payment = new Payment(paymentMap);
                  paymentRepository.save(loan.getId(),payment);
                  return payment;
                }else{
                   Map<Integer,Integer>paymentMap = new HashMap<>();
                   paymentMap.put(loan.getId(),amountBeingPaid);
                   Payment payment = new Payment(paymentMap);
                   paymentRepository.save(loan.getId(),payment);
                   return payment;
                  }  
          }

 }

