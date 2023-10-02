public class App {
  public static void main(String[] args) {
    User user = new User("Jane", "Doe", "someemail@gmail.com");
    user.printInfo();

    Employee employee = new Employee("example@email.com");
    employee.setFirstName("John");
    employee.setLastName("Doe");
    employee.setSpecialty("manager");

    employee.setSalalry(6000);
    employee.raiseSalary(20);
    
    employee.printInfo();
    System.out.println("Annual salary: " + employee.getAnnualSalary() + "UAH");

    Customer customer = new Customer("customer@gmail.com");
    customer.setFirstName("Jack");
    customer.setLastName("Doe");
    customer.debit(500);
    customer.credit(200);
    customer.credit(400);
    customer.printInfo();

  }
}

