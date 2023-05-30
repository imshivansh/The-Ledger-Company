package com.geektrust.backend.ServiceTest;
import java.util.List;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Entities.Payment;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.BalanceRepository;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.IbalanceRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.LoanRepository;
import com.geektrust.backend.Repositories.PaymentRepositoryFolder.IpaymentRespository;
import com.geektrust.backend.Repositories.PaymentRepositoryFolder.PaymentRepository;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;
import com.geektrust.backend.Services.LoanServiceFolder.loanService;
import com.geektrust.backend.Services.PaymentServiceFolder.IpaymentService;
import com.geektrust.backend.Services.PaymentServiceFolder.paymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("Service Unit Test")
public class paymentServiceTest {
        @Test
        @DisplayName("PaymentService method Test which makes changes in balance repository for the lumsumPayment")
        public void paymentServiceMakePaymentTest(){
        IloanRepository loanRepository = new LoanRepository();
        IloanService loanService= new loanService(loanRepository);
        IbalanceRepository balanceRepository = new BalanceRepository();
        IpaymentService paymentService = new paymentService(loanRepository, balanceRepository);

        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        Integer principalAmount =  5000;
        Integer  tenure =1;
        Loan loan = loanService.getLoan(BankName, borrowerName, principalAmount, tenure, 4);
         paymentService.makeLoanPayment(loan.getBankName(), loan.getBorrowerName(), 1000, 5);
       Assertions.assertEquals(1,balanceRepository.findAll().size());
        }}
