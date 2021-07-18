import java.io.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/fibonacci-modified/problem
class Result {

    public static int fibonacciModified(int t1, int t2, int n) {
       //initial ideas
        for(int i = 1; i < n; i++){
            int newt2 = t1+(t2*t2);
            t1 = t2;
            t2 = newt2;
            System.out.println("newt1: "+t1);
            System.out.println("newt2: "+t2);
        }
        return t2;
    }

}

public class FibonacciModified {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int t1 = Integer.parseInt(firstMultipleInput[0]);

        int t2 = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        int result = Result.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

