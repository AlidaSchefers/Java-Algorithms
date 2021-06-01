import java.io.*;
import java.util.ArrayList;

//comes from HackerRank: https://www.hackerrank.com/challenges/repeated-string/problem
class Result {

    public static long repeatedString(String s, long n) {
        // Write your code here
        long aCount = 0;
        ArrayList<Integer> saIndexes = new ArrayList<Integer>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') {
                aCount++;
                saIndexes.add(i);
            }
        }
        aCount += ((n/s.length())*aCount)-aCount;
        for(Integer index : saIndexes){
            System.out.println(index);
            if(index+1 <= (n % s.length())){
                aCount++;
            }
        }
        return aCount;
    }

}

public class RepeatedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.repeatedString(s, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
