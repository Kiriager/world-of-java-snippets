public class App {
  public static void main(String[] args) throws Exception {
    int x = 10;
    int y = 0;

    // Код, що зупинив би виконання програми:
    // System.out.println(x / y);

    // Код, що перехоплює помилку
    try {
      System.out.println(x / y);
    } catch (Exception e) {
      // виводимо інформацію про помилку
      System.err.println(e); 
      // виводимо також інформацію про те, де виникла помилка
      e.printStackTrace(); 
    }

    System.out.println("Final code line is here!");
  }
}
