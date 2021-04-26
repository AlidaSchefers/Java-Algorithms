package ComputationalLogicAlgos;//from HackerRank: https://www.hackerrank.com/challenges/organizing-containers-of-balls/problem

import java.io.*;
import java.util.*;

class Result {
    static List<Integer> calcContainerSizes(List<List<Integer>> container){
        List<Integer> containerSizes = new ArrayList<Integer>();
        for (int r = 0; r < container.size(); r++){
            int currentContainerSize = 0;
            for (int i = 0; i < container.get(r).size(); i++){
                currentContainerSize += container.get(r).get(i);
            }
            containerSizes.add(currentContainerSize);
        }
        return containerSizes;
    }
    static List<Integer> calcBallTypeTotals(List<List<Integer>> container){
        List<Integer> BallTypeTotals = new ArrayList<Integer>();
        for (int ballIndex = 0; ballIndex < container.get(0).size(); ballIndex++){
            int currentBallTypeSum = 0;
            for (int i = 0; i < container.size(); i++){ //go to each sub-array
                currentBallTypeSum += container.get(i).get(ballIndex);
            }
            BallTypeTotals.add(currentBallTypeSum);
        }
        return BallTypeTotals;
    }
    static Map<Integer, Integer> makeHashMapOfContainerOccurances(List<List<Integer>> container){
        Map<Integer, Integer> containerOccurancesBySize = new HashMap<Integer, Integer>(); //key: the container size, value: the number of containers with that size
        for(int i = 0; i < calcContainerSizes(container).size(); i++){
            if(containerOccurancesBySize.get(calcContainerSizes(container).get(i)) != null){ //there is already a key value, just add 1 to
                containerOccurancesBySize.put(new Integer(calcContainerSizes(container).get(i)), containerOccurancesBySize.get(calcContainerSizes(container).get(i))+1);
            }else{ //there is not yet a key value; make one
                containerOccurancesBySize.put(calcContainerSizes(container).get(i), 1);
            }
        }
        return containerOccurancesBySize;
    }

    public static String organizingContainers(List<List<Integer>> container) {
        // Write your code here
        List<Integer> ballTypeTotalsList = calcBallTypeTotals(container);
        Map<Integer, Integer> hashMapOfContainerOccurances = makeHashMapOfContainerOccurances(container);

        //compare the total of a ball type with the num of available containers of the particular size needed for that ball type
        for(int i = 0; i < ballTypeTotalsList.size(); i++){
            if(hashMapOfContainerOccurances.get(ballTypeTotalsList.get(i)) == null || hashMapOfContainerOccurances.get(ballTypeTotalsList.get(i)) == 0){ //if the value is either null or 0 (i.e. there is no container with the right size)
                return "Impossible";
            }else{ //if there is a container of the size needed for this ball type total
                //reduce value of this key by 1 --> one less container is available
                hashMapOfContainerOccurances.put(new Integer(ballTypeTotalsList.get(i)), (hashMapOfContainerOccurances.get(ballTypeTotalsList.get(i))+1));
            }
        }
        return "Possible";
    }
}

public class OrganizingContainersOfBalls {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<List<Integer>> container = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] containerRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                List<Integer> containerRowItems = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowTempItems[j]);
                    containerRowItems.add(containerItem);
                }

                container.add(containerRowItems);
            }

            String result = Result.organizingContainers(container);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
