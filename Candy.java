/**
 * There are N children standing in a line. Each child is assigned a rating
 * value.
 * 
 * You are giving candies to these children subjected to the following
 * requirements:
 * 
 * Each child must have at least one candy. Children with a higher rating get
 * more candies than their neighbors. What is the minimum candies you must give?
 */

public class Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0)
            return 0;
            
        int len = ratings.length;
        int[] candies = new int[len];
        candies[0] = 1;
        for (int i = 1; i < len; i++) {
            candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
        }
        
        int sum = candies[len - 1];
        for (int i = len - 2; i>= 0; i--) {
            int candy = ratings[i] > ratings[i + 1] ? candies[i + 1] + 1 : 1;
            candies[i] = Math.max(candy, candies[i]);
            sum += candies[i];
        }
        
        return sum;
    }
}