package Lab9.Task8;

import Lab9.Task4.Node;

public class Recursion {
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

    public String toString(){
        Node ref = node;
        return toStringRec(ref);
    }
    private String toStringRec(Node ref){
        return ref == null ? "" : ref.value + " " + toStringRec(ref.next);
    }

    public void createHead(int lenght){
        caclCount();
        if (lenght>0){
            node = new Node(count, node);
            createHead(lenght - 1);
        }
        lenght++;
        indexNode(lenght, node).value = lenght;
    }

    private Node lastNode(Node node){
        if (node.next != null){
            node = lastNode(node.next);
        }
        return node;
    }

    private Node indexNode(int index, Node node){
        index--;
        if (index > 1){
            node = indexNode(index, node.next);
        }
        return node;
    }

    public void createTail(int lenght){
        caclCount();
        if (count < lenght + count){
            lenght--;
            createTail(lenght);
            try {
                lastNode(node).next = new Node(lenght + count, null);
            }catch (NullPointerException e){
                node = new Node(lenght,null);
            }
        }
    }
    public void AddFirst(){
        caclCount();
        node = new Node(count, node);
    }

    public void AddLast(){
        caclCount();
        lastNode(node).next = new Node(count,null);
    }

    public void Insert(int index){
        caclCount();
        Node indexNode = indexNode(index, node);
        indexNode.next = new Node(count, indexNode.next);
    }

    public void RemoveFirst(){
        node = node.next;
    }

    public void RemoveLast(){
        caclCount();
        indexNode(count, node).next = null;
    }

    public void Remove(int index){
        caclCount();
        Node indexNode = indexNode(index, node);
        indexNode.next = indexNode.next.next;
    }
}
