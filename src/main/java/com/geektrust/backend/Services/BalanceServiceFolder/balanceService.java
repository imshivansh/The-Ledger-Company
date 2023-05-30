package com.geektrust.backend.Services.BalanceServiceFolder;

import java.util.HashMap;
import java.util.Map;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Entities.Balance;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.LoanDetails;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.IbalanceRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.utils.Calculations;

public class balanceService implements IbalanceService{
    private IloanRepository loanRepository;
    private IbalanceRepository balanceRepository;

    public balanceService(IloanRepository loanRepository, IbalanceRepository bIbalanceRepository) {
        this.loanRepository = loanRepository;
        this.balanceRepository= bIbalanceRepository;
    }

    @Override
    public void showBalance(String bankName, String borrowerName,Integer emiNo) throws RuntimeException {
        Loan loan = loanRepository.findLoanByNames(bankName, borrowerName);
        if(loan!=null){
            LoanDetails loanDetails = loan.getLoanDetails();
            Balance balance = balanceRepository.findById(loan.getId());
            Integer totalBalanceToBeShownTillEmiNo = updateTotalBalanceToBeShownTillEmiNo(balance,loanDetails, emiNo);
            Integer noOfEmiLeft = Calculations.calculateNoOfEmiLeft( loanDetails.getTotalAmountToBePaid(), totalBalanceToBeShownTillEmiNo, loanDetails.getMonthlyEmi());
            System.out.println(bankName+" "+borrowerName+" "+totalBalanceToBeShownTillEmiNo.toString()+" "+noOfEmiLeft.toString() );

        }else{
            throw new RuntimeException("Loan Account could not be found for the given borrower and Bank Name");
        }

    }



    private Integer updateTotalBalanceToBeShownTillEmiNo(Balance balance,LoanDetails loanDetails,Integer emiNoOfBalance){
        Integer sumOfLumSumAmountAddedBefore =Constants.ZERO;
        if(balance != null){
            Map<Integer,Integer>lumsumBalanceMap = balance.getLumSumPaymentHistory();
            for(int i =0;i<=emiNoOfBalance;i++){
                sumOfLumSumAmountAddedBefore+=checkIfMapContainsLumSumBalanceTillEmiNo(lumsumBalanceMap,i);
            }
        
        }
         Integer totalBalanceToBeReturned = sumOfLumSumAmountAddedBefore+(emiNoOfBalance*loanDetails.getMonthlyEmi());
         totalBalanceToBeReturned =(totalBalanceToBeReturned>loanDetails.getTotalAmountToBePaid())?loanDetails.getTotalAmountToBePaid():totalBalanceToBeReturned;
        return totalBalanceToBeReturned;

    }

    private Integer checkIfMapContainsLumSumBalanceTillEmiNo(Map<Integer,Integer>lumSumMap,Integer emiNoToBeChecked){
        Integer sumOfLumSumAtGivenEmiNo = Constants.ZERO;
        if(lumSumMap.containsKey(emiNoToBeChecked)){
            sumOfLumSumAtGivenEmiNo=lumSumMap.get(emiNoToBeChecked);
        }
        return sumOfLumSumAtGivenEmiNo;
    }

    

    public void updateBalanceDetailsForLumSumPayment(Integer loanId, Integer emiNoOfThePayment, Integer amountToBePaid) {
                if(balanceRepository.existsById(loanId)){
                    Balance balance = balanceRepository.findById(loanId);
                    Map<Integer,Integer>lumSumAmountMap = balance.getLumSumPaymentHistory();
                    lumSumAmountMap.put(emiNoOfThePayment,amountToBePaid);
                    balance.setLumSumPaymentHistory(lumSumAmountMap);
                    balanceRepository.saveBalanceForLumsumPayment(loanId, balance);
                   }
                   else{
                    Balance balance =new Balance(true, new HashMap(){{put(emiNoOfThePayment,amountToBePaid);}});
                    balanceRepository.saveBalanceForLumsumPayment(loanId, balance);
                      }

    }


 }

    

