package JavaInterviewPractice;

import java.util.Arrays;

//comes from Codility

public class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8

        //second solution.
        //this gives linear run-time complexity O(n), and for memory O(1)
        int sumOfArray = 0;
        for (int i = 0; i < A.length; i++){
            sumOfArray += A[i];
        }
        int sumWithoutMissingNum = 0;
        for (int i = A.length+1; i > 0; i--){
            sumWithoutMissingNum += i;
        }
        return sumWithoutMissingNum - sumOfArray;
        //end of second solution

//        //can make the function event faster by using a "sum to x function" (x*(x+1))/2 instead of a loop:
//        //time complexity is still O(n).
//        int sumOfArray = 0;
//        for (int i = 0; i < A.length; i++){
//            sumOfArray += A[i];
//        }
//        int sumWithoutMissingNum = ((A.length+1 * (A.length+1+1))/2);
//        return sumWithoutMissingNum - sumOfArray;


//        //first solution:
//         Arrays.sort(A);
//         int currentCount = 1;
//         for (int i = 0; i < A.length; i++){
//             if(currentCount != A[i]){
//                 return currentCount;
//             }else{
//                 currentCount++;
//             }
//         }
//         return 0; //should never return.
//        //end of first solution
    }
}
