/**
 * Created by Yuchen Wang on 6/5/2016.
 */
public class BubbleSort {
    /*
    For the first i, compare it with following number, if i is larger, swap. Keep
    comparing until we have the largest number at the last index. Then we move to i+1,
    repeat the same steps.
     */
    public static void bubbleSort(double[] array) {
        double temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        double[] array = {3.9, 8.2, 3.1, 3.5, 5.3};
        System.out.print("Original array before bubble sort: ");
        for (double num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(array);
        System.out.print("Array after bubble sort: ");
        for (double num : array) {
            System.out.print(num + " ");
        }
    }
}
