public class Test1 {

    public static void main(String[] args) {


        System.out.println(a(6));
    }


    static int a(int n) {

        //斐波拉契数列
        //1，1，2，3，5，8。。。。
        if (n == 1 || n == 2) {
            return 1;
        }


        return a(n - 1) + a(n - 2);
    }
}
