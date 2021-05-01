import java.util.Arrays;

//from CodeWars: https://www.codewars.com/kata/584dc1b7766c2bb158000226
public class SuzukisChores {
    public static int[] choreAssignments(int[] chores)
    {
        Arrays.sort(chores);
        int[] studentsChoreTimes = new int[chores.length/2];
        for (int i = 0; i < chores.length/2; i++){
            //add up the least and most time-consuming tasks and go inward in the next round
            studentsChoreTimes[i] = chores[i] + chores[chores.length-1-i];
        }
        Arrays.sort(studentsChoreTimes);
        return studentsChoreTimes;
    }
}
