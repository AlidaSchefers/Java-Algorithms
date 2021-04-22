import java.util.Arrays;

//from Codility
public class TapeEquilibrium {

//    //my original solution:
//    int getSum(int[] A){
//        int sum = 0;
//        for(int i = 0; i < A.length; i++){
//            sum += A[i];
//        }
//        return sum;
//    }
//
//    public int solution(int[] A){
//        int leftSideCount = 0;
//        int rightSideCount = getSum(A);
//        int smallestDifference = Math.abs(A[0]-(rightSideCount-A[0]));
//        for (int P = 1; P < A.length; P++){
//            leftSideCount += A[P-1];
//            rightSideCount -= A[P-1];
//            if(Math.abs(leftSideCount-rightSideCount) < smallestDifference){
//                smallestDifference = Math.abs(leftSideCount-rightSideCount);
//            }
//        }
//        return smallestDifference;
//    }
//    //end of original solution.

    //other solution
    public int solution(int[] A){
        int leftSideSum = A[0];
        int rightSideSum = 0;
        for (int x : A) rightSideSum += x;
        rightSideSum -= leftSideSum;
        int smallestDifference = Math.abs(leftSideSum-rightSideSum);
        for (int P = 1; P < A.length - 1; P++){
            leftSideSum += A[P];
            rightSideSum -= A[P];
            if(Math.abs(leftSideSum-rightSideSum) < smallestDifference){
                smallestDifference = Math.abs(leftSideSum-rightSideSum);
            }
        }
        return smallestDifference;
    }
}
