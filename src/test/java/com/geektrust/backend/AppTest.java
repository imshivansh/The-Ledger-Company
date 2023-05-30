package com.geektrust.backend;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import com.geektrust.backend.Commands.commandInvoker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("App Integration Test")
class AppTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void Application_Test() throws Exception{
        String expectedOutput = "IDIDI Dale 3652 4\n"+
        "MBI Harry 9044 10";
        AppConfiguration appConfig = new AppConfiguration();
        commandInvoker CommandInvoker = appConfig.getCommandInvoker();
        List<String>loantoken = new ArrayList<>();
        loantoken.add("LOAN");
        loantoken.add("IDIDI");
        loantoken.add("Dale");
        loantoken.add("5000");
        loantoken.add("1");
        loantoken.add("6");
       

        List<String>paymentLoantaken = new ArrayList<>();
        paymentLoantaken.add("PAYMENT");
        paymentLoantaken.add("IDIDI");
        paymentLoantaken.add("Dale");
        paymentLoantaken.add("1000");
        paymentLoantaken.add("5");

        List<String>balanceLoantoken = new ArrayList<>();
        balanceLoantoken.add("BALANCE");
        balanceLoantoken.add("IDIDI");
        balanceLoantoken.add("Dale");
        balanceLoantoken.add("6");

        //

        List<String>loantoken2 = new ArrayList<>();

        loantoken2.add("LOAN");
        loantoken2.add("MBI");
        loantoken2.add("Harry");
        loantoken2.add("10000");
        loantoken2.add("3");
        loantoken2.add("7");

        List<String>paymentLoantaken2 = new ArrayList<>();
        paymentLoantaken2.add("PAYMENT");
        paymentLoantaken2.add("MBI");
        paymentLoantaken2.add("Harry");
        paymentLoantaken2.add("5000");
        paymentLoantaken2.add("10");


        List<String>balanceLoantaken2 = new ArrayList<>();
        balanceLoantaken2.add("BALANCE");
        balanceLoantaken2.add("MBI");
        balanceLoantaken2.add("Harry");
        balanceLoantaken2.add("12");

     

        CommandInvoker.executeCommand("LOAN", loantoken);
        CommandInvoker.executeCommand("LOAN", loantoken2);

        CommandInvoker.executeCommand("PAYMENT", paymentLoantaken);
        CommandInvoker.executeCommand("PAYMENT", paymentLoantaken2);

        CommandInvoker.executeCommand("BALANCE", balanceLoantoken);
        CommandInvoker.executeCommand("BALANCE", balanceLoantaken2);

        Assertions.assertEquals(expectedOutput,outputStreamCaptor.toString().trim());

    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
