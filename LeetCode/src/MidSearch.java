import java.io.Console;
import java.util.Arrays;

public class MidSearch {



    public static void main(String[] args) {
        int key = 9;
        int[] arrays = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        int a = search(key, arrays);

        System.out.println(a);
    }


    static int search(int key, int[] array) {
        int l = 0, h = array.length - 1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (key == array[mid]) return mid;
            if (key < array[mid]) h = mid - 1;
            else l = mid + 1;
        }
        return -1;
    }
}
