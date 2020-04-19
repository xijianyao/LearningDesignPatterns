import java.io.File;

public class Test2 {


    public static void main(String[] args) {
        play(new File("I:\\新建文件夹"));
    }


    //树的遍历

    static void play(File file) {
        //获取当前文件下所有字文件夹
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println(files[i].getName());
            } else {
                play(files[i]);
            }
        }
    }
}
