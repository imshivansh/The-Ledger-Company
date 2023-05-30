package com.geektrust.backend.Repositories.BalanceRepositoryFolder;

import com.geektrust.backend.Entities.Balance;
import com.geektrust.backend.Repositories.CRUDRepository;

public interface IbalanceRepository extends CRUDRepository<Balance,Integer> {
    public Balance saveBalanceForLumsumPayment(Integer loanId,Balance balance);
    
}
