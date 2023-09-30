public class App {
  public static void main(String[] args) {
    CoffeeMachine.setBasePrice(26);
    CoffeeMachine.setPriceIncrement(7);

    CoffeeMachine myMachine = new CoffeeMachine(
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

    myMachine.emptyCassier();
  }
}


