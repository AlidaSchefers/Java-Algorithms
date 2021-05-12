import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/minimum-distances/problem

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    //minDistance = Integer.maxValue;
    //firstIndex --> 0
    //secondIndex --> size-1
    //update the indexes with each loop. stop loop when firstIndex > n % 2.
    //numOfPairs = 0;
    //compare values to see if they're the same
    //distance = 0;
    //if they are, caculate distance b/w them (indeces absolute difference)
    //distance = diff b/w indeces (secondIndex - firstIndex)
    //if distance < minDistance, minDistance = distance;
    //numOfPairs++;
    //if numOfPairs == 0, return -1.


    public static int minimumDistances(List<Integer> a) {
        // Write your code here
        int minDistance = a.size();
        int firstIndex = 0;
        int secondIndex = a.size()-1;
        int numOfPairs = 0;
        System.out.println("1current distance: "+ (secondIndex - firstIndex));
        System.out.println("a.size() / 2:  "+ (a.size() / 2));
        while(firstIndex < (a.size() / 2)){
            System.out.println("2current distance: "+ (secondIndex - firstIndex));

            if(a.get(secondIndex) == a.get(firstIndex)){
                if((secondIndex - firstIndex) < minDistance){
                    minDistance = secondIndex - firstIndex;
                }
                System.out.println("3current distance: "+ (secondIndex - firstIndex));
                numOfPairs++;
            }
            firstIndex++;
            secondIndex--;
        }
        if(numOfPairs == 0){
            return -1;
        }else{
            return minDistance;
        }
    }

}

public class MinimumDistances {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}