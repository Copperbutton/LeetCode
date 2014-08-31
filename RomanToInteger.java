/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 */

public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int integer = map.get(s.charAt(i));
            if (i + 1 < len && map.get(s.charAt(i + 1)) > integer)
                integer = -integer;
            result += integer;
        }
        return result;
    }
}