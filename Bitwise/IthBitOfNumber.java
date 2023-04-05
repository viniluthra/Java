package Bitwise;

public class IthBitOfNumber {
    public static void main(String[] args) {
        byte b= 0b11101;
        int i=3;
        System.out.println("Ith bit is: "+Integer.toBinaryString(findIthBit(b,i)));
    }

    private static int findIthBit(byte b, int i) {
        int mask = 1 << (i-1);
        int iBit = (b & mask) >> (i-1);
        return iBit;
    }


}
