import java.io.*;
import java.util.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/the-time-in-words/problem
class Result {

    /*
     * Complete the 'timeInWords' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER h
     *  2. INTEGER m
     */

    public static String timeInWords(int h, int m) {
        ArrayList<String> numbers = new ArrayList<>(Arrays.asList(
                "zero",
                "one",
                "two",
                "three",
                "four",
                "five",
                "six",
                "seven",
                "eight",
                "nine",
                "ten",
                "eleven",
                "twelve",
                "thirteen",
                "fourteen",
                "fifteen",
                "sixteen",
                "seventeen",
                "eighteen",
                "nineteen",
                "twenty",
                "twenty one",
                "twenty two",
                "twenty three",
                "twenty four",
                "twenty five",
                "twenty six",
                "twenty seven",
                "twenty eight",
                "twenty nine"
        ));
        if(m == 0){
            return (numbers.get(h)+" o' clock");
        }else if(m == 30){
            return ("half past "+numbers.get(h));
        }else if (m < 30){
            if(m == 15){
                return ("quarter"+" past "+numbers.get(h));
            }
            return m == 1 ? ("one minute"+" past "+numbers.get(h)) : (numbers.get(m)+" minutes"+" past "+numbers.get(h));

        }else{ // m > 30
            if(m == 45){
                return (h == 12) ?
                        ("quarter to "+numbers.get(1)) :
                        ("quarter to "+numbers.get(h+1));
            }else{
                return (h == 12) ?
                        (numbers.get(60-m)+" minutes to "+numbers.get(1)) :
                        (numbers.get(60-m)+" minutes to "+numbers.get(h+1));
            }
        }
    }

}

public class TheTimeInWords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int h = Integer.parseInt(bufferedReader.readLine().trim());

        int m = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
