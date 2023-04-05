package Bitwise;

public class PowerOf2 {
    public static void main(String[] args) {
        int b = 128;
        boolean ans = (b & (b-1)) == 0;
        System.out.println(ans);
    }
}
