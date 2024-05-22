public class Main {
    public static void main(String[] args) {
        UserAccount userAccount = new UserAccount(500.00); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
