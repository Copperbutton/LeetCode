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
        int len = ratings.length;
        if (len == 0)
            return 0;

        int[] candies = new int[len];
        Arrays.fill(candies, 1);

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        }

        int sum = candies[len - 1];
        for (int i = len - 2, inc = 1; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1])
                candies[i] = Math.max(++inc, candies[i]);
            else
                inc = 1;
            sum += candies[i];
        }
        return sum;
    }
}