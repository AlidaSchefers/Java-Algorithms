import java.io.*;
import java.math.BigInteger;

//comes from HackerRank: https://www.hackerrank.com/challenges/fibonacci-modified/problem
class Result {

    public static int fibonacciModified(int t1, int t2, int n) {
        for(int i = 1; i < n-1; i++){
            BigInteger newt2 = BigInteger.valueOf(t2);
            BigInteger newt1 = BigInteger.valueOf(t1);
            BigInteger new2t2 = newt1.add((newt2.multiply(newt2)));
            newt1 = newt2;
            newt2 = new2t2;
            System.out.println("newt1: "+newt1);
            System.out.println("newt2: "+newt2);
        }
        // return newt2;
        return 0;
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

