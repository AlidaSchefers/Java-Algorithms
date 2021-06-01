import java.io.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/repeated-string/problem
class Result { //solves 12 out of 22 test cases

    public static long calcaCount(String s){
        long aCount = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'a') {aCount++;}
        }
        return aCount;
    }

    public static long repeatedString(String s, long n) {
        // Write your code here
        long saCount = calcaCount(s);
        long totalaCount = 0;
        totalaCount += (n/s.length())*saCount;
        int subStrIndex = (int) n % s.length();
        totalaCount += calcaCount(s.substring(0, subStrIndex));
        return totalaCount;
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
