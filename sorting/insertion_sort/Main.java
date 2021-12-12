package sorting.insertion_sort;

public class Main {
    public static void main(String[] args) {
        int[] vec = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }

        System.out.println("---");

        for (int i = 1; i < vec.length; i++) {
            int aux = vec[i];
            int j = i - 1;
            while (j >= 0 && vec[j] > aux) {
                vec[j + 1] = vec[j];
                j--;
            }
            vec[j + 1] = aux;
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }
    }
}
