import java.util.*;

/*
 * 集合不安全问题
 * ArraryList:
 * 故障现象：java.util.ConcurrentModificationException
 * 导致原因：
 *
 * 解决方案：
 * 1.new Vector<>()
 * 2.Collections.synchronizedList(new ArrayList<>());
 *
 * */
public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
