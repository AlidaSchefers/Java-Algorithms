import java.util.Arrays;

//comes from Codility

public class PermMissingElem {
    public int solution(int[] A) {
        // write your code in Java SE 8

        //second solution:
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
