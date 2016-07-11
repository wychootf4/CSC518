import java.util.Scanner;

/**
 * Created by hootf on 7/3/2016.
 */
public class test {
    static int i;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num = new int[10];
//
//        while (in.nextInt() != -1) {
//            for (i = 0; i <10; i++)
//                num[i] = in.nextInt();
//        }
//        in.close();
        int largest = 0;
        while (i >= 0) {
            if (num[i] > largest) {
                largest = num[i];
                i--;
            }
        }
        System.out.println("The largest number is " + largest);
    }
}
