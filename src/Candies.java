import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//comes from HackerRank: https://www.hackerrank.com/challenges/candies/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */
    public static int getArrSum(int[] array){
        int sum = 0;
        for(int i = 0; i < array.length; i++){
            sum += array[i];
        }
        return sum;
    }

    public static int[] candiesReverse(List<Integer> arr, int[] distribution, int index){
        int i = index;
        while(i > 0 && arr.get(i-1) > arr.get(i)){
            distribution[i-1] = distribution[i] + 1;
        }
        return distribution;
    }

    public static long candies(int n, List<Integer> arr) {
        // Write your code here
        int[] distribution = new int[n];
        distribution[0] = 1;
        System.out.println(Arrays.toString(distribution));
        for(int i = 0; i < arr.size()-1; i++){
            if(arr.get(i) < arr.get(i+1)){
                distribution[i+1] = distribution[i]+1;
                System.out.println(arr.get(i)+" < "+arr.get(i+1)+", so assign "+(distribution[i]+1)+" to the student with "+arr.get(i+1));
                System.out.println(Arrays.toString(distribution));
            }
            if(arr.get(i) > arr.get(i+1) && distribution[i] > 1){
                distribution[i+1] = 1;
                // System.out.println(Arrays.toString(distribution));
                System.out.println(arr.get(i)+" > "+arr.get(i+1)+" and i[b] > 1");
            }
            if(arr.get(i) > arr.get(i+1) && distribution[i] == 1){
                System.out.println(arr.get(i)+" > "+arr.get(i+1)+" and i[b] == 1");

                distribution[i+1] = 1;
                int newIndex = i+1;
                while(newIndex > 0 && arr.get(newIndex-1) > arr.get(newIndex)){
                    // System.out.println("number that triggered: "+arr.get(newIndex));
                    // System.out.println("number before: "+arr.get(newIndex-1));
                    System.out.println("newIndex: "+newIndex);
                    System.out.println("Left value: "+arr.get(newIndex-1));
                    System.out.println("Right value: "+arr.get(newIndex));
                    if(distribution[newIndex-1] <= distribution[newIndex]){
                        distribution[newIndex-1] = distribution[newIndex] + 1;
                    }
                    // distribution[newIndex-1] = distribution[newIndex] + 1;
                    newIndex--;
                    // System.out.println(Arrays.toString(distribution));
                }
            }
            if(arr.get(i) == arr.get(i+1)){
                distribution[i+1] = 1;
            }
        }
        System.out.println(Arrays.toString(distribution));
        return getArrSum(distribution);
    }

}

public class Candies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(bufferedReader.readLine().trim());
            arr.add(arrItem);
        }

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
