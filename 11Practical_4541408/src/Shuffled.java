import java.util.*;
public class Shuffled {
    public static void main (String[] args){
        int [] arr1 = ShuffleMethods.slowShuffle(3);
        System.out.println("Slow Shuffle");
        System.out.println(Arrays.toString(arr1));

        int [] arr2 = ShuffleMethods.baisedShuffle(3);
        System.out.println("biased shuffle");
        System.out.println(Arrays.toString(arr2));

        int [] arr3 = ShuffleMethods.unbaisedShuffle(3);
        System.out.println("unbiased shuffle");
        System.out.println(Arrays.toString(arr3));

        // Random random = new Random();
       // int r= random.nextInt()+1;
      //  System.out.println(r);
    }
}
