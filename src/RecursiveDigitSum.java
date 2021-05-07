import java.io.*;
import java.math.BigInteger;

//comes from HackerRank: https://www.hackerrank.com/challenges/recursive-digit-sum/problem

class Result {

    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     */

    public static int superDigit(String n, int k) {
        // Write your code here
        if(n.length() == 1){
            return Integer.parseInt(n);
        }else{
            int sum = 0;
            for(int i = 0; i < n.length(); i++){
                sum += Character.getNumericValue(n.charAt(i));
            }
            BigInteger newSum = BigInteger.valueOf(sum).multiply(BigInteger.valueOf(k));
            return superDigit(String.valueOf(newSum), 1);
        }
    }
}

public class RecursiveDigitSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        String n = firstMultipleInput[0];

        int k = Integer.parseInt(firstMultipleInput[1]);

        int result = Result.superDigit(n, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

