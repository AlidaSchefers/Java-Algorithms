import java.util.*;

//comes from testdome: https://www.testdome.com/questions/27740?generatorId=24&questionIds=54678,35478,27740&type=FromTest

public class MergeNames {

    public static String[] uniqueNames(String[] names1, String[] names2) {
        Set<String> uniqueNamesSet = new HashSet<String>();
        for(String name : names1){
            //System.out.println(name);
            uniqueNamesSet.add(name);
        }
        for(String name : names2){
            uniqueNamesSet.add(name);
        }

        System.out.println(uniqueNamesSet);
        return uniqueNamesSet.toArray(new String[uniqueNamesSet.size()]);
        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}
