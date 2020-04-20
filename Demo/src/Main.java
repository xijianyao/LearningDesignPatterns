public class Main {
    public static void main(String[] args) {
        long workerIdBits = 5L;
        long maxWorkerId = -1L ^ (-1L << workerIdBits);
        long ss = -1L << workerIdBits;

        System.out.println(workerIdBits);
        System.out.println(maxWorkerId);
        System.out.println(ss);
    }
}
