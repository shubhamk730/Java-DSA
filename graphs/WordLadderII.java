import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
    
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> st = new ArrayList<>();
        st.add(startWord);
        wordSet.remove(startWord);
        queue.add(st);

        while (!queue.isEmpty()) {
            int cnt = queue.size();
            ArrayList<String> wordsRemoved = new ArrayList<>();
            
            while(cnt-- > 0) {

                ArrayList<String> seq = queue.poll();
                String lastWord = seq.get(seq.size() - 1);

                if(lastWord.equals(targetWord) && (ans.isEmpty()|| ans.get(0).size() == seq.size())) ans.add(seq);
                

                char[] lastLetters = lastWord.toCharArray();
                for(int j = 0; j < lastLetters.length; j++) {
                    char original = lastLetters[j];

                    for(char k = 'a'; k <= 'z'; k++) {
                        if(k == original) continue;
                        lastLetters[j] = k;
                        String newWord = new String(lastLetters);
                        if(wordSet.contains(newWord)) {
                            ArrayList<String> wordSoFar = new ArrayList<>(seq);
                            wordSoFar.add(newWord);
                            queue.add(wordSoFar);
                            wordsRemoved.add(newWord);
                        }
                    }
                    lastLetters[j] = original;
                }
            }

            wordSet.removeAll(wordsRemoved);
        }
        return ans;
    }
}
