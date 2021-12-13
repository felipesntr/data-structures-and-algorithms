package sorting.quick_sort;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[55];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) Math.floor(Math.random() * 10);
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }

        quicksort(vec, 0, vec.length - 1);
        System.out.println();
        for (int i = 0; i < vec.length; i++) {
            System.out.print(vec[i] + " ");
        }
    }

    public static int[] quicksort(int[] vec, int left, int right) {
        if (left < right) {
            int p = part(vec, left, right);
            quicksort(vec, left, p);
            quicksort(vec, p + 1, right);
        }
        return vec;
    }

    public static int part(int[] vec, int left, int right) {
        int mid = (int) ((left + right) / 2);
        int pivot = vec[mid];
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do {
                i++;
            } while (vec[i] < pivot);
            do {
                j--;
            } while (vec[j] > pivot);
            if (i >= j) {
                return j;
            }
            int aux = vec[i];
            vec[i] = vec[j];
            vec[j] = aux;
        }
    }
}
