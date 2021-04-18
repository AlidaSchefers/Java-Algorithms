package CodeSignalArcade;

public class LargestNumber {
    int largestNumber(int n) {
        String largestNum = "";
        for (int i = 0; i < n; i++) {
            largestNum += "9";
        }
        return Integer.parseInt(largestNum);
    }

}
