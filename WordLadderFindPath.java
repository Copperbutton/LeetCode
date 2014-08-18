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
        Set<String> unvisited = new HashSet<String>(dict);
        Set<String> ladder = new HashSet<String>();
        Map<String, Queue<String>> precursors = new HashMap<String, Queue<String>>();
        
        for (String str : unvisited)
            precursors.put(str, new LinkedList<String>());
        
        ladder.add(start);
        unvisited.remove(start);
        while (!ladder.isEmpty()) {
            Set<String> nextLevelLadder = new HashSet<String>();
            for (String currLadder : ladder) {
                for (String nextLadder : getNextLadders(unvisited, currLadder)) {
                    nextLevelLadder.add(nextLadder);
                    precursors.get(nextLadder).offer(currLadder);
                }
            }
            if (nextLevelLadder.contains(end))
                break;
            unvisited.removeAll(nextLevelLadder);
            ladder = nextLevelLadder;
        }
        
        List<List<String>> result = new LinkedList<List<String>>();
        LinkedList<String> path = new LinkedList<String>();
        path.add(end);
        genWordLadder(result, path, start, end, precursors);
        return result;
        
    }
    
    private List<String> getNextLadders(Set<String> unvisited, String currLadder) {
        List<String> nextLadders = new ArrayList<String>();
        StringBuffer ladder = new StringBuffer(currLadder);
        for (int i = 0; i < currLadder.length(); i++) {
            char old = ladder.charAt(i);
            for (char ch = 'a'; ch < 'z'; ch++) {
                ladder.setCharAt(i, ch);
                String newWord = ladder.toString();
                if (unvisited.contains(newWord)) {
                    nextLadders.add(newWord);
                }
            }
            ladder.setCharAt(i, old);
        }
        return nextLadders;
    }
    
    private void genWordLadder(List<List<String>> result,
                               LinkedList<String> path, String start, String end,
                               Map<String, Queue<String>> precursors) {
        if (start == end) {
            result.add(new LinkedList<String>(path));
            return;
        }
        
        Queue<String> precurQueue = precursors.get(end);
        for (String wordPrecurs : precurQueue) {
            path.addFirst(wordPrecurs);
            genWordLadder(result, path, start, wordPrecurs, precursors);
            path.removeFirst();
        }
    }
}
