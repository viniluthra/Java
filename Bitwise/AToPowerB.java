package Bitwise;

public class AToPowerB {
    public static void main(String[] args) {
        int a = 3, b = 6;
        System.out.println(calculatePower(a,b));
    }

    private static int calculatePower(int a, int b) {
        int answer=1;
        while (b > 0) {
            if ((b & 1) == 1) {
                answer*=a;
            }
            a*=a;
            b >>= 1;
        }
        return answer;
    }
}
