import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static long stockmax(List<Integer> prices) {
        // initialize long variable to store total gained
        long totalGained = 0;
        // find highest price index
        int highestPriceIndex = prices.indexOf(Collections.max(prices));
        if()
        for(int i = 0; i <= highestPriceIndex; i++){
            // iterate through initial collection prices up to highest price. 0 through max price i
            //     if index of max price is bigger than 1:
            //       spent += price at current index
            //       when you get to the max price index, sell all current shares
            //       sold = price * (max price i)
            //       total gained += sold - spent
        }
        if(prices.size() - highestPriceIndex > 0) { //if there are still prices left after the current highest price in the collection
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
