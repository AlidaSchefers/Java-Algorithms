import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/stockmax/problem
class Result {

    public static long stockmax(List<Integer> prices) {
        // initialize long variable to store total gained
        long spent = 0;
        // find highest price index
        int highestPriceIndex = prices.indexOf(Collections.max(prices));
        for(int i = 0; i < highestPriceIndex; i++){
            spent += prices.get(i);
        }
        long sold = prices.get(highestPriceIndex) * (long) highestPriceIndex;
        long totalGained = sold - spent;
        if(prices.size() - highestPriceIndex > 1) { //if there are still prices left after the current highest price in the collection
            return totalGained + stockmax(prices.subList(highestPriceIndex+1, prices.size()));
        }else{ //the current highest price is the last element of the array
            return totalGained;
        }
    }

}

public class StockMaximize {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                long result = Result.stockmax(prices);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
