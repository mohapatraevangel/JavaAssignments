public class Company implements Runnable {
    private Account account;

    public Company(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000);  // Company depositing Rs 1000, 100 times
            System.out.println("Company: Deposited Rs 1000. Current Balance: " + account.getBalance());
        }
    }
}
