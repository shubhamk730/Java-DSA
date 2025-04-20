import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    
    public int wordLadderLength(String startWord, String targetWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));

        if (!wordSet.contains(targetWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);

        int level = 1;
        while (!queue.isEmpty()) {
            int cnt = queue.size();

            for(int i = 0; i < cnt; i++) {
                String word = queue.poll();

                if(word.equals(targetWord)) return level;

                char[] letters = word.toCharArray();
                for(int j = 0; j < letters.length; j++) {

                    char original = letters[j];
                    for(char k = 'a'; k <= 'z'; k++) {

                        if(k == original) continue;

                        letters[j] = k;
                        String newWord = new String(letters);
                        if (wordSet.contains(newWord)) {
                            queue.add(newWord);
                            wordSet.remove(newWord);
                        }

                    }
                    letters[j] = original;
                }
            }
            level++;   
        }

        return 0; 
    }

}
