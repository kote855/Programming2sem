package Lab9.Task8;

public class Main {

    static int offset = 13;
    static int col_offset = 25;

    static Cycle cycle = new Cycle();
    static Recursion recursion = new Recursion();

    public static void Print(String s){

        System.out.printf("%1$-"+offset+"s" + "%2$-"+col_offset+"s" +
                "%1$-"+offset+"s" + recursion + "\n", s, cycle);
    }

    public static void main(String[] args) {
        int tail = 2;
        int head = 2;
        int index = 2;

        System.out.printf("%-"+(offset+col_offset)+"s" + "%s\n", "CYCLE", "RECURSION");

        cycle.createTail(tail);
        recursion.createTail(tail);
        Print("createTail:");

        cycle.createHead(head);
        recursion.createHead(head);
        Print("createHead:");

        cycle.createTail(tail);
        recursion.createTail(tail);
        Print("createTail:");

        cycle.AddFirst();
        recursion.AddFirst();
        Print("AddFirst:");

        cycle.AddLast();
        recursion.AddLast();
        Print("AddLast:");

        cycle.Insert(index);
        recursion.Insert(index);
        Print("Insert:");

        cycle.RemoveFirst();
        recursion.RemoveFirst();
        Print("RemoveFirst:");

        cycle.RemoveLast();
        recursion.RemoveLast();
        Print("RemoveLast:");

        cycle.Remove(index);
        recursion.Remove(index);
        Print("Remove:");
    }
}
