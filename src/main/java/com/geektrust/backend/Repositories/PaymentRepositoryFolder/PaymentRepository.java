package com.geektrust.backend.Repositories.PaymentRepositoryFolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.geektrust.backend.Entities.Payment;

public class PaymentRepository implements IpaymentRespository {
    private Map<Integer,Payment>paymentMap;
    
    public PaymentRepository() {
        this.paymentMap = new HashMap<>();
    }

    @Override
    public List<Payment> findAll() {
        return paymentMap.values().stream().collect(Collectors.toList());
    }
    @Override
    public Payment findById(Integer loanId) {
        return paymentMap.get(loanId);
    }

    @Override
    public boolean existsById(Integer loanId) {
        return paymentMap.containsKey(loanId);
    }

    @Override
    public void save(Integer loanId, Payment payment) {
        paymentMap.put(loanId,payment);
        
    }

    
}
