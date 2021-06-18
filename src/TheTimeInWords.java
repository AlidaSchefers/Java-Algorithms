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
            return (numbers.get(h) + " o' clock");
        }else{
            String part1;
            if(m == 1 || (60-m) == 1){
                part1 = "one minute";
            }else if(m == 15 || (60-m) == 15){
                part1 = "quarter";
            }else if(m == 30){
                part1 = "half";
            }else if(m <= 30){
                part1 = (numbers.get(m) + " minutes");
            }else{ //m > 30
                part1 = (numbers.get(60-m) + " minutes");
            }
            String part2;
            if(m <= 30){
                part2 = ("past " + numbers.get(h));
            }else{ //m > 30
                part2 = (h == 12) ?
                        ("to " + numbers.get(1)) :
                        ("to " + numbers.get(h+1));
            }
            return (part1 + " " + part2);
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
