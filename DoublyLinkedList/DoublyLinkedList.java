package DoublyLinkedList;

public class DoublyLinkedList {

    Node head;
    Node tail;
    private class Node {
        int value;
        Node next;
        Node previous;

        public Node(int val) {
            value = val;
        }

        public Node(int val, Node next, Node previous) {
            this.value = val;
            this.next = next;
            this.previous = previous;
        }
    }

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.previous = null;
        node.next = head;
        head = node;
        if(head!=null) {
            head.previous = node;
        }
        if(tail == null) {
            tail = head;
        }
    }

    public void insertLast(int val) {
        if(tail == null) {
            insertFirst(val);
        } else {
            Node node = new Node(val);
            node.previous = tail;
            tail.next = node;
            tail = node;
        }
    }

    public void insert(int val , int after) {
        Node p = find(after);
        if(p == null) {
            System.out.println(after+" Not Found");
        } else {
            Node node = new Node(val);
            node.next = p.next;
            node.previous = p;
            p.next = node;
            tail = node;
        }
    }

    private Node find(int after) {
        Node temp = head;
        while (temp != null) {
            if(temp.value == after)
                return temp;
            temp=temp.next;
        }
        return null;
    }

    public void display() {
        Node node = head;
        while (node != null) {
            System.out.print(node.value+" -> ");
            node =node.next;
        }
        System.out.println("END");
    }
}
