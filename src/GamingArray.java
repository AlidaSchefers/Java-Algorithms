import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//come from HackerRank: https://www.hackerrank.com/challenges/an-interesting-game-1/problem
class Result {

    /*
     * Complete the 'gamingArray' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    //rules:
    //BOB always plays first.
    //last player who can make a move wins
    //input: game arr. output: the string of the name of the winner

    public static String gamingArray(List<Integer> arr) {
        //make first arr element the curMax
        int curMax = arr.get(0);
        //initialize the turn count to 1 (Bob's turn)
        int turnCount = 1; //Bob's first turn
        //iterate through the arr L -> R
        for(int num : arr){
            //when there is an element greater than the curMax, update curMax and increase turn count by 1.
            if(num > curMax){
                turnCount++;
                curMax = num;
            }
        }
        //if total turn count is odd, Bob wins. if total turn count is even, Andy wins
        return (turnCount % 2 == 0) ? "ANDY" : "BOB";
    }

}

public class GamingArray {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, g).forEach(gItr -> {
            try {
                int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                String result = Result.gamingArray(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

