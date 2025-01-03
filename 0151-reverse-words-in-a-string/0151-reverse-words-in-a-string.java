public class Solution {
    public String reverseWords(String s) {
        // Step 1: Trim the string to remove leading and trailing spaces
        s = s.trim();
        
        // Step 2: Split the string into words
        String[] words = s.split("\\s+"); // Split by one or more spaces
        
        // Step 3: Reverse the words
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        Collections.reverse(wordList);
        
        // Step 4: Join the words back into a single string
        return String.join(" ", wordList);
    }

   
}