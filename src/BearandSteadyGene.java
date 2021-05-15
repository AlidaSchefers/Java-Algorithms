
import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

    public static boolean isAllZero(HashMap<Character, Integer> hm){
        for (Integer i : hm.values()) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static int steadyGene(String gene) {
        // Write your code here
        HashMap<Character, Integer> letterInstances = new HashMap<Character, Integer>();
        letterInstances.put('A', 0);
        letterInstances.put('C', 0);
        letterInstances.put('T', 0);
        letterInstances.put('G', 0);
        for(int i = 0; i < gene.length(); i++){
            letterInstances.replace(gene.charAt(i), letterInstances.get(gene.charAt(i))+1);
        }

        // System.out.println(letterInstances);
        HashMap<Character, Integer> overRepLetters = new HashMap<Character, Integer>();
        letterInstances.forEach((k, v) -> {
            if(v > (gene.length()/4)){
                overRepLetters.put(k, (v - (gene.length()/4)));
            }
        });

        //shows that the hashmaps are created correctly
//        System.out.println("letterInstances:");
//        for (Map.Entry entry : letterInstances.entrySet()) {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }
//        System.out.println("overrep:");
//        for (Map.Entry entry : overRepLetters.entrySet()) {
//            System.out.println(entry.getKey() + ", " + entry.getValue());
//        }

        int smallestSubString = gene.length();
        for(int i = 0; i < gene.length(); i++){
            System.out.println("current character: "+gene.charAt(i));
            System.out.println("current character is overrep: "+(overRepLetters.containsKey(gene.charAt(i))));
            if(overRepLetters.containsKey(gene.charAt(i))){
                HashMap<Character, Integer> tempOverRepLetters = overRepLetters;
                int index = i;
                int substringLength = 0;
                while(!isAllZero(tempOverRepLetters) && index != gene.length()){
                    System.out.println("is current character "+gene.charAt(index)+" overrep? "+(tempOverRepLetters.containsKey(gene.charAt(index))));
                    if(tempOverRepLetters.containsKey(gene.charAt(index))){
                        tempOverRepLetters.replace(gene.charAt(index), tempOverRepLetters.get(gene.charAt(index))-1);
                        substringLength++;
                        index++;
                    }else{
                        substringLength++;
                        index++;
                    }
                }
                if(substringLength < smallestSubString) {
                    smallestSubString = substringLength;
                }
            }
        }

        return 5; //temporary
    }

}

public class BearandSteadyGene {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
