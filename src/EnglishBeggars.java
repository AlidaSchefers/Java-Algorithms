import java.util.Arrays;

public class EnglishBeggars {
    public class Kata{
        public int[] beggars(int[] values, int n) {
            //first get indexes where you can give to all of them
//     int[] smallerArr = values[0-4];

            //values stay the same
            //n becomes 3
//     n = 2;
            if(n <= 0){
                return new int[]{};
            }

            int[] beggarsEarnings = new int[n];
            int lengthForUnequalPortion = values.length % n;

//     System.out.println("values:");
//     System.out.println(Arrays.toString(values));
            int[] equalPortionArr = Arrays.copyOfRange(values, 0, values.length-lengthForUnequalPortion);
//     System.out.println(" equalPortionArr:");
//     System.out.println(Arrays.toString(equalPortionArr));

            int[] unequalPortionArr = Arrays.copyOfRange(values, values.length-(n-1), values.length);
//     System.out.println(" UNequalPortionArr:");
//     System.out.println(Arrays.toString(unequalPortionArr));

            for (int i = 0; i < equalPortionArr.length; i+=n){
//       System.out.println("inside loop");
                for (int j=0; j < n; j++){
//         System.out.println("inside loop2. j is "+j);

                    beggarsEarnings[j] += equalPortionArr[i+j];
                }
            }

            if(lengthForUnequalPortion > 0){
                for (int i = 0; i < lengthForUnequalPortion; i++){
                    beggarsEarnings[i] += unequalPortionArr[i];
                }
            }

//     System.out.println("beggarsEarnings:");
//     System.out.println(Arrays.toString(beggarsEarnings));
//     System.out.println("newArr:");
//     int[] newArray = Arrays.copyOfRange(values, 0, 5);
//     System.out.println(Arrays.toString(newArray));
//     System.out.println(newArray.length);
            return beggarsEarnings;
        }
    }
}
