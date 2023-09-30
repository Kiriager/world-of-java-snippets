public class Table {
  private int legsNumber;
  private String topShape;

  public Table(int legsNumber, String topShape) {
    this.legsNumber = legsNumber;
    this.topShape = topShape;
  }

  public void careStuff(String stuff) {
    System.out.println("I'm holding " + stuff + " on my " + topShape + " top.");
  }

  public int getLegsNumber() {
    return legsNumber;
  }

  public String getTopShape() {
    return topShape;
  }
}


