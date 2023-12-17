package Examples;

import java.util.Arrays;

public class Example1 {
  public static void main(String[] args) {
    String pets[] = {"cat", "dog", "octopus"};

    pets[1] = "bird"; //перезаписуємо значення за індексом 1
    System.out.println(pets[1]); // виводимо в консоль значення за індексом 1
    System.out.println("Number of pets is: " + pets.length); // виводимо довжину масиву 

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
    
  }
}
