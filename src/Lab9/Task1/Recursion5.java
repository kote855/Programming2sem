package Lab9.Task1;

public class Recursion5 {
    public static void main(String[] args) {
        System.out.println("Факториал:" + fact(5, 1));
    }
    public static int fact(int num, int layer){
        System.out.println(String.format("%" + layer + "s>", num).replace(' ', '-'));
        if (num==0){
            System.out.println(String.format("%" + layer + "s<", num).replace(' ', '-'));
            return 0;
        } else if (num==1) {
            System.out.println(String.format("%" + layer + "s<", num).replace(' ', '-'));
            return 1;
        }else {
            int e = fact(num-2, layer+1)+fact(num-1, layer+1);
            System.out.println(String.format("%" + layer + "s<", num).replace(' ', '-'));
            return e;
        }
    }
}
