
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

        //initialize altitude to 0;
        int altitude = 0;
        //boolean isInValley = false;
        boolean isInValley = false;
        //boolean isInMountain = false;
        boolean isInMountain = false;
        //int valleyCount = 0;
        int valleyCount = 0;
        //loop through string characters. if U, increase altitude by 1. if D, descrease altitude by 1.
        for(int i = 0; i < steps; i++){
            if(path.charAt(i) == 'U'){
                altitude++;
            }else{
                altitude--;
            }
            // System.out.println("altitude: "+altitude);
            // System.out.println("isInValley: "+isInValley);
            // System.out.println("isInMountain: "+isInMountain);
            //if altitude positive: isInMountain = true;
            if(altitude > 0){
                isInMountain = true;
            }else if(altitude < 0){ //if altitude negative: isInValley = true;
                isInValley = true;
            }else{ //if altitude is 0
                if(isInValley == true){
                    //valleyCount++
                    valleyCount++;
                    //isInValley = false;
                    isInValley = false;
                }
                //if isInMountain is true:
                if(isInMountain == true){
                    //isInMountain = false;
                    isInMountain = false;
                }
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
