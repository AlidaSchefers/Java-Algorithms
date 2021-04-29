import java.util.ArrayList;
//comes from CodeWars: https://www.codewars.com/kata/5264d2b162488dc400000001/java

public class SpinWords {

    public String reverseWord(String word){
        String[] wordArr = word.split("");
        ArrayList<String> reverseWordList = new ArrayList<String>();
        for (int i = wordArr.length-1; i >= 0; i--){ //start at end of wordArr
            reverseWordList.add(wordArr[i]);
        }
        String reverseWordStr = "";
        for(Object str:reverseWordList){
            reverseWordStr += str;
        }
        return reverseWordStr;
    }

    public String spinWords(String sentence) {
        //TODO: Code stuff here
        String[] wordsArr = sentence.split(" ");
        //reverse the words that are 5 or more in length
        for (int i = 0; i < wordsArr.length; i++){
            if(wordsArr[i].length() > 4){
                wordsArr[i] = reverseWord(wordsArr[i]);
            }
        }

        String reverseSentence = "";
        //make a string of the new sentence from the ArrayList
        for(int i = 0; i < wordsArr.length; i++){
            reverseSentence += wordsArr[i];
            if(i != wordsArr.length-1){
                reverseSentence += " "; //add back in the spaces between words
            }
        }
        return reverseSentence;
    }
}