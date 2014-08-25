/**
 * Given an array of integers, find two numbers such that they add up to a
 * specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they
 * add up to the target, where index1 must be less than index2. Please note that
 * your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9 Output: index1=1, index2=2
 */

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberToIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++)
            numberToIndex.put(numbers[i], i);
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int gap = target - numbers[i];
            if (numberToIndex.containsKey(gap) && i != numberToIndex.get(gap)) {
                result[0] = i + 1;
                result[1] = numberToIndex.get(gap) + 1;
                break;
            }
        }
        return result;
    }
}