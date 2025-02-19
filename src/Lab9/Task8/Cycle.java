package Lab9.Task8;

import Lab9.Task4.Node;

public class Cycle {
    private Node node = null;
    private int count = 0;

    private void caclCount(){
        Node ref = node;
        count = 0;
        while (ref != null) {
            count++;
            ref = ref.next;
        }
    }
    public void createHead(int lenght){
        caclCount();
        for (int i = lenght-1+count; i >= count; i--){
            node = new Node(i, node);
        }
    }

    public void createTail(int lenght){
        caclCount();
        for (int i = count; i < lenght + count; i++){
            try {
                Node ref = node;
                while (ref.next != null){
                    ref = ref.next;
                }
                ref.next = new Node(i,null);
            }catch (NullPointerException e){
                node = new Node(i,null);
            }
        }
    }

    public String toString(){
        Node ref = node;
        String str = "";
        while (ref != null) {
            str += ref.value + " ";
            ref = ref.next;
        }
        return str;
    }

    public void AddFirst(){
        caclCount();
        node = new Node(count, node);
    }

    public void AddLast(){
        caclCount();
        Node ref = node;
        while (ref.next != null){
            ref = ref.next;
        }
        ref.next = new Node(count,null);
    }

    public void Insert(int index){
        caclCount();
        Node ref = node;
        for (int i = 1; i < index - 1; i++) {
            ref = ref.next;
        }
        ref.next = new Node(count, ref.next);
    }

    public void RemoveFirst(){
        node = node.next;
    }

    public void RemoveLast(){
        Node ref = node;
        while (ref.next.next != null){
            ref = ref.next;
        }
        ref.next = null;
    }

    public void Remove(int index){
        Node ref = node;
        for (int i = 1; i < index - 2; i++) {
            ref = ref.next;
        }
        ref.next = ref.next.next;
    }
}