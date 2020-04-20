public class MyLinkedList {
    int size = 0;
    Node head = null;

    public void add(Object value) {
        Node newNode = new Node(value);
        if (head == null) {
            this.head = newNode;
        } else {
            Node temp = head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }

            temp.setNext(newNode);
        }
        size++;
    }

    public int size() {
        return size;
    }

    public void set(int index, Object value) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setValue(value);
    }

    public Object get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getValue();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public void removeAt(int index) {
        if (index == 0) {
            head = head .getNext();
        }else {
            Node temp = head;
            for (int i = 0; i < index -1; i++) {
                temp = temp.getNext();
            }
            temp.setNext(temp.getNext().getNext());
        }
    }

}
