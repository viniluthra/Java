package LinkedList;


public class LLImplementation {
    public static void main(String[] args) {
        LinkedList customList = new LinkedList();
        customList.insertFirst(8);
        customList.insertFirst(2);
        customList.insertLast(100);
        customList.insertFirst(60);
        customList.insertLast(90);
        customList.insertLast(20);
        customList.insert(12,3);
        customList.display();
        customList.delete(5);
        customList.display();
    }


}
