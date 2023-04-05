package Bitwise;

public class PascalTriangleSum {
    public static void main(String[] args) {
        int n=10;
        System.out.println(nRowSum(n));
    }

    private static int nRowSum(int n) {
        int sum = 1 << (n);
        return sum;
    }
}
