
import java.io.*;

//comes from HackerRank: https://www.hackerrank.com/challenges/counting-valleys/problem
class Result {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        //problem notes:
        //Hikes always start and end at sea level
        //mountain: sequence of consecutive steps above sea level, starting with a step up from sea level and ending with a step down to sea level.
        //valley: sequence of consecutive steps below sea level, starting with a step down from sea level and ending with a step up to sea level.
        //find and print the number of valleys walked through.

        //starting altitude is 0.
        int altitude = 0;
        //initialize valleyCount to 0
        int valleyCount = 0;
        for(int i = 0; i < steps; i++){
            //if character is U, "uphill"
            if(path.charAt(i) == 'U'){
                if(altitude == -1){ //if you are stepping up OUT OF A VALLEY AND ONTO THE FLAT GROUND,
                    //add a valley to the count
                    valleyCount++;
                }
                //increase altitude by 1.
                altitude++;
            }else{ //if character is D, "downhill"
                //decrease altitude by 1
                altitude--;
            }
        }
        //return valleyCount;
        return valleyCount;
    }

}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
