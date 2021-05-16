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
        HashMap<Integer, Integer> typesFrequencies = new HashMap<Integer, Integer>();
        typesFrequencies.put(1, 0);
        typesFrequencies.put(2, 0);
        typesFrequencies.put(3, 0);
        typesFrequencies.put(4, 0);
        typesFrequencies.put(5, 0);
        for(Integer type : arr){
            typesFrequencies.put(type, typesFrequencies.get(type)+1);
            // System.out.println(type)
        }
        int maxType = 0;
        int maxFrequ = 0;
        for (Map.Entry entry : typesFrequencies.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
            // if(entry.getValue() > maxFrequ){
            //     maxType = entry.getKey();
            //     maxFrequ = entry.getValue();
            // }
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
