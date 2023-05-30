package com.geektrust.backend.ServiceTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.geektrust.backend.Entities.Loan;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.BalanceRepository;
import com.geektrust.backend.Repositories.BalanceRepositoryFolder.IbalanceRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.IloanRepository;
import com.geektrust.backend.Repositories.LoanRepositoryfolder.LoanRepository;
import com.geektrust.backend.Services.BalanceServiceFolder.IbalanceService;
import com.geektrust.backend.Services.BalanceServiceFolder.balanceService;
import com.geektrust.backend.Services.LoanServiceFolder.IloanService;
import com.geektrust.backend.Services.LoanServiceFolder.loanService;
import com.geektrust.backend.Services.PaymentServiceFolder.IpaymentService;
import com.geektrust.backend.Services.PaymentServiceFolder.paymentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
@DisplayName("Service Unit Test")
public class balanceServiceTest {
    
    private  PrintStream standardOut = System.out;
    private  ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private  IloanRepository loanRepository = new LoanRepository();
    private  IbalanceRepository bIbalanceRepository = new BalanceRepository();
    private  IloanService loanService= new loanService(loanRepository);
    private IpaymentService paymentService = new paymentService(loanRepository, bIbalanceRepository);
    private IbalanceService balanceService = new balanceService(loanRepository,bIbalanceRepository);


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    @DisplayName("BalanceService showBalance Integration Test")
    public void balanceServiceShowBalanceTest(){
        Loan loan1 = loanService.getLoan("IDIDI" ,"Dale", 5000,1, 6);
        Loan loan2 =loanService.getLoan( "MBI","Harry", 10000, 3, 7);
        Loan loan3 =loanService.getLoan( "UON","Shelly", 15000, 2, 9);

        paymentService.makeLoanPayment( "IDIDI", "Dale", 1000,5);
        paymentService.makeLoanPayment( "MBI", "Harry", 5000,10);
        paymentService.makeLoanPayment( "UON", "Shelly", 7000,12);




        balanceService.showBalance("IDIDI", "Dale",3);
        balanceService.showBalance("IDIDI", "Dale",6);
        balanceService.showBalance("UON", "Shelly",12);
        balanceService.showBalance("MBI", "Harry",12);



       String expectedOutput="IDIDI Dale 1326 9\n"+"IDIDI Dale 3652 4\n"+"UON Shelly 15856 3\n"+"MBI Harry 9044 10";
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());   
    }


    @Test
    @DisplayName("BalanceService ShowBalanceEdgeCase Test")
    public void balanceServiceShowBalanceEdgeCaseTest(){
        String BankName = "HDFC";
        String borrowerName = "Shivansh";
        Integer principalAmount =  5000;
        Integer  tenure = 1;
        Integer interestPercentage = 6;
        Loan loan = loanService.getLoan(BankName, borrowerName, principalAmount, tenure, interestPercentage);
        paymentService.makeLoanPayment(loan.getBankName(), loan.getBorrowerName(), 1000, 0);
        String expectedOutput = "HDFC Shivansh 1000 10";
        balanceService.showBalance(loan.getBankName(),loan.getBorrowerName(), 0);
        Assertions.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());



        
    }


    
}
