package sorting.heap_sort;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[22];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) Math.floor(Math.random() * 10);
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }

        System.out.println();

        int n = vec.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(vec, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            int aux = vec[0];
            vec[0] = vec[i];
            vec[i] = aux;

            heap(vec, i, 0);
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
    }

    private static void heap(int[] vec, int n, int i) {
        int root = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && vec[left] > vec[root]) {
            root = left;
        }
        if (right < n && vec[right] > vec[root]) {
            root = right;
        }
        if (root != i) {
            int aux = vec[i];
            vec[i] = vec[root];
            vec[root] = aux;

            heap(vec, n, root);
        }
    }
}
