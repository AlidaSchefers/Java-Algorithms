import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/queens-attack-2/problem?isFullScreen=true
class Result {

    /*
     * Complete the 'queensAttack' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER k
     *  3. INTEGER r_q
     *  4. INTEGER c_q
     *  5. 2D_INTEGER_ARRAY obstacles
     */

    public static int queensAttack(int n, int numOfObstacles, int r_q, int c_q, List<List<Integer>> obstacles) {
        // Write your code here

        //initialize queensSpots to 0
        int queensSpots = 0;
        //have a loop for each direction of movement:
        //up
        //initialize new coordinates (curR, curC) from queen's. this will start one cell up, so curR is +1 queen's row
        int curR = r_q+1;
        int curC = c_q;
        //while curR <= n loop
        while(curR <= n){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR++;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR++
        //queensSpots++

        // System.out.println(obstacles);
        //down
        //initialize new coordinates (curR, curC) from queen's. this will start one cell down, so curR is -1 queen's row
        curR = r_q-1;
        curC = c_q;
        //while curR >= 1 loop
        while(curR >= 1){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR--;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR--
        //queensSpots++
        //left
        //initialize new coordinates (curR, curC) from queen's. this will start one cell left, so curC is -1 queen's col
        curR = r_q;
        curC = c_q-1;
        //while curC >= 1 loop
        while(curC >= 1){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curC--;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curC--
        //queensSpots++
        //right
        //initialize new coordinates (curR, curC) from queen's. this will start one cell right, so curC is +1 queen's col
        curR = r_q;
        curC = c_q+1;
        //while curC <= n loop
        while(curC <= n){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curC++;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curC++
        //queensSpots++
        //upper left diagonal
        //initialize new coordinates (curR, curC) base on the queen's
        curR = r_q+1;
        curC = c_q-1;
        //while curR <= n loop and curC >= 1 loop
        while(curR <= n && curC >= 1){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR--;
            curC++;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR--;
        //curC++
        //queensSpots++
        //upper right diagonal
        //initialize new coordinates (curR, curC) base on the queen's
        curR = r_q+1;
        curC = c_q+1;
        //while curR <= n loop and curC <= n loop
        while(curR <= n && curC <= n){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR++;
            curC++;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR++;
        //curC++
        //queensSpots++
        //lower left diagonal
        //initialize new coordinates (curR, curC) base on the queen's
        curR = r_q-1;
        curC = c_q-1;
        //while curR >= 1 loop and curC >= 1 loop
        while(curR >= 1 && curC >= 1){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR--;
            curC--;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR--;
        //curC--
        //queensSpots++
        //lower right diagonal
        //initialize new coordinates (curR, curC) base on the queen's
        curR = r_q-1;
        curC = c_q+1;
        //while curR >= 1 loop and curC >= 1 loop
        while(curR >= 1 && curC <= n){
            if(obstacles.contains(new ArrayList<>(Arrays.asList(curR, curC)))){
                break;
            }
            curR--;
            curC--;
            queensSpots++;
        }
        //if(obstacles.contains[curR, curC])
        //then break the loop
        //else,
        //curR--;
        //curC--
        //queensSpots++

        return queensSpots;
        // return 0;
    }

}

public class QueensAttack2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r_q = Integer.parseInt(secondMultipleInput[0]);

        int c_q = Integer.parseInt(secondMultipleInput[1]);

        List<List<Integer>> obstacles = new ArrayList<>();

        IntStream.range(0, k).forEach(i -> {
            try {
                obstacles.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

