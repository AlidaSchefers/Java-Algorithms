package CodeSignalArcade;

public class AddTwoDigits {
    int addTwoDigits(int n) { //pass in a two-digit number, and it adds the first digit and second digit (e.g. 29 -> 2+9 -> 11)
        String stringInt = String.valueOf(n);
        int firstInt = Character.getNumericValue(stringInt.charAt(0));
        int secondInt = Character.getNumericValue(stringInt.charAt(1));
        return firstInt + secondInt;
    }
}
