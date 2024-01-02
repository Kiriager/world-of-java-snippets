import java.util.Arrays;

public class Homework {
  public static void main(String[] args) {
    int[] arr1 = {17, 20, 11, 20, 21, 22};
    int[] arr2 = {-7, 2, 121, 0, 2, -44};

    int arr3[] = new int[6];

    for (int i = 0; i < arr3.length; i++) {
      arr3[i] = arr1[i] + arr2[i]; 
    }
    System.out.println(Arrays.toString(arr1));
    System.out.println(Arrays.toString(arr2));
    System.out.println(Arrays.toString(arr3));
  }
}
