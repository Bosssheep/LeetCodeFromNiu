package WY;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Long[] arr = new Long[n];
        for(int i=0;i<n;i++){
           Long a = in.nextLong();
           if(i==0){
               arr[i] = a;
           }else{
               arr[i] = arr[i-1]+a;
           }
        }
        int m = in.nextInt();
        for(int i=0;i<m;i++){
            Long query = in.nextLong();
           /* int j=0;
            *//*while(j<n){
                if(query>arr[j]){
                    j++;
                }else{
                   System.out.println(++j);
                   j=n;
                }
            }*/
            int result = findIndex(arr,query);
            System.out.println(++result);
        }
    }
    public static int findIndex(Long[] arr,Long num){
        int left = 0;
        int right = arr.length-1;
        while(left <= right){
            int mid = (left+right)/2;
            if(mid==0){
                return 0;
            }
            if(num>arr[mid]){
                left = mid+1;
            }
            else if(num>arr[mid-1]){
                return mid;
            }
            else{
                right= mid-1;
            }
        }
        return 0;
    }
}
