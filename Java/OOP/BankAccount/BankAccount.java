public class BankAccount {
    // MEMBER VARIABLES
    private double checkingBalance;
    private double savingsBalance;
    public static int accounts = 0;
    public static double totalMoney = 0; // refers to the sum of all bank account checking and savings balances
    // CONSTRUCTOR
    public BankAccount (){
        this.checkingBalance = 0;
        this.savingsBalance = 0;
        BankAccount.accounts++;
    }
    // Be sure to increment the number of accounts
    // GETTERS
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    // for checking, savings, accounts, and totalMoney
    // METHODS
    // deposit
    // - users should be able to deposit money into their checking or savings account
    public void depositIntoBalance(double amount, String account){
        if (account == "checking"){
            this.checkingBalance += amount;
            System.out.println(this.checkingBalance);
        }
        else {
            this.savingsBalance += amount;
            System.out.println(this.savingsBalance);
        }
        BankAccount.totalMoney += amount;
        System.out.println(BankAccount.totalMoney);
    }
    // withdraw 
    // - users should be able to withdraw money from their checking or savings account
    // - do not allow them to withdraw money if there are insufficient funds
    // - all deposits and withdrawals should affect totalMoney
    public void withdrawFromBalance(double amount, String account){
        if (account == "checking"){
            if (this.checkingBalance >= amount){
                this.checkingBalance -= amount;
                BankAccount.totalMoney -= amount;
            }
            else {
                System.out.println("Can not be withdrwan, insufficient fund.");
            }
            System.out.println(this.checkingBalance);
        }
        else {
            if (this.savingsBalance >= amount){
                this.savingsBalance -= amount;
                BankAccount.totalMoney -= amount;
            }
            else {
                System.out.println("Can not be withdrwan, insufficient fund.");
            }
            System.out.println(this.savingsBalance);
        }
        System.out.println(BankAccount.totalMoney);
    }
    // getBalance
    // - display total balance for checking and savings of a particular bank account
}
