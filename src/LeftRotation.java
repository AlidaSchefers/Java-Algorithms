
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> rotLeft(List<Integer> arr, int rotations) {
        //if rotations is 0, return the array as is.
        if(rotations == 0){
            return arr;
        }
        //get remainder of rotations divided by the array length (using % modulo)
        int rotRemainder = rotations % arr.size();
        //if the remainder is 0, return the array as is.
        if(rotRemainder == 0){
            return arr;
        }else{
            //else: add the remainder number of first elements to the end of the array, then delete that remainder number of first elements in the array.
            for(int i = 1; i <= rotRemainder; i++){
                arr.add(arr.get(0));
                arr.remove(0);
            }
        }
        //return the array
        return arr;
    }

}

public class LeftRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.rotLeft(a, d);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
