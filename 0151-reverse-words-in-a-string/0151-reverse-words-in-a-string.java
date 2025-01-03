import java.util.Stack;

public class Solution {
    public String reverseWords(String s) {
        // Step 1: Append a space to handle the last word
        s += " ";
        Stack<String> st = new Stack<String>(); // Step 2: Create a stack to hold words
        String str = ""; // Step 3: Initialize an empty string to build words

        // Step 4: Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') { // Step 5: Check for spaces
                if (!str.isEmpty()) { // Only push non-empty words
                    st.push(str); // Step 6: Push the current word onto the stack
                    str = ""; // Step 7: Reset str for the next word
                }
            } else {
                str += s.charAt(i); // Step 8: Build the current word
            }
        }

        StringBuilder ans = new StringBuilder(); // Step 9: Use StringBuilder for efficiency
        // Step 10: Pop words from the stack to reverse their order
        while (!st.isEmpty()) {
            ans.append(st.pop()); // Step 11: Add the top word to the result
            if (!st.isEmpty()) {
                ans.append(" "); // Add a space if there are more words
            }
        }

        return ans.toString(); // Step 12: Return the final reversed string
    }

   
}
