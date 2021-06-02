//comes from LeetCode: https://leetcode.com/problems/count-and-say/
public class CountAndSay {
    public String countAndSay(int n) { //completed with several devs, and the code inside the say method comes from my pseudocode
        //if n == 1, return "1";
        if(n==1) return "1";
        //return say(countAndSay(n-1))
        return say(countAndSay(n-1));
    }

    //String say(String string)
    String say(String str){
        //initialize count = 0
        int count = 0;
        //initialize curNum (currentNumber) to first character of string
        char curNum = str.charAt(0);
        //initialize newStr = ""
        String newStr = "";
        //iterate through chars of string
        for(char curChar : str.toCharArray()){
            //if curChar == cur=Num
            if(curChar == curNum){
                //count++
                count++;
            } else{
                //else
                //add String value of count and curNum to newStr
                newStr = newStr.concat(String.valueOf(count) + curNum);
                //curNum = curChar
                curNum = curChar;
                //count = 1
                count = 1;
            }
        }
        //add String value of count and String value of curNum to newStr
        newStr = newStr.concat(String.valueOf(count) + curNum);
        //return newStr
        return newStr;
    }
}
