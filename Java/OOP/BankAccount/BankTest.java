public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney
        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney

        BankAccount account1 = new BankAccount();
        account1.depositIntoBalance(100,"checking");
        account1.depositIntoBalance(50,"savings");
        account1.withdrawFromBalance(50,"checking");
        account1.withdrawFromBalance(25,"savings");
        account1.withdrawFromBalance(150,"checking"); // to check sufficient amount

        BankAccount account2 = new BankAccount();
        account2.depositIntoBalance(200,"checking");
        account2.depositIntoBalance(100,"savings");
        account2.withdrawFromBalance(100,"checking");
        account2.withdrawFromBalance(50,"savings");

        BankAccount account3 = new BankAccount();
        account3.depositIntoBalance(300,"checking");
        account3.depositIntoBalance(150,"savings");
        account3.withdrawFromBalance(150,"checking");
        account3.withdrawFromBalance(75,"savings");

        // Static Test (print the number of bank accounts and the totalMoney)
        System.out.println(BankAccount.accounts);
        System.out.println(BankAccount.totalMoney);
    }
}
