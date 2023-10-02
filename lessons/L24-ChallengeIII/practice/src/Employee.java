public class Employee extends User {
  private static final int MIN_SALARY = 8000;
  private static final int MONTHS_PER_YEAR = 12;

  private String specialty;
  private double salary = MIN_SALARY;

  public Employee(String email) {
    super(email);
  }

  public String getSpecialty() {
    return specialty;
  }

  public void setSpecialty(String specialty) {
    this.specialty = specialty;
  }
  
  public double getSalalry() {
    return salary;
  }

  public double getAnnualSalary() {
    return salary * MONTHS_PER_YEAR;
  }
  
  public void setSalalry(double salary) {
    this.salary = Math.max(salary, MIN_SALARY);
  }

  public void raiseSalary(double percent) {
    salary *= (1 + percent / 100); 
  }

  @Override
  public void printInfo() {
    System.out.println("Employee [" + getFullName() + ", email: " + getEmail() + ", specialty: " 
        + specialty + ", salary: " + salary + " UAH]");
  }
}

