/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 *
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 *
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"] As
 * one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Note: Return 0 if there is no such transformation sequence. All words have
 * the same length. All words contain only lowercase alphabetic characters.
 */

public class WordLadder {
    public int ladderLength(String start, String end, Set<String> dict) {
        Set<String> usedWords = new HashSet<String>();
        Queue<String> wordQueue = new LinkedList<String>();
        Queue<Integer> depthQueue = new LinkedList<Integer>();
        
        wordQueue.offer(start);
        depthQueue.offer(1);
        usedWords.add(start);
        while (!wordQueue.isEmpty()) {
            String nextWord = wordQueue.poll();
            int currDepth = depthQueue.poll();
            for (int i = 0; i < nextWord.length(); i++) {
                char[] nextWordChs = nextWord.toCharArray();
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    nextWordChs[i] = ch;
                    String newWord = new String(nextWordChs);
                    if (dict.contains(newWord) && !usedWords.contains(newWord)) {
                        if (newWord.equals(end))
                            return currDepth + 1;
                        wordQueue.offer(newWord);
                        depthQueue.offer(currDepth + 1);
                        usedWords.add(newWord);
                    }
                }
            }
        }
        
        return 0;
    }
}