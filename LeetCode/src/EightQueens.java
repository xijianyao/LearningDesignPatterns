import java.util.Queue;

public class EightQueens {


    static int[][] map = new int[8][8];

    public static void main(String[] args) {
        play(0);
    }

    static int count = 1;

    private static void show() {
        System.out.println("第" + count + "种摆法：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
        count++;
    }

    private static boolean check(int row, int col) {

        //左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        //上
        for (int i = row - 1; i >= 0; i--) {
            if (map[i][col] == 1) {
                return false;
            }
        }

        //右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
            if (map[i][j] == 1) {
                return false;
            }
        }

        return true;
    }


    private static void play(int row) {
        for (int i = 0; i < 8; i++) {
            if (check(row, i)) {
                map[row][i] = 1;

                if (row >= 7) {
                    show();
                } else {
                    play(row + 1);
                }
                //当调用自己结束时候，去掉当前设置的皇后（什么情况下：要么就是最后一行了，要么就是这一行全都没满足摆放条件）
                map[row][i] = 0;
            }
        }
    }
}
