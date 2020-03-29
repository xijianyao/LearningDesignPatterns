import java.util.HashMap;
import java.util.List;

/*

*
* */
public class LRUDemo {

    static class Node {    //定义一个Node类
        int key;
        int value;
        Node pre;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        HashMap<Integer, Node> map;
        int capicity, count;    //最大容量，当前容量
        Node head, tail;    //头节点，尾节点

        public LRUCache(int capacity) {
            this.capicity = capacity;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            head.pre = null;
            tail.next = null;
            count = 0;
        }

        public void deleteNode(Node node) { //两个方法
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }

        public void addToHead(Node node) {
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        public int get(int key) {
            if (map.get(key) != null) {
                Node node = map.get(key);
                int result = node.value;
                deleteNode(node);
                addToHead(node);
                return result;
            }
            return -1;
        }

        public void put(int key, int value) {
            if (map.get(key) != null) {
                Node node = map.get(key);
                node.value = value;
                deleteNode(node);
                addToHead(node);
            } else {
                Node node = new Node(key, value);
                map.put(key, node);
                if (count < capicity) {
                    count++;
                    addToHead(node);
                } else {
                    map.remove(tail.pre.key);
                    deleteNode(tail.pre);
                    addToHead(node);
                }
            }
        }
    }




    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(2));
        cache.put(3,3);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        cache.put(4,4);
        System.out.println(cache.get(3));

    }

}
