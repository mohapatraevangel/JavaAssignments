
public class Main{
    public static void main(String[] args) {
        // Create a shared Account object
        Account account = new Account();

        // Create the Bank and Company objects
        Bank bank = new Bank(account);
        Company company = new Company(account);

        // Create threads for Bank and Company
        Thread bankThread = new Thread(bank);
        Thread companyThread = new Thread(company);

        // Start the threads
        bankThread.start();
        companyThread.start();

        try {
            // Wait for both threads to finish
            bankThread.join();
            companyThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Final balance
        System.out.println("Final Balance: " + account.getBalance());
    }
}