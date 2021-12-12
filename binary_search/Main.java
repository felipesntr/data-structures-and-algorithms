package binary_search;

public class Main {
    public static void main(String[] args) {
        int[] vec = new int[22];
        for (int i = 1; i < 22; i++) {
            vec[i] = i;
        }

        int start = 0;
        int end = vec.length - 1;
        int mid = (int) ((start + end) / 2);
        int s = 4;
        boolean found = false;

        while (vec[start] <= vec[end]) {
            mid = (int) ((start + end) / 2);
            if (s == vec[mid]) {
                found = true;
                break;
            } else if (s > vec[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (found)
            System.out.println("At pos: " + mid);

    }
}
