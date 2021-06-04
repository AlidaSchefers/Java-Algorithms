
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

class Result {

    /*
     * Complete the 'bonetrousle' function below.
     *
     * The function is expected to return a LONG_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER k
     *  3. INTEGER b
     */

    public static List<Long> bonetrousle(long n, long k, int b) {
        //Pseudocode:
        // Make a list with default values
        // Add the numbers 1 through and including b in the list
        // calculate the sum of this collect
        //if the sum is greater than N,
            // return a list of -1
        //if the sum is equal to N
            // return the current list
        //if the sum is less than N:
            //calculate the difference between N (our goal) and the sum.
            //add the difference + the last element of the list.
            //if this new num is less than or equal to K, make the last element this new number and return the list
            //if the new num is greater than K, set the element to the value of K and decrease K by 1.
            //repeat with the previous element in the list
            //if we run out of elements, return list of -1.

    }

}

public class Bonetrousle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long n = Long.parseLong(firstMultipleInput[0]);

                long k = Long.parseLong(firstMultipleInput[1]);

                int b = Integer.parseInt(firstMultipleInput[2]);

                List<Long> result = Result.bonetrousle(n, k, b);

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

