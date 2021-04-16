//challenge comes from HackerRank: https://www.hackerrank.com/challenges/java-anagrams/problem

import java.util.Scanner;

public class JavaAnagrams {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        //make both strings lowercase
        a = a.toLowerCase();
        b = b.toLowerCase();
        for (int i = 0; i < a.length(); i++){ //loop through string a
            String curLetter = a.substring(i,i+1);
            boolean containsLetter = b.contains(curLetter);
            if(containsLetter){ //if b contains the current letter
                //replace both instances of the letter with blank spaces
                a = a.replaceFirst(curLetter, " ");
                b = b.replaceFirst(curLetter, " ");
            }else{ // b string does not have the letter
                return false;
            }
        }
        return (a.equals(b)) ? true : false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
