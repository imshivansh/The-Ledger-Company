package com.geektrust.backend.Repositories.LoanRepositoryfolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.geektrust.backend.Constants.Constants;
import com.geektrust.backend.Entities.Loan;

public class LoanRepository implements IloanRepository {
   private  Map<Integer,Loan>loanMap;
    private Integer autoIncrement;
    public LoanRepository() {
        this.loanMap = new HashMap<>();
        autoIncrement=Constants.ZERO;
    }
    
    @Override
    public Loan save(Loan loan) {
            if(loan.getId()==null){
                autoIncrement++;
                Loan newLoan =  new Loan(autoIncrement, loan.getBankName(), loan.getBorrowerName(), loan.getPrincipalAmount(),loan.getLoanTenure(), loan.getInterestPercentage());
                loanMap.put(autoIncrement,newLoan);
                return loanMap.get(autoIncrement);
            }else{
                loanMap.put(loan.getId(),loan);
                return loan;
            }
            
            
        }

    @Override
    public List<Loan> findAll() {
       return loanMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Loan findById(Integer id) throws RuntimeException {
        return  loanMap.get(id);
    }
    public Loan findLoanByNames(String bankName,String borrowerName){
      return loanMap.values().stream().filter(l->l.getBankName().equals(bankName)&& l.getBorrowerName().equals(borrowerName)).findAny().orElse(null);
    
    
    }

    @Override
    public boolean loanExistByNames(String bankName,String borrowerName) {
       return  loanMap.values().stream().anyMatch(l->l.getBankName().equals(bankName)&& l.getBorrowerName().equals(borrowerName));
    }

    @Override
    public boolean existsById(Integer id) {
        return loanMap.containsKey(id);
    }
  
}
