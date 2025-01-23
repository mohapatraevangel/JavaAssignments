package Day1;

public class ArrayCopy {
        public static void main(String[] args) {

            int[] originalArray = {1, 2, 3, 4, 5};
            int[] copiedArray = copyOf(originalArray);


            for (int num : copiedArray) {
                System.out.print(num + " ");
            }
        }
        public static int[] copyOf(int[] array) {
            return array.clone();
        }
    }
