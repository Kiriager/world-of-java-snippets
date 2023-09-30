public class Desk extends Table {
  private int drawersNumber;

  public Desk(int legsNumber, String topShape, int drawersNumber) {
    super(legsNumber, topShape);
    this.drawersNumber = drawersNumber;
  }

  public void storeStuff(String stuff) {
    System.out.println("I'm storing " + stuff + " in my " 
        + drawersNumber + " drawers.");
  }
}

