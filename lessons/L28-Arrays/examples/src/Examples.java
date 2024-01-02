import java.util.Arrays;

public class Examples {
    public static void main(String[] args) throws Exception {
        String[] pets1; // оголошуємо масив
        String[] pets2 = new String[5]; // + під масив виділяється пам'ять
        String[] pets3 = { "cat", "dog", "golden fish" }; // + присвоюємо значення елементам масиву
        String[] pets = new String[] { "cat", "dog", "golden fish" }; // теж саме

        System.out.println(pets[1]); // виводимо в консоль значення з індексом 1
        pets[1] = "bird"; // перезаписуємо значення з індексом 1
        System.out.println(pets[1]);
        System.out.println("Quantity of pets is: " + pets.length); // виводимо довжину масиву

        // Пробігаємось по елементах масиву
        // за допомогою циклу for і до кожного додаємо текст
        for (int i = 0; i < pets.length; i++) {
            pets[i] = "my favorite " + pets[i];
        }

        // Друкуємо вміст масиву за допомогою Arrays.toString()
        System.out.println(Arrays.toString(pets));

        // Друкуємо вміст масиву збираючи значення елементів
        // у рядок за допомогою циклу foreach
        String result = "My pets are: ";
        for (String pet : pets) {
            result += pet + ", ";
        }
        System.out.println(result);

        String line = "ab:cdf:gi:j";
        String[] splitResult = line.split(":");
        System.out.println(Arrays.toString(splitResult));

        String numberText = "2024";
        int year;

        try {
            year = Integer.parseInt(numberText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
