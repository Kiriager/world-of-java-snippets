public class ComputerTable extends Table {
  private int shelvesNumber;

  public ComputerTable(int legsNumber, String topShape, int shelvesNumber) {
    super(legsNumber, topShape);
    this.shelvesNumber = shelvesNumber;
  }

  public int getShelvesNumber() {
    return shelvesNumber;
  }

  public void setShelvesNumber(int shelvesNumber) {
    this.shelvesNumber = shelvesNumber;
  } 

  @Override
  public void careStuff(String stuff) {
    System.out.println("I'm holding " + stuff + " on my " + getTopShape() 
        + " top and on my shelves.");
  }
}

