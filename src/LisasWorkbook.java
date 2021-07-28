import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

//comes from HackerRank: https://www.hackerrank.com/challenges/lisa-workbook/problem
class Result {

    public static int workbook(int chapters, int problemsPerPage, List<Integer> problemsPerChapterArr) {
        int specialProbCount = 0;
        int curPage = 1;
        for(int i = 0; i < problemsPerChapterArr.size(); i++){ //chapter
            int chapterProbs = problemsPerChapterArr.get(i);

            for(int curProb = 1; curProb <= chapterProbs; curProb++){ // problem
                if(curProb == curPage){
                    specialProbCount++;
                }
                if(curProb == chapterProbs || (curProb % problemsPerPage == 0)){
                    curPage++;
                }
            }

        }
        return specialProbCount;
    }

}

public class LisasWorkbook {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.workbook(n, k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
