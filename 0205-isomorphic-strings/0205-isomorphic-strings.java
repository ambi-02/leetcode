import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Step 1: Check if lengths are the same
        if (s.length() != t.length()) {
            return false;
        }

        // Step 2: Create two hash maps for character mapping
        HashMap<Character, Character> mapST = new HashMap<>(); // Map from s to t
        HashMap<Character, Character> mapTS = new HashMap<>(); // Map from t to s

        // Step 3: Iterate through the characters of both strings
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            // Check mapping from s to t
            if (mapST.containsKey(charS)) {
                if (mapST.get(charS) != charT) {
                    return false; // Mismatch in mapping
                }
            } else {
                mapST.put(charS, charT); // Create mapping
            }

            // Check mapping from t to s
            if (mapTS.containsKey(charT)) {
                if (mapTS.get(charT) != charS) {
                    return false; // Mismatch in mapping
                }
            } else {
                mapTS.put(charT, charS); // Create mapping
            }
        }

        // Step 4: If all checks passed, the strings are isomorphic
        return true;
    }

}