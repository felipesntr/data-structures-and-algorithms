package sorting.bubble_sort;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[20];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * vec.length);
            System.out.println(vec[i]);
        }

        for (int i = 0; i < vec.length; i++) {
            for (int j = i + 1; j < vec.length; j++) {
                if (vec[i] >= vec[j]) {
                    int aux = vec[j];
                    vec[j] = vec[i];
                    vec[i] = aux;
                }
            }
        }

        System.out.println("----");

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }
    }
}
