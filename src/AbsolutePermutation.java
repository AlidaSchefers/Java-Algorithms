
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

//comes from HackerRank: https://www.hackerrank.com/challenges/absolute-permutation/problem?isFullScreen=true
class Result {

    /*
     * Complete the 'absolutePermutation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     */


    public static List<Integer> absolutePermutation(int n, int k) {
        // Write your code here
        //3 conditions/rules
        //1. are both num in the range? 1-n
        //yes: take lower num
        //2. always take lower num
        //3. no repeats.

        //1. no repeats, 2. num is in range, 3. take lower num unless break 1 or 2, 4. if no num available, return list of -1.
        List<Integer> PermutationList = new ArrayList<Integer>();
        int[] freqs = int[n];
        for(int i = 0; i < n; i++){
            int[i] = 1;
        }
        int i = 1;
        while(i <= n){
            int option1 = i+k;
            int option2 = i-k;
            //decide which option to add to PermutationList or return list with just -1.
            i++;
        }



        return PermutationList;
    }

}

public class AbsolutePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}