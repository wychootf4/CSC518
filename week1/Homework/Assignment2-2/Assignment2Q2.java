/**
 * Created by Yuchen Wang on 6/5/2016.
 */
public class Assignment2Q2 {
    static class Node {
        protected int data;

        public Node() {
            data = 0;
        }
        public Node (int data) {
            this.data = data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return this.data;
        }
    }

    public static void bubbleSort(Node[] array) {
        Node temp;

        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1].data > array[j].data) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void bubbleSort(double[] array) {
        double temp = 0.0;

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

    public static void bubbleSort(int[] array) {
        int temp = 0;

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
        int[] intArray = {9, 2, 4, 8, 5, 15, 8, 20, 5, 1};
        double[] doubleArray = {3.1, 2.5, 8.6, 7.3, 9.1, 1.1};
        Node[] nodeArray = new Node[intArray.length];
        for (int i = 0; i < nodeArray.length; i++) {
            nodeArray[i] = new Node(intArray[i]);
        }

        System.out.print("Original double array: ");
        for (double num : doubleArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(doubleArray);
        System.out.print("Output double array: ");
        for (double num : doubleArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Original integer array: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();
        bubbleSort(intArray);
        System.out.print("Output double array: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("Original node array: ");
        for (int i = 0; i < nodeArray.length; i++) {
            System.out.print(nodeArray[i].data + " ");
        }
        System.out.println();
        bubbleSort(nodeArray);
        System.out.print("Output node array: ");
        for (Node node : nodeArray) {
            System.out.print(node.data + " ");
        }
    }
}
