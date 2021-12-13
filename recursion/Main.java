package recursion;

public class Main {
    public static void main(String[] args) {
        int[] vec = { 1, 2, 3, 4, 5, 5 };
        System.out.println(sum(0, vec));
    }

    private static int sum(int pos, int[] vec) {
        return (pos < vec.length) ? vec[pos] + sum(pos + 1, vec) : 0;
    }
}
