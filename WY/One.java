package WY;

/**
 * n列 m个方块
 */

import java.util.HashMap;
import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();

        HashMap<Integer,Integer> arr = new HashMap<>(1001);
        for(int i =  0;i<m;i++){
            int temp = in.nextInt();
            if(arr.containsKey(temp)){
                int value = arr.get(temp);
                arr.put(temp,++value);
            }
            else{
                arr.put(temp,1);
            }
        }

        int min = 1001;
        for(int i = 1;i<=n;i++){
            int value = arr.get(i);
            min = Math.min(min,value);
        }
        System.out.println(min);
    }
}
