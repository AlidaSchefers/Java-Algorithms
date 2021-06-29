import java.io.*;
import java.util.stream.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/hackerrank-in-a-string/problem
class Result {

    /*
     * Complete the 'hackerrankInString' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String hackerrankInString(String s) {
        // Write your code here
        String hackerrank = "hackerrank";
        int hrIndex = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == hackerrank.charAt(hrIndex)){
                hrIndex++;
            }
            if(hrIndex == hackerrank.length()){
                return "YES";
            }
        }
        return "NO";
    }

}

public class HackerRankInAString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                String result = Result.hackerrankInString(s);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

