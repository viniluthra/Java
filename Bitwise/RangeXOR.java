package Bitwise;

public class RangeXOR {
    public static void main(String[] args) {
        int range = 10;
        System.out.println("Range is "+findXORRange(range));
    }

    private static int findXORRange(int range) {
        int answer =0;
        for(int i=0;i<=range;i++) {
            answer = answer^i;

            System.out.println("XOR till "+i+" is "+Integer.toBinaryString(answer));
        }
        return answer;
    }
}
