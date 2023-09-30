public class App {
  public static void main(String[] args) {
    Table myTable = new Table(4, "square");
    Desk myDesk = new Desk(4, "rectangular", 5);
   
    System.out.println("Ususal table: ");
    myTable.careStuff("fruits");

    System.out.println("\nDesk: ");
    myDesk.careStuff("laptop");
    myDesk.storeStuff("papers");

    ComputerTable myComputerTable = new ComputerTable(6, 
        "oval", 5);
    System.out.println("\nComputer table: ");
    myComputerTable.careStuff("laptop and books");

  }
}
