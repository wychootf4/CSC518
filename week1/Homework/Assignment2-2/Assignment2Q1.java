/**
 * Created by Yuchen Wang on 6/5/2016.
 */
public class Assignment2Q1 {
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

    public static void main(String[] args) {
        int[] intArray = {9, 2, 4, 8, 5, 15, 8, 20, 5, 1};
        Node[] array = new Node[intArray.length];
        System.out.print("Original array: ");
        for (int i = 0; i < array.length; i++) {
            array[i] = new Node(intArray[i]);
            System.out.print(array[i].data + " ");
        }
        System.out.println();
        bubbleSort(array);
        System.out.print("Output array: ");
        for (Node node : array) {
            System.out.print(node.data + " ");
        }
    }
}
