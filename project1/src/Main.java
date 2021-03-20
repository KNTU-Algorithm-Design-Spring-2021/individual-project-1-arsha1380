import java.util.Scanner;

public class Main {
    public static int counter = 0;

    public static void main(String[] args) {
        int nodeNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of nodes :");
        nodeNumber = Integer.parseInt(scanner.nextLine());

        int x_Array[] = new int[nodeNumber];
        int y_Array[] = new int[nodeNumber];
        getNodeLocation(x_Array, y_Array, nodeNumber, scanner);

        int x_Min_Max[] = arraygetMaxMinValue(x_Array, 0, nodeNumber - 1);

        int y_Min_Max[] = arraygetMaxMinValue(y_Array, 0, nodeNumber - 1);

        System.out.println("A: ( " + x_Min_Max[0] + " , " + y_Min_Max[0] + " )");
        System.out.println("B: ( " + x_Min_Max[0] + " , " + y_Min_Max[1] + " )");
        System.out.println("C: ( " + x_Min_Max[1] + " , " + y_Min_Max[1] + " )");
        System.out.println("D: ( " + x_Min_Max[1] + " , " + y_Min_Max[0] + " )");
//        printShape(x_Array,y_Array,x_Min_Max,y_Min_Max);
    }

    private static int[] arraygetMaxMinValue(int[] array, int left, int right) {
        if (left == right) {
            int max_min[] = new int[2];
            max_min[0] = array[left];
            max_min[1] = array[left];
            return max_min;
        }
        if ((right - left) == 1) {
            int max_min[] = new int[2];
            counter++;
            if (array[right] > array[left]) {
                max_min[0] = array[left];
                max_min[1] = array[right];
            } else {
                max_min[0] = array[right];
                max_min[1] = array[left];
            }
            return max_min;
        }
        int leftArray[] = arraygetMaxMinValue(array, left, (left + right) / 2);
        int rightArray[] = arraygetMaxMinValue(array, ((left + right) / 2) + 1, right);
        int final_min_max[] = new int[2];

        if (rightArray[0] < leftArray[0]) {
            final_min_max[0] = rightArray[0];
        } else {
            final_min_max[0] = leftArray[0];
        }

        if (rightArray[1] > leftArray[1]) {
            final_min_max[1] = rightArray[1];
        } else {
            final_min_max[1] = leftArray[1];
        }
        return final_min_max;
    }

    public static void getNodeLocation(int[] x_Array, int[] y_Array, int number, Scanner scanner) {
        System.out.println("X :");
        for (int i = 0; i < number; i++) {
            x_Array[i] = scanner.nextInt();
        }
        System.out.println("Y :");
        for (int i = 0; i < number; i++) {
            y_Array[i] = scanner.nextInt();
        }
        return;
    }
}
