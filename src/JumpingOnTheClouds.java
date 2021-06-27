import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
class Result {

    public static int jumpingOnClouds(List<Integer> c) {
        //start with index 0, so initialize i to 0.
        int i = 0;
        //initialize jumps to 0.
        int jumps = 0;
        //keep loop going until the index i becomes that of the last element (top cloud)
        while(i < c.size()-1){
            //if i is equal to c.size()-2 (index of second to last cloud)
            if(i == c.size()-2){
                //increase jumps count by 1
                jumps++;
                //break
                break;
            }else{
                //increase jumps count by 1
                jumps++;
                //new value of i is i+2 if value at index i+2 is 0. else, it is i+1.
                i = (c.get(i+2) == 0) ? i+2 : i+1;
            }
        }
        return jumps;
    }
}

public class JumpingOnTheClouds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> c = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.jumpingOnClouds(c);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

