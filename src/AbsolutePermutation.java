
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;


//comes from HackerRank: https://www.hackerrank.com/challenges/absolute-permutation/problem?isFullScreen=true

//the two solutions solve 9/11 test cases and exceeds the time limit for the last two test cases

//creates the list from first value to last.
//class Result {
//     public static List<Integer> absolutePermutation(int n, int k) {
//     //3 conditions/rules
//         //1. are both num in the range? 1-n
//         //yes: take lower num
//         //2. always take lower num
//         //3. no repeats.
//         //1. no repeats, 2. num is in range, 3. take lower num unless break 1 or 2, 4. if no num available, return list of -1.
//         List<Integer> PermutationList = new ArrayList<Integer>();
//         int[] availability = new int[n];
//         for(int i = 0; i < n; i++){
//             availability[i] = 1;
//         }
//         int i = 1;
//         while(i <= n){
//             int option1 = i+k;
//             int option2 = i-k;
//             //decide which option to add to PermutationList or return list with just -1.
//             boolean option1IsValid = (option1 <= n && option1 > 0 && availability[option1-1] == 1) ? true : false;
//             boolean option2IsValid = (option2 <= n && option2 > 0 && availability[option2-1] == 1) ? true : false;
//             int valToAdd;
//             if(option1IsValid && option2IsValid){
//                 valToAdd = (option1 < option2) ? option1 : option2;
//                 System.out.println("valToAdd: "+valToAdd);
//                 PermutationList.add(valToAdd);
//                 availability[valToAdd-1]--;
//                 i++;
//             }else if(!option1IsValid && !option2IsValid){
//                 return new ArrayList<Integer>(Arrays.asList(-1));
//             }else{ //only one of the options is valid
//                 valToAdd =  (option1IsValid) ? option1 : option2;
//                 PermutationList.add(valToAdd);
//                 availability[valToAdd-1]--;
//                 i++;
//             }

//         }
//         //after while loop
//         return PermutationList;
//     }

// }

//creates list from last element to first.
class Result {
    public static List<Integer> absolutePermutation(int n, int k) {
        List<Integer> PermutationList = new ArrayList<Integer>();
        int[] availability = new int[n];
        // System.out.println(Arrays.toString(availability));
        // System.out.println(availability);
        int i = n;
        while(i > 0){
            int option1 = i+k;
            int option2 = i-k;
            //decide which option to add to PermutationList or return list with just -1.
            boolean option1IsValid = (option1 <= n && option1 > 0 && availability[option1-1] == 0) ? true : false;
            boolean option2IsValid = (option2 <= n && option2 > 0 && availability[option2-1] == 0) ? true : false;
            int valToAdd;
            if(option1IsValid && option2IsValid){
                valToAdd = (option1 > option2) ? option1 : option2;
                PermutationList.add(0, valToAdd);
                availability[valToAdd-1] = 1;
                i--;
            }else if(!option1IsValid && !option2IsValid){
                return new ArrayList<Integer>(Arrays.asList(-1));
            }else{ //only one of the options is valid
                valToAdd = (option1IsValid) ? option1 : option2;
                PermutationList.add(0, valToAdd);
                availability[valToAdd-1] = 1;
                i--;
            }

        }
        //after while loop
        return PermutationList;
    }

}

public class AbsolutePermutation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> result = Result.absolutePermutation(n, k);

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