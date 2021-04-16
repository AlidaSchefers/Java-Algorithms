import java.util.Scanner;

//comes from HackerRank: https://www.hackerrank.com/challenges/java-string-compare/problem
public class SubstringComparisons {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = smallest;
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        for(int i = 1; i < s.length()-(k-1); i++) {
            String currentSubString = s.substring(i, i+k);
            // System.out.println("current substring: "+currentSubString);
            boolean smallerThanSmallest = currentSubString.compareTo(smallest) < 0;
            boolean largerThanLarger = currentSubString.compareTo(largest) > 0;
            if(smallerThanSmallest){
                smallest = currentSubString;
            }else if(largerThanLarger){
                largest = currentSubString;
            }
        }

        return smallest + "\n" + largest;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}
