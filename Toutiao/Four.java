package Toutiao;


import java.util.ArrayList;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> num = new ArrayList<Integer>(n+1);
        for(int i=0;i<n;i++){
           num.add(sc.nextInt());
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for(int j=0;j<m;j++){
            nums.addAll(num);
        }
        int i  = longestIncreasingSubsequence(nums.toArray(new Integer[n*m]));
    }
    public static  int put(ArrayList<Integer> arr, int l, int r, int key)//在arr[l...r]中二分查找插入位置
    {
        int mid;
        if (arr.get(r) <= key)
            return r + 1;
        while (l < r)
         {
          mid = l + (r - l) / 2;
          if (arr.get(mid) <= key)
             l = mid + 1;
          else
             r = mid;
           }
          return l;
    }

    public static  int LIS(ArrayList<Integer> A, int n){
        int i = 0, len = 1 ,next;
        ArrayList<Integer> B = new ArrayList<>(n+1);
        int s = A.get(0);
        B.add(0);
        B.add(s);

        for (i = 1;i < n;i++){
            next = put(B, 1, len, A.get(i));
            B.set(next,A.get(i));
            if (len < next)
                len = next;
        }
        return len;
    }
    public static  int longestIncreasingSubsequence(Integer[] nums) {
        // write your code here
        if(nums.length==0){
            return 0;
        }
        int dp[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]&&dp[j]+1>dp[i])
                    dp[i]=dp[j]+1;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            max=Math.max(max, dp[i]);
        }
        return max;
    }
}



