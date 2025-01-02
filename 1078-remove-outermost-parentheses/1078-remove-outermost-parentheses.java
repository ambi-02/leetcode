class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder res = new StringBuilder();
        int depth = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                // Before we increase depth, check if it's not the outermost '('
                if (depth > 0) {
                    res.append(ch); // Append if it's not the outermost '('
                }
                depth++; // Increment depth for '('
            } else { // ch == ')'
                depth--; // Decrement depth for ')'
                // Append if it's not the outermost ')'
                if (depth > 0) {
                    res.append(ch);
                }
            }
        }
        return res.toString(); // Corrected: Added parentheses to toString()
    }
}