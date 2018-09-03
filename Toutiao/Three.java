package Toutiao;

import java.util.ArrayList;
import java.util.Scanner;

public class Three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0;i<n;i++){
            int m = sc.nextInt();
            ArrayList<String>  stringList = new ArrayList<>();
            for(int j=0;j<m;j++){
                stringList.add(sc.next());
            }

            String str1;
            String str2;
            String str3;
            int flag = 0;
            for(int j=0;j<m-1;j++){
                if(flag==1){
                    break;
                }
               for(int k=j+1;k<m;k++){
                    if(flag==1){
                        break;
                    }
                   str1 = stringList.get(j);
                   str2 = stringList.get(k);
                   str3 = reverseStringBuilder(str1);
                   for(int p = 0;p<str2.length();p++){
                       String rotateString = LeftRotateString(str2,p);
                       if(str1.equals(rotateString)||str3.equals(rotateString)){
                           System.out.println("Yeah");
                           flag=1;
                           break;
                       }
                   }

               }
            }

        }
    }
    static String LeftRotateString(String str, int n) {
        if(n<=0||str.length()==0)
            return str;
        int len=str.length();
        n=n%len;
        str+=str;
        return str.substring(n,n+len);
    }

    public static String reverseStringBuilder(String s) {
        StringBuilder sb = new StringBuilder(s);
        String afterreverse = sb.reverse().toString();
        return afterreverse;
    }
}
