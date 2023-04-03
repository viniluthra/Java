package Patterns;

public class StarPattern2 {
    public static void main(String[] args) {
        printStarPattern(4);
    }
    static void printStarPattern(int n){
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
