public class ExesAndOhs { //comes from CodeWars: https://www.codewars.com/kata/55908aad6620c066bc00002a/java
    public static boolean getXO (String str) {

        // Good Luck!!
        str = str.toLowerCase();
        int numOfOhs = 0;
        int numOfExes = 0;
        for(int i = 0; i < str.length(); i++){ //iterate through the string, looking at each char
            if(str.charAt(i) == 'o') {numOfOhs++;} //if the current char is 'o', increase numOfOhs by 1
            if(str.charAt(i) == 'x') {numOfExes++;}
        }
        return (numOfOhs == numOfExes); //true if same num of x's and o's present in the string

    }
}