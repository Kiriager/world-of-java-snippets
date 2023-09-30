public class CoffeeMachine {
    private static final int COFFEE_PER_CUP = 20;
    private static final int MILK_PER_CUP = 15;
    private static final int SUGAR_PORTION_VOLUME = 5;
    
    private static final int DEFAULT_CONTAINER_VOLUME = 1000;
    private static final int DEFAULT_BASE_PRICE = 30;
    private static final int DEFAULT_PRICE_INCREMENT = 6;
    private static final int MAX_SUGAR_PROTIONS_PER_CUP = 3;

    private static int basePrice = DEFAULT_BASE_PRICE;
    private static int priceIncrement = DEFAULT_PRICE_INCREMENT;

    private Container coffeeContainer;
    private Container milkContainer;
    private Container sugarContainer;
    
    private int money = 0;

    public CoffeeMachine() {
        coffeeContainer = new Container(DEFAULT_CONTAINER_VOLUME);
        milkContainer = new Container(DEFAULT_CONTAINER_VOLUME);
        sugarContainer = new Container(DEFAULT_CONTAINER_VOLUME);
    }

    public CoffeeMachine(int milkContainerVolume, int coffeeContainerVolume, int sugarContainerVolume) {
        coffeeContainer = new Container(coffeeContainerVolume);
        milkContainer = new Container(milkContainerVolume);
        sugarContainer = new Container(sugarContainerVolume);
    }

    public void loadIngridients(int milk, int coffee, int sugar) {
        coffeeContainer.fill(coffee);
        milkContainer.fill(milk);
        sugarContainer.fill(sugar);
    }

    public void printState() {
        System.out.print("Milk left: " + milkContainer.getContentsVolume());
        System.out.print(" | Coffee left: " + coffeeContainer.getContentsVolume());
        System.out.print(" | Sugar left: " + sugarContainer.getContentsVolume());
        System.out.println(" | Cash: " + money + " hrn");
    }

    public void makeCoffee(boolean white, boolean strong, int sugarPortions) {
        int sugar = Limiter.constrain(sugarPortions, 0, MAX_SUGAR_PROTIONS_PER_CUP) 
            * SUGAR_PORTION_VOLUME;
        if (isEnoughIngredients(white, strong, sugar)) {
            spendIngridients(white, strong, sugar);
            money += calculatePrice(white, strong);
            System.out.println("Your coffee is ready!");
        } else {
            System.out.println("Sorry! Not enough ingridients... Please try later.");
        }
    }

    private boolean isEnoughIngredients(boolean white, boolean strong, int sugar) {
        if (milkContainer.getContentsVolume() < MILK_PER_CUP && white) {
            return false;
        }
        if (sugarContainer.getContentsVolume() < sugar) {
            return false;
        }
        if (strong) {
            return coffeeContainer.getContentsVolume() >= COFFEE_PER_CUP * 2;
        } else {
            return coffeeContainer.getContentsVolume() >= COFFEE_PER_CUP;
        }
    }

    private void spendIngridients(boolean white, boolean strong, int sugar) {
        coffeeContainer.spend(COFFEE_PER_CUP);
        sugarContainer.spend(sugar);
        if (strong) {
            coffeeContainer.spend(COFFEE_PER_CUP);
        }
        if (white) {
            milkContainer.spend(MILK_PER_CUP);
        }
    }

    private int calculatePrice(boolean white, boolean strong) {
        int price = basePrice;
        if (strong) {
            price += priceIncrement;
        }
        if (white) {
            price += priceIncrement;
        }   
        return price;
    }

    public void emptyCassier() {
        System.out.println(money + " hrn was removed from coffee machine");
        money = 0;
    }

    public static void setBasePrice(int price) {
        basePrice = price;
    }

    public static void setPriceIncrement(int increment) {
        priceIncrement = increment;
    }
}
