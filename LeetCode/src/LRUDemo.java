import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/*
 * LeetCode 146
 * 双向链表解决问题
 * 最近使用过的，存在最后，然后不够的话需要删除第一个，也就是头。。数据存储用hash，快速查找。
 * 存入的最新的以及，查询的最新的，addtohead
 * */
public class LRUDemo {

    //需要构造双向列表，以及缓存
    static class Node {
        int key;
        int value;

        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LruCache {
        private HashMap<Integer, Node> map;
        int count;
        int capicity;

        Node head;
        Node tail;

        //
        public LruCache(int capicity) {
            this.capicity = capicity;
            count = 0;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.pre = head;
            head.pre = null;
            tail.next = null;
        }


        //delete节点方法
        public void deleteNode(Node node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;

        }

        //add方法
        public void addToHead(Node node) {
            //先将head的next重定向
            node.next = head.next;
            node.next.pre = node;

            //再分配node，和head的next
            node.pre = head;
            head.next = node;
        }

        //get
        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            deleteNode(node);
            addToHead(node);

            return node.value;
        }

        //put
        public void put(int key, int value) {
            if (map.get(key) == null) {
                Node node = new Node(key, value);
                map.put(key, node);
                if (count < capicity) {
                    count++;
                } else {
                    map.remove(tail.pre.key);
                    deleteNode(tail.pre);
                }
                addToHead(node);
            } else {
                Node node = map.get(key);
                deleteNode(node);
                addToHead(node);
            }
        }


    }


    public static void main(String[] args) {


        LruCache cache = new LruCache(2);
        System.out.println(cache.get(1));
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));
        cache.put(5,5);
        System.out.println(cache.get(4));
    }

}
