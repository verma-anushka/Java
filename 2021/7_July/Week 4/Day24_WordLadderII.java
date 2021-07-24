//Day 24: 
//Problem Statement: Word Ladder II

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:

// Every adjacent pair of words differs by a single letter.
// Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
// sk == endWord
// Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list of the words [beginWord, s1, s2, ..., sk].

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
// Explanation: There are 2 shortest transformation sequences:
// "hit" -> "hot" -> "dot" -> "dog" -> "cog"
// "hit" -> "hot" -> "lot" -> "log" -> "cog"
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: []
// Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 

// Constraints:

// 1 <= beginWord.length <= 5
// endWord.length == beginWord.length
// 1 <= wordList.length <= 1000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the words in wordList are unique.

//Solution:
class Solution {
    
    private boolean isDiff(String a, String b) {
        int diff=0;
        for(int i=0; i<a.length() && diff<2; i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                diff++;
            }
        }
        return diff==1;
    }
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        
        Queue<List<String>> q=new ArrayDeque<>();
        q.add(new ArrayList<>(Arrays.asList(beginWord)));
        
        boolean found=false;
        Set<String> words=new HashSet<>(wordList);
        Set<String> usedWords=new HashSet<>(Arrays.asList(beginWord));
        
        while(!found && !q.isEmpty()) {
            words.removeAll(usedWords);
            int size=q.size();
            
            for(int i=0; i<size; i++) {
                List<String> chain=q.remove();
                String curr=chain.get(chain.size() - 1);
                
                for(String word: words) {
                    if(isDiff(curr, word)) {
                        List<String> newChain=new ArrayList<>(chain);
                        newChain.add(word);
                        q.add(newChain);
                        
                        usedWords.add(word);
                        
                        if(word.equals(endWord)) {
                            found=true;
                            break;
                        }
                    }
                }
            }
        }
        
        List<List<String>> shortest=new ArrayList<>();
        for (List<String> chain: q) {
            if(chain.get(chain.size()-1).equals(endWord)) {
                shortest.add(chain);
            }
        }
        
        return shortest;
    }
}
//Complexity: O(26 * num_words * len_of_words + VE)

