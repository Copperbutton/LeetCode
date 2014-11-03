/**
 * Given two words (start and end), and a dictionary, find all shortest
 * transformation sequence(s) from start to end, such that:
 *
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 *
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * Return [ ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"] ]
 * Note: All words have the same length. All words contain only lowercase
 * alphabetic characters.
 **/

public class WordLadderFindPath {
  public List<List<String>> findLadders(String start, String end,
            Set<String> dict) {
        Set<String> used = new HashSet<String>();
        Map<String, List<String>> precedsWords = new HashMap<String, List<String>>();
        Set<String> currLevel = new HashSet<String>();
        Set<String> nextLevel = new HashSet<String>();
        currLevel.add(start);
        while (!currLevel.isEmpty() && !currLevel.contains(end)) {
            used.addAll(currLevel);
            for (String word : currLevel) {
                List<String> permutes = getPermutates(dict, used, word);
                nextLevel.addAll(permutes);
                for (String permute : permutes) {
                    if (!precedsWords.containsKey(permute))
                        precedsWords.put(permute, new ArrayList<String>());
                    precedsWords.get(permute).add(word);
                }
            }
            currLevel = nextLevel;
            nextLevel = new HashSet<String>();
        }

        List<List<String>> ladders = new ArrayList<List<String>>();
        LinkedList<String> path = new LinkedList<String>();
        path.add(end);
        searchLadder(end, start, precedsWords, path, ladders);
        return ladders;
    }

    private List<String> getPermutates(Set<String> dict, Set<String> used,
            String word) {
        List<String> permutes = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer(word);
        for (int i = 0; i < word.length(); i++) {
            char old = word.charAt(i);
            for (char ch = 'a'; ch <= 'z'; ch++) {
                if (ch == old)
                    continue;
                buffer.setCharAt(i, ch);
                String newWord = buffer.toString();
                if (!dict.contains(newWord) || used.contains(newWord))
                    continue;
                permutes.add(newWord);
            }
            buffer.setCharAt(i, old);
        }
        return permutes;
    }

    private void searchLadder(String start, String end,
            Map<String, List<String>> precedsWords, LinkedList<String> path,
            List<List<String>> ladders) {
        if (start.equals(end)) {
            ladders.add(new ArrayList<String>(path));
            return;
        }

        if (!precedsWords.containsKey(start))
            return;

        List<String> preceds = precedsWords.get(start);
        for (String word : preceds) {
            path.addFirst(word);
            searchLadder(word, end, precedsWords, path, ladders);
            path.removeFirst();
        }
    }
}
