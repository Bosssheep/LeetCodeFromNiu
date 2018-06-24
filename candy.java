import java.util.ArrayList;
import java.util.Arrays;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
      Each child must have at least one candy.
      Children with a higher rating get more candies than their neighbors.
 */
public class candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        if(ratings == null || len==0){
            return 0;
        }

        int[] count = new int[len];
        Arrays.fill(count ,1);
        int sum = 0;

        for(int i = 1;i < len;i++){
            if(ratings[i-1] < ratings[i])
                count[i] = count[i-1]+1;
        }
        for(int i=len-1;i > 0;i--){
            sum += count[i];
            if(ratings[i-1] > ratings[i] && count[i-1] <= count[i]){
                count[i-1] = count[i] + 1;
            }
        }
        sum += count[0];
        return sum;
    }
}
