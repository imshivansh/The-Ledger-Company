package com.geektrust.backend.Repositories.BalanceRepositoryFolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.geektrust.backend.Entities.Balance;

public class BalanceRepository implements IbalanceRepository {
   private  Map<Integer,Balance>balanceMap; //maps balance to a particular loan id;

    public BalanceRepository() {
        this.balanceMap = new HashMap<>();
     }

     @Override
    public Balance saveBalanceForLumsumPayment(Integer loanId,Balance balance){
        balanceMap.put(loanId,balance);
        return balanceMap.get(loanId);

    }
    

    @Override
    public List<Balance> findAll() {
        return balanceMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Balance findById(Integer id) {
        return  balanceMap.get(id);

    }

    @Override
    public boolean existsById(Integer id) {
        // TODO Auto-generated method stub
        return balanceMap.containsKey(id);
    }
    
}
