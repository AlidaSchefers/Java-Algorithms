package ComputationalLogicAlgos;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//from HackerRank: https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem

class Result {
    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
        // Write your code here
        //creating new arrays
        List<Integer> rankedPlaces = new ArrayList<Integer>(); //e.g. [1, 2, 3, 4, 5] places
        List<Integer> newRanked = new ArrayList<Integer>(); //will be a new scoreboard without duplicates. e.g. [100, 50, 40, 20, 10]
        int currentRankedScore = ranked.get(0) + 1;
        int currentRankedPlace = 1;
        for (int i = 0; i < ranked.size(); i++){
            if(ranked.get(i) < currentRankedScore){
                newRanked.add(ranked.get(i));
                currentRankedScore = ranked.get(i);
                rankedPlaces.add(currentRankedPlace++);
            }
        }

        //finding the player's rankings.
        int newRankedIndex = newRanked.size()-1; //starts at the end
        List<Integer> playerRanked = new ArrayList<Integer>();
        for (int i = 0; i < player.size(); i++){
            while(true){
                if(player.get(i) < newRanked.get(newRankedIndex)){
                    playerRanked.add(rankedPlaces.get(newRankedIndex)+1);
                    break;
                }else if (newRankedIndex > 0){ //prevents the index from becoming -1
                    newRankedIndex--;
                }else{ //if the score is not smaller than the top score on the scoreboard, then it gets #1
                    playerRanked.add(1);
                    break;
                }
            }
        }
        return playerRanked;
    }
}

public class ClimbingTheLeaderboard {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
