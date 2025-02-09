public class Bank implements Runnable {
        private Account account;

        public Bank(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                account.subtractAmount(1000);  // Bank subtracting Rs 1000, 100 times
                System.out.println("Bank: Subtracted Rs 1000. Current Balance: " + account.getBalance());
            }
        }
    }

