package google;

public class LinkedList<Item>{
    private Node head;
    private class Node{
        Item item;
        Node next;
        private Node(Item item){
            this.item = item;
            this.next = null;
        }
    }

    public void add(Item item){
        Node curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        Node newNode = new Node(item);
        curr.next = newNode;
    }
    

}
