package queue;

public class Main {
    public static void main(String[] args) {
        Queue<String> f = new Queue<String>();
        f.add("a");
        f.add("b");
        f.add("c");
        f.add("d");

        System.out.println(f.peek());

        f.remove();

        System.out.println(f.peek());

        f.remove();

        System.out.println(f.peek());
    }
}
