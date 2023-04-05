package Recursion;

public class SumOfN {
    public static void main(String[] args) {
        int n=5;
        System.out.println("Sum of first "+n+" numbers is "+sum(n));
    }
    static int sum(int n) {;
        while (n<=0) {
            return 0;
        }
        return n+sum(n-1);
    }
}
