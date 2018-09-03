package Toutiao;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class One {

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> table = new ArrayList<>();
            for(int i = 1;i<=n;i++){

                ArrayList<Integer> temp = new ArrayList<>();
                int m ;
                while((m = sc.nextInt()) != 0){
                    temp.add(m);
                }
                table.add(temp);
            }
            int result = 0;
            HashMap<Integer,Boolean> flag = new HashMap<Integer, Boolean>();
            for(int i=1;i<=n;i++){
                ArrayList<Integer> temp = table.get(i);
                int len = temp.size();
                if(len==0){
                    result++;
                    continue;
                }else{

                }

            }
        }

}
