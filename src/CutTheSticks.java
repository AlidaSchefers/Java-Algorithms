import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/cut-the-sticks/problem
//passes 6/10 test cases, and the others failed because of a runtime error

class Result {

    /*
     * Complete the 'cutTheSticks' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> cutTheSticks(List<Integer> arr) {
        // Write your code here
        List<Integer> sticksCutArr = new ArrayList<Integer>();
        int minHeight = Collections.min(arr);
        while(arr.size() > 1){
            sticksCutArr.add(arr.size());
            for (int i = 0; i < arr.size(); i++){
                if(arr.get(i) == minHeight) {
                    arr.remove(i);
                    i--;
                }else{
                    arr.set(i, arr.get(i)-minHeight);
                }
            }
            minHeight = Collections.min(arr);
        }
        sticksCutArr.add(1);
        return sticksCutArr;
    }

}

public class CutTheSticks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.cutTheSticks(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}