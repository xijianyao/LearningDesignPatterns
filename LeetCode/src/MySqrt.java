public class MySqrt {

    public static void main(String[] args) {

        System.out.println(mySqrt(9));

        System.out.println(mySqrt(15));

        System.out.println(mySqrt(16));

    }

    static int mySqrt(int x) {
        if(x <= 1) return x;
        int l = 1, h = x;
        while(l <= h){
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if(sqrt == mid) return mid;
            else if(sqrt < mid) h = mid - 1;
            else l = mid + 1;
        }
        return h;
    }

}
