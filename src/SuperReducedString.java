import java.io.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/reduced-string/problem
class Result {

    public static String superReducedString(String s) {
        //first idea:
        //loop
            //start looking at characters at indexes 0 and 1
                //if different, move indexes up by one
                //if the same, delete the two characters and compare characters at indexes 0 and 1 again
            //do this loop until you get to the end of the indexes
    }

}

public class SuperReducedString {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
