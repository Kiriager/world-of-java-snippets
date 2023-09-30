public class CoffeMachine {
    private static final int COFFEE_PER_CUP = 20;
    private static final int MILK_PER_CUP = 15;
    private static final int DEFAULT_CONTAINER_VOLUME = 1500;

    private static final int DEFAULT_BASE_PRICE = 25;
    private static final int DEFAULT_PRICE_INCREMENT = 5;

    private static int basePrice = DEFAULT_BASE_PRICE;
    private static int priceIncrement = DEFAULT_PRICE_INCREMENT;

    Container coffeeContainer;
    Container milkContainer;

    private int money = 0;

    public CoffeMachine() {
        coffeeContainer = new Container(DEFAULT_CONTAINER_VOLUME);
        milkContainer = new Container(DEFAULT_CONTAINER_VOLUME);
    }

    public CoffeMachine(int milkContainerVolume, int coffeeContainerVolume) {
        coffeeContainer = new Container(coffeeContainerVolume);
        milkContainer = new Container(milkContainerVolume);
    }

    public void loadIngridients(int milk, int coffee) {
        coffeeContainer.fill(coffee);
        milkContainer.fill(milk);
    }

    public void printState() {
        System.out.print("Milk left: " + milkContainer.getContentsVolume());
        System.out.print(" | Coffee left: " + coffeeContainer.getContentsVolume());
        System.out.println(" | Cash: " + money + " hrn");
    }

    public void makeCoffee(boolean white, boolean strong) {
        if (isEnoughIngredients(white, strong)) {
            spendIngridients(white, strong);
            money += calculatePrice(white, strong);
            System.out.println("Your coffee is ready!");
        } else {
            System.out.println("Sorry, not enough ingridients... Please try later.");
        }
    }

    private boolean isEnoughIngredients(boolean white, boolean strong) {
        if (milkContainer.getContentsVolume() < MILK_PER_CUP && white) {
            return false;
        }
        if (strong) {
            return coffeeContainer.getContentsVolume() >= COFFEE_PER_CUP * 2;
        } else {
            return coffeeContainer.getContentsVolume() >= COFFEE_PER_CUP;
        }
    }

    private void spendIngridients(boolean white, boolean strong) {
        coffeeContainer.spend(COFFEE_PER_CUP);
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
        System.out.println(money + " UAH was removed from coffee machine");
        money = 0;
    }

    public static void setBasePrice(int price) {
        basePrice = price;
    }

    public static void setPriceIncrement(int increment) {
        priceIncrement = increment;
    }
}
