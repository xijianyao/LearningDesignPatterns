import java.util.Arrays;

public class Fast {
    public static void main(String[] args) {
        int[] ints = {5, 3, 7, 8, 2, 9, 4, 6};

        int num = ints[0];

        int i = 0;
        int j = ints.length - 1;

        while (i < j) {
            while (i < j) { //j负责找小的，扔给i
                if (ints[j] < num) {
                    ints[i] = ints[j];
                    break;
                }
                j--;
            }

            while (i < j) { //i负责找大的，扔给j
                if (ints[i] >= num) {
                    ints[j] = ints[i];
                    break;
                }
                i++;
            }

            ints[i] = num;
        }

        for (int s = 0; s < ints.length; s++) {
            System.out.println(ints[s]);
        }
        Arrays.asList(ints).forEach(item -> System.out.println(item));
        Arrays.asList(ints).forEach(System.out::println);
    }



}


//快速排序
