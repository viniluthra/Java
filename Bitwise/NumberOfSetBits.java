package Bitwise;

public class NumberOfSetBits {
    public static void main(String[] args) {
        int number =45;
        System.out.println(calculateSetBits(number));
    }

    private static int calculateSetBits(int number) {
        int count=0;
        while (number > 0) {
            if((number & 1) == 1)
                count++;
            number >>= 1;
        }
        return count;
    }
}
