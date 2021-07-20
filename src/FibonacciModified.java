import java.io.*;
import java.math.BigInteger;

//comes from HackerRank: https://www.hackerrank.com/challenges/fibonacci-modified/problem
class Result {

    public static BigInteger fibonacciModified(int t1, int t2, int n) {
        BigInteger BIt1 = BigInteger.valueOf(t1);
        BigInteger BIt2 = BigInteger.valueOf(t2);
        for(int i = 1; i < n-1; i++){
            BigInteger newt2 = BIt1.add((BIt2.multiply(BIt2)));
            BIt1 = BIt2;
            BIt2 = newt2;
            System.out.println("newt1: "+BIt1);
            System.out.println("newt2: "+BIt2);
        }
        return BIt2;
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

        BigInteger result = Result.fibonacciModified(t1, t2, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
