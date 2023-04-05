package Bitwise;

public class MagicNumber {
    public static void main(String[] args) {
       int n=5;
        System.out.println(n+"th magic number is "+findMagicNumber(n));
    }

    private static int findMagicNumber(int n) {
        int pow=1,answer=0;
        while(n>0) {
            pow = pow*5;
            if((n&1)==1) {
                answer+=pow;
            }
            n >>= 1;
        }
        return answer;
    }

}
