package Bitwise;

public class NonRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {2,3,3,4,2,6,4,6,20};
        System.out.println(findNonRepeating(arr));
    }

    private static int findNonRepeating(int[] arr) {
        int unique = 0;
        for (int n : arr) {
            unique ^= n;
        }
        return unique;
    }
}
