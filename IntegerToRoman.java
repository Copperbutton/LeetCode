/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        String[] roms = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
                "IX", "V", "IV", "I" };
        int[] ints = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < ints.length; i++) {
            while (num >= ints[i]) {
                result.append(roms[i]);
                num -= ints[i];
            }
        }
        return result.toString();
    }
}