package DoublyLinkedList;

public class DLLImplementation {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(20);
        list.insertFirst(80);
        list.insertFirst(13);
        list.insertLast(90);
        list.insertLast(19);
        list.display();
        list.insert(10,13);
        list.display();

    }
}
