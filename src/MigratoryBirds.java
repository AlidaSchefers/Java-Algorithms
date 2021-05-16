import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/migratory-birds/problem
class Result {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        int[] typesArr = {1,2,3,4,5};
        int[] typesFrequenciesArr = new int[5];
        for (int i = 0; i < arr.size(); i++){
            typesFrequenciesArr[arr.get(i)-1]++;
        }
        int maxType = 0;
        int maxFrequ = 0;
        for(int i = 0; i < typesFrequenciesArr.length; i++){
            if(typesFrequenciesArr[i] > maxFrequ){
                maxType = i+1;
                maxFrequ = typesFrequenciesArr[i];
            }
        }
        return maxType;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
