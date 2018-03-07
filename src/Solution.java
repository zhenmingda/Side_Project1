import java.util.Arrays;

/**
 * Created by dashu on 2017/1/1.
 */
public class Solution {
    public static void main(String[] args) {
        int[] num1 = {4, 3};
        int[] num2 = {7, 6};
        int[] num3 = new int[num1.length + num2.length];
        Arrays.sort(num1);
        Arrays.sort(num2);
        System.arraycopy(num1, 0, num3, 0, num1.length);
        System.arraycopy(num2, 0, num3, num1.length, num2.length);
        Arrays.sort(num3);
        if (num3.length % 2 == 0) {
            int i = num3.length / 2;
            double median = ((double) num3[i] + (double) num3[i - 1]) / 2.0;
            System.out.println("Result: "+median);
        } else {
            int i = (num3.length - 1) / 2;
            double median=(double)num3[i];
            System.out.println("Result: "+median);
        }
    }
}
