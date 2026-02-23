//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;
public class ShuffleMethods {

    static int[] slowShuffle (int N){
        int [] shuffled = new int[N];
        boolean [] isNotPresent = new boolean[N+1];

        for(int i =1 ;i<=N ;i++){
            isNotPresent[i]=true;
        }
        Random rand = new Random();
        int i=0;

        while(i< N-1 ){
            int r = rand.nextInt(N);

            if (isNotPresent[r]){
                shuffled[i]=r;
                isNotPresent[r]=false;
                i++;

            }
        }
        for(int k=1;k<=N;k++){
            if(isNotPresent[k]){
                shuffled[N-1]=k;
                break;
            }
        }

        return shuffled;
    }

    //_________________________________________________________________________________
    static int[] baisedShuffle(int N){
        int [] shuffled = new int[N];
        Random rand = new Random();

        for(int i =0 ; i < N ; i++){
            shuffled[i]=i+1;

        }
        for(int k=0;k < N ; k++){
            int r = rand.nextInt(N);

            int keep = shuffled[k];
            shuffled[k]=shuffled[r];
            shuffled[r]=keep;

        }
        return shuffled;
    //___________________________________________________________________________
    }
    static int[] unbaisedShuffle(int N){
        int[] B = new int[N];
        Random rand = new Random();

        for(int i =0 ; i < N ; i++){
            B[i]=i+1;

        }
        for(int k=0;k < N ; k++){
            int r = k+rand.nextInt(N-k);

            int keep = B[k];
            B[k]=B[r];
            B[r]=keep;

        }
        return B;
    }
    static String arrayToString(int[] arr) {
        return Arrays.toString(arr);
    }

    public static void main(String[] args) {
        int N = 3;
        int runs = 60000;

        Map<String, Integer> biasedCount = new HashMap<>();
        Map<String, Integer> unbiasedCount = new HashMap<>();

        for(int i = 0; i < runs; i++) {
            int[] b1 = ShuffleMethods.baisedShuffle(N);
            int[] b2 = ShuffleMethods.unbaisedShuffle(N);

            String s1 = arrayToString(b1);
            String s2 = arrayToString(b2);

            biasedCount.put(s1, biasedCount.getOrDefault(s1, 0) + 1);
            unbiasedCount.put(s2, unbiasedCount.getOrDefault(s2, 0) + 1);
        }

        System.out.println("Biased Shuffle Results:");
        for(String key : biasedCount.keySet())
            System.out.println(key + " -> " + biasedCount.get(key));

        System.out.println("\nUnbiased Shuffle Results:");
        for(String key : unbiasedCount.keySet())
            System.out.println(key + " -> " + unbiasedCount.get(key));
    }

}
