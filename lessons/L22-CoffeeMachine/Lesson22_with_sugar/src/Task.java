public class Task {
  public static void main(String[] args) {
    CoffeMachine myMachine = new CoffeMachine(500, 
      500, 500);
    myMachine.loadIngridients(1000, 2000, 800);

    for (int i = 0; i < 5; i++) {
      myMachine.makeCoffee(false, false, 0);
      myMachine.makeCoffee(false, true, 1);
      myMachine.makeCoffee(true, true, 2);
      myMachine.makeCoffee(true, false, 3);
      myMachine.printState();
    }

    myMachine.emptyCassier();
  }
}


