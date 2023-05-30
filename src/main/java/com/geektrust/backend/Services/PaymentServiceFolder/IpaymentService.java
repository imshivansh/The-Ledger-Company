package com.geektrust.backend.Services.PaymentServiceFolder;

import com.geektrust.backend.Entities.Payment;

public interface IpaymentService {

    Payment makeLoanPayment(String string, String string2, Integer lumSumAmount, Integer emiNo);
    
}
