
public class Account {

        private double balance;

        // Getter and setter
        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        // Synchronized method for adding amount
        public synchronized void addAmount(double amount) {
            balance += amount;
        }

        // Synchronized method for subtracting amount
        public synchronized void subtractAmount(double amount) {
            balance -= amount;
        }
    }
