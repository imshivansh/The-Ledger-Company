package com.geektrust.backend.Entities;


public class Loan extends BaseEntity {
   
    private final String bankName;
    private final String borrowerName;
    private final Integer principalAmount;
    private final Integer loanTenure;
    private final Integer interestPercentage;
    private LoanDetails loanDetails;

   
    public Loan(Integer id,String bankName, String borrowerName, Integer principalAmount, Integer loanTenure,
    Integer interestPercentage) {
            this(bankName,borrowerName,principalAmount,loanTenure,interestPercentage);
            this.id= id;

           }

           public Loan(String bankName, String borrowerName, Integer principalAmount, Integer loanTenure,
           Integer interestPercentage) {
                   this.bankName = bankName;
                   this.borrowerName = borrowerName;
                   this.principalAmount = principalAmount;
                   this.loanTenure = loanTenure;
                   this.interestPercentage = interestPercentage;
                }
        public String getBankName() {
            return bankName;
        }
        public String getBorrowerName() {
            return borrowerName;
        }
        public Integer getPrincipalAmount() {
            return principalAmount;
        }
        public Integer getLoanTenure() {
            return loanTenure;
        }
        
        public Integer getInterestPercentage() {
            return interestPercentage;
        }

        public LoanDetails getLoanDetails() {
            return loanDetails;
        }

        public void setLoanDetails(LoanDetails loanDetails) {
            if(loanDetails!=null){
            this.loanDetails = loanDetails;
            }
        }
        
    
}
