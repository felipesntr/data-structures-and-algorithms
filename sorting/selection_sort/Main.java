package sorting.selection_sort;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[22];

        for (int i = 0; i < vec.length; i++) {
            vec[i] = (int) (Math.random() * 1000);
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }

        System.out.println("---");
        // selection sort O(n²)
        for (int i = 0; i < vec.length; i++) { // O(n)
            int min_pos = i;
            for (int j = i; j < vec.length; j++) { // O(n)
                if (vec[j] < vec[min_pos]) {
                    min_pos = j;
                }
            }
            int aux = vec[i];
            vec[i] = vec[min_pos];
            vec[min_pos] = aux;
        }

        for (int i = 0; i < vec.length; i++) {
            System.out.println(vec[i]);
        }
    }
}
