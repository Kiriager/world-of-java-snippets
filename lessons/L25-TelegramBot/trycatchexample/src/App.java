public class App {
  public static void main(String[] args) throws Exception {
    int x = 10;
    int y = 0;

    // Code that breaks the programm:
    // System.out.println(x / y);

    // Code that handles the error
    try {
      System.out.println(x / y);
    } catch (Exception e) {
      System.err.println(e);
      e.printStackTrace();
    }

    // System.out.println(x / 0);
    System.out.println("Final code line is here!");
  }
}
