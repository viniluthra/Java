package ArrayAndArrayList;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        int[][] accounts = {
                {1,2,6},
                {3,2,0}
        };

        System.out.println(richestCustomerWealth(accounts));
        }

    public  static int richestCustomerWealth(int[][] accounts) {
        int sum=0,wealth = Integer.MIN_VALUE;
        for (int[] customer : accounts) {
            sum =0;
            for (int account : customer) {
                sum+=account;
            }
            wealth = Math.max(sum,wealth);
        }
           return wealth;
    }
}
