import java.util.ArrayList;

public class Examples {
    public static void main(String[] args) throws Exception {
        // оголошуємо ArrayList
        ArrayList<String> list1 = new ArrayList<>();
        // додатково вказуємо початковий розмір
        ArrayList<String> list2 = new ArrayList<>(5);

        // додаємо елементи на початок списку
        list1.add("pizza");
        list1.add("unicorn");
        list1.add("rock");

        // роздруковуємо список
        System.out.println(list1);

        // додаємо у список елемент з індексом 2
        list1.add(2, "star");
        System.out.println(list1);

        // отримуємо значення елемента за індексом 2
        System.out.println(list1.get(2));

        // присвоюємо значення елементу за індексом 1
        list1.set(1, "knight");
        System.out.println(list1);

        // видаляємо елемент за індексом 3
        list1.remove(3);
        System.out.println(list1);

        // додаємо в значення кожного елемента число,
        // що дорівнює його індексу
        for (int i = 0; i < list1.size(); i++) {
            list1.set(i, list1.get(i) + " " + i);
        }
        System.out.println(list1);

        // виводимо значення елементів за допомогою foreach
        for (String element : list1) {
            System.out.println("Current element contains: " + element);
        }

        //видаляємо усі елементи списку
        list1.clear();
    }
}
