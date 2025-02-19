package Lab9.Task5;

import Lab9.Task4.Node;

public class FromTail {
    public static void main(String[] args) {
        Node head = new Node(0,null);
        for (int i = 1; i <= 9; i++){
            Node ref = head;
            while (ref.next != null){
                ref = ref.next;
            }
            ref.next=new Node(i,null);
        }
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }
}
