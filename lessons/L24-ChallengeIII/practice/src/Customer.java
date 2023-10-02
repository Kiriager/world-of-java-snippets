public class Customer extends User {
  private double balance = 0;

  public Customer(String email) {
    super(email);
  }

  public double getBalance() {
    return balance;
  }
  
  public void debit(double amount) {
    balance += amount;
  }

  public void credit(double amount) {
    if (balance >= amount) {
      balance -= amount;
    }
  }

  @Override
  public void printInfo() {
    System.out.println("Customer [" + getFullName() + ", email: " + getEmail() 
        + ", balance: " + balance + " UAH]");
  }
}
