package linear_search;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[100];

        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * 120);
        }

        for (int i = 0; i < vec.length; i++) {
            if (vec[i] == 64) {
                System.out.println("found: " + i);
                break;
            }
        }
    }
}
