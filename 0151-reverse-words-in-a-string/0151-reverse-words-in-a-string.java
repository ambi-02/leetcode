public class Solution {
    public String reverseWords(String s) {
        // Trim the string to remove leading and trailing spaces
        s = s.trim();
        int left = 0;
        int right = s.length() - 1;

        String temp = "";
        String ans = "";

        // Iterate the string and keep on adding to form a word
        // If empty space is encountered then add the current word to the result
        while (left <= right) {
            char ch = s.charAt(left);
            if (ch != ' ') {
                temp += ch; // Build the current word
            } else if (ch == ' ') {
                if (!temp.isEmpty()) {
                    if (!ans.isEmpty()) {
                        ans = temp + " " + ans; // Add the current word to the result
                    } else {
                        ans = temp; // First word
                    }
                    temp = ""; // Reset temp for the next word
                }
            }
            left++;
        }

        // If not empty string then add to the result (Last word is added)
        if (!temp.isEmpty()) {
            if (!ans.isEmpty()) {
                ans = temp + " " + ans; // Add the last word
            } else {
                ans = temp; // First word
            }
        }

        return ans; // Return the final reversed string
    }

   
}