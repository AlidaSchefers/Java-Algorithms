import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;

//comes from HackerRank: https://www.hackerrank.com/challenges/bonetrousle/problem
class Result {
    public static List<Long> bonetrousle(long n, long k, int b) {
        //Pseudocode:
        // Make a list with default values
        // Add the numbers 1 through and including b in the list
        // calculate the sum of this collect
        //if the sum is greater than N,
            // return a list of -1
        //if the sum is equal to N
            // return the current list
        //if the sum is less than N:
            //calculate the difference between N (our goal) and the sum.
            //add the difference + the last element of the list.
            //if this new num is less than or equal to K, make the last element this new number and return the list
            //if the new num is greater than K, set the element to the value of K and decrease K by 1.
            //repeat with the previous element in the list
            //if we run out of elements, return list of -1.

        public static List<Long> bonetrousle(long n, long k, int b) {
            // Make a list with default values
            ArrayList<Long> boxesToBuy = new ArrayList<Long>();
            long curStickTotal = 0;

            // Add the numbers 1 through and including b in the list
            for (long i = 1; i <= b; i++){
                boxesToBuy.add(i);
                // calculate the sum of this collect
                curStickTotal += i;
            }
            System.out.println(boxesToBuy);
            System.out.println("curStickTotal: "+curStickTotal);
            //if the sum is greater than N, return a list of -1
            if(curStickTotal > n){
                ArrayList<Long> impossible = new ArrayList<Long>(Arrays.asList((long)-1));
                return impossible;
            }
            //if the sum is equal to N, return the current list
            if(curStickTotal == n){
                return boxesToBuy;
            }
            //if the sum is less than N
            if(curStickTotal < n){
                int boxToModifyIndex = b-1;
                while(boxToModifyIndex >= 0){
                    //calculate the difference between N (our goal) and the sum.
                    long neededStickIncrease = n - curStickTotal;
                    //add the difference + the (last) element of the list.
                    long newStickBox = boxesToBuy.get(boxToModifyIndex) + neededStickIncrease;
                    //if this new num is less than or equal to K, make the (last) element this new number and return the list
                    if(newStickBox <= k){
                        boxesToBuy.set(boxToModifyIndex, newStickBox);
                        return boxesToBuy;
                        //if the new num is greater than K, set the element to the value of K and decrease K by 1.
                    }else{ //if new num is greater k
                        boxesToBuy.set(boxToModifyIndex, k);
                        k--;
                        //repeat with the previous element in the list
                        boxToModifyIndex--;
                    }
                }
            }
            //if we run out of elements, return list of -1.
            ArrayList<Long> impossible = new ArrayList<Long>(Arrays.asList((long)-1));
            return impossible;
        }

    }

}

public class Bonetrousle {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                long n = Long.parseLong(firstMultipleInput[0]);

                long k = Long.parseLong(firstMultipleInput[1]);

                int b = Integer.parseInt(firstMultipleInput[2]);

                List<Long> result = Result.bonetrousle(n, k, b);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

