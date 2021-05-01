
//comes from HackerRank (medium difficulty): https://www.hackerrank.com/challenges/abbr/problem
//this version solves 7/16 of test cases

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public static Queue<Character> makeLettersList(String string){
        Queue<Character> bLettersList = new LinkedList<>();
        for (int i = 0; i < string.length(); i++){
            bLettersList.add(string.charAt(i));
        }
        return bLettersList;
    }

    public static String abbreviation(String a, String b) {
        // Write your code here
        Queue<Character> bLettersList = makeLettersList(b);
        for(int i = 0; i < a.length(); i++){
             if(!bLettersList.isEmpty()){
                 if(Character.isLowerCase(a.charAt(i))){ //if current letter lowercase
                     // Character bHeadLowercase = Character.toLowerCase(bLettersList.peek());
                     // System.out.println(bHeadLowercase);
                     if(Character.compare(a.charAt(i), Character.toLowerCase(bLettersList.peek())) == 0){ //they are the same character
                         bLettersList.remove();
                     }
                 }else{ //the current character is uppercase
                     if(Character.compare(a.charAt(i), bLettersList.peek()) == 0){ //they are the same character
                         bLettersList.remove();
                     }else{
                         return "NO";
                     }
                 }
             }else{ //queue is empty
                 if(Character.isUpperCase(a.charAt(i))){
                     return "NO";
                 }
             }
        }
        //outside for loop
        if(!bLettersList.isEmpty()){ //there are bLetters left in the queue
            return "NO";
        }
        return "YES";
    }

}

public class Abbreviation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            String a = bufferedReader.readLine();

            String b = bufferedReader.readLine();

            String result = Result.abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}