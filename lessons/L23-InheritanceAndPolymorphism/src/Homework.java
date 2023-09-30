public class Homework {
  private static final int ARROW_LENGTH = 5;
  
  public static void main(String[] args) {
    printArrow();
    printArrow();
    printArrow();
  }

  private static void printArrow() {
    for (int i = 0; i < ARROW_LENGTH; i++) {
      System.out.print("-");
    }
    System.out.println(">");
  }
  
}
