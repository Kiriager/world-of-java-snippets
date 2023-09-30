public class App {
  public static void main(String[] args) {
    Container myContainer = new Container(6000);
    System.out.println(myContainer.getContainerVolume());

    myContainer  = new Container(200);
    System.out.println(myContainer.getContainerVolume());

    myContainer.fill(1000);
    myContainer.spend(100);
    System.out.println(myContainer.getContentsVolume());

    myContainer.spend(500);
    System.out.println(myContainer.getContentsVolume());
  }
}


