import java.io.*;
import java.util.stream.IntStream;
//comes from HackerRank: https://www.hackerrank.com/challenges/find-digits/problem


class Result {

    /*
     * Complete the 'findDigits' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER n as parameter.
     */

    public static int findDigits(int n) {
        // Write your code here
        String nStr = String.valueOf(n);
        int divisorCount = 0;
        for (int i = 0; i < nStr.length(); i++){
            if(nStr.charAt(i) != '0'){
                if(n % Character.getNumericValue(nStr.charAt(i)) == 0){
                    divisorCount++;
                }
            }
        }
        return divisorCount;
    }

}

public class FindDigits {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                int result = Result.findDigits(n);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
