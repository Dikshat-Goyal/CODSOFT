public class ATM_INTERFACE_Task3 {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // initial balance of $1000
        ATM atm = new ATM(account);
        atm.run();
    }
}
