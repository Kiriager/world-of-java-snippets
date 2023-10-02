public class Example {
  public static void main(String[] args) throws Exception {
    try {
      int x = 10;
      System.out.println(x / 0);
    } catch (Exception e) {
      System.err.println(e);
    }
    // int x = 10;
    // System.out.println(x / 0);
    System.out.println("Final code line is here!");
  }
}
