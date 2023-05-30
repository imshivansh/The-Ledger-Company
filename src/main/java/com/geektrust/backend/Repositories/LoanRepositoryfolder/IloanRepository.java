package com.geektrust.backend.Repositories.LoanRepositoryfolder;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Repositories.CRUDRepository;

public interface IloanRepository extends CRUDRepository<Loan,Integer>{
    public Loan save(Loan loan);
    public boolean loanExistByNames(String bankName,String borrowerName);
    public Loan findLoanByNames(String bankName,String borrowerName);

   

    
}
