package Search;

public class NextGreatestLetter {

    public static void main(String[] args) {
        char[] chars = {'c','f','g'};
        char target = 'c';
        System.out.println(nextGreatestLetter(chars,target));
    }
    public static char nextGreatestLetter(char[] letters, char target) {
        int start = 0,end = letters.length-1;
        while(start<=end) {
            int middle = start + (end-start)/2;
            if (target >= letters[middle]) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }
        return letters[start%letters.length];
    }
}
