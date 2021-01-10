
//Day 9: 
//Problem Statement: Word Ladder

// A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words such that:

// The first word in the sequence is beginWord.
// The last word in the sequence is endWord.
// Only one letter is different between each adjacent pair of words in the sequence.
// Every word in the sequence is in wordList.
// Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

// Example 1:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
// Output: 5
// Explanation: One shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with 5 words.
// Example 2:

// Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
// Output: 0
// Explanation: The endWord "cog" is not in wordList, therefore there is no wordStr transformation.
 

// Constraints:

// 1 <= beginWord.length <= 100
// endWord.length == beginWord.length
// 1 <= wordList.length <= 5000
// wordList[i].length == beginWord.length
// beginWord, endWord, and wordList[i] consist of lowercase English letters.
// beginWord != endWord
// All the strings in wordList are unique.

//Solution:
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set=new HashSet<>(wordList);
        
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> pendingNodes=new LinkedList<>();
        pendingNodes.offer(beginWord);
        
        int level=1;
        
        while(!pendingNodes.isEmpty()) {
            
            int size=pendingNodes.size();

            for(int i=0; i<size; i++) {
                
                String front=pendingNodes.poll();
                char word[] = front.toCharArray();
                
                for(int j=0; j<word.length; j++){
                    
                    char temp=word[j];
                    
                    for(char c='a'; c<='z'; c++) {
                        
                        if(word[j]!=c) {

                            word[j]=c;
                            String wordStr = String.valueOf(word);                
                            if(wordStr.equals(endWord)) {
                                // System.out.println("equal");
                                return level+1;
                            }
                            
                            if(set.contains(wordStr)) {
                                pendingNodes.add(wordStr);
                                set.remove(wordStr);
                            }   
                        }
                        word[j]=temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

//Complexity: O(n)

