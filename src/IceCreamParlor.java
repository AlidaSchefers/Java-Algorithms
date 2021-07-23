
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static List<Integer> icecreamParlor(int pocketMoney, List<Integer> prices) {
        List<Integer> toBuyIndeces = new ArrayList<Integer>();
        for(int i = 0; i < prices.size(); i++){
            if(prices.get(i) < pocketMoney){
                for(int j = i+1; j < prices.size(); j++){
                    if(prices.get(i) + prices.get(j) == pocketMoney){

                        if(i < j){
                            toBuyIndeces.add(i+1);
                            toBuyIndeces.add(j+1);
                        }else{
                            toBuyIndeces.add(j+1);
                            toBuyIndeces.add(i+1);
                        }
                        return toBuyIndeces;
                    }
                }
            }
        }
        return toBuyIndeces;
    }

}

public class IceCreamParlor {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

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
