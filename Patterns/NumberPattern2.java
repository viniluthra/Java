package Patterns;

public class NumberPattern2 {
    public static void main(String[] args) {
        printNumberPattern(5);
    }
    static void printNumberPattern(int n){
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
