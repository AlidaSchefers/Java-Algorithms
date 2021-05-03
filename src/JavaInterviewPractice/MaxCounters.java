package JavaInterviewPractice;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        // write your code in Java SE 8
        int[] counters = new int[N];
        int startLine = 0;
        int currentMax = 0;
        for(int x : A) {
            int index = x - 1;
            if (x > N) startLine = currentMax;
            else if (counters[index] < startLine) counters[index] = startLine + 1;
            else counters[index] += 1;
            if (x <= N && counters[index] > currentMax) currentMax = counters[index];
        }
        for(int i = 0; i < counters.length; i++){
            if (counters[i] < startLine) {counters[i] = startLine;}
        }
        return counters;
    }
}

//less efficient version:
//public class MaxCounters {
//    public int[] solution(int N, int[] A) {
//        // write your code in Java SE 8
//        int[] counters = new int[N];
//        int largestNum = 0;
//        for(int i = 0; i < A.length; i++){
//            if(A[i] <= N){
//                counters[A[i]-1]++;
//                if(counters[A[i]-1] > largestNum) {largestNum = counters[A[i]-1];}
//            }else{ //A[i] = N+1
//                for(int j = 0; j < counters.length; j++){
//                    counters[j] = largestNum;
//                }
//            }
//        }
//        return counters;
//    }
//}
