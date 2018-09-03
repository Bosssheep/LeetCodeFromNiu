package pinduoduo;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class fenyunhuoche {
    public static void main(String[] args) {
        System.out.println("start");
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> arrays = new ArrayList<>();
        while (in.hasNext()) {//注意while处理多个case\
            int a = in.nextInt();
            arrays.add(a);

        }
        int n = arrays.size();
        int weight = 300;
        Collections.sort(arrays);
        int left = 0;
        int right=n-1;
        int num=0;
        int tmpweight=0;
        while(left<right){
            if(tmpweight-arrays.get(left)>weight && tmpweight-arrays.get(right)>weight){
                tmpweight=0;
                num++;
            }
            if(tmpweight-arrays.get(left)<weight){
                tmpweight-=arrays.get(left);
                left++;
            }
            if(tmpweight-arrays.get(right)<weight){
                tmpweight-=arrays.get(right);
                right--;
            }

        }
        System.out.println(num);
    }
}
