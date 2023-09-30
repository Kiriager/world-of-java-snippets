public class Task {
  public static void main(String[] args) {
    CoffeMachine.setBasePrice(26);
    CoffeMachine.setPriceIncrement(7);

    CoffeMachine myMachine = new CoffeMachine(
        500, 700);

    myMachine.loadIngridients(110, 1000);
    myMachine.printState();

    for (int i = 0; i < 5; i++) {
      myMachine.makeCoffee(false, false);
      myMachine.makeCoffee(false, true);
      myMachine.makeCoffee(true, true);
      myMachine.makeCoffee(true, false);
      myMachine.printState();
    }
  }
}


