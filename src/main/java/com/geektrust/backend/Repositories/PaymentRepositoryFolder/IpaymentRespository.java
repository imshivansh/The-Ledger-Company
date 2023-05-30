package com.geektrust.backend.Repositories.PaymentRepositoryFolder;

import com.geektrust.backend.Entities.Payment;
import com.geektrust.backend.Repositories.CRUDRepository;

public interface IpaymentRespository extends CRUDRepository<Payment,Integer> {

    void save(Integer loanId, Payment payment);

    
}
