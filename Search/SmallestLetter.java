package Search;
//You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.
//Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.
public class SmallestLetter {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'f';
        System.out.println(binarySearch(letters,target));
    }

    public static char binarySearch(char[] letters , char target) {
        int start =0,end = letters.length-1;
        if (target > letters[letters.length-1]) {
            return letters[0];
        }
        while (start <= end) {
            int mid = start + (end-start)/2;
             if (target < letters[mid]) {
                end = mid-1;
            } else {
                start = mid+1;
            }
        }
        return letters[start%letters.length];
    }
}
