public class Solution {
    public int nextGreaterElement(int n) {
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;

        // Step 1: Find the rightmost ascent
        int i = length - 2;
        while (i >= 0 && digits[i] >= digits[i + 1]) {
            i--;
        }

        // If no ascent is found, return -1
        if (i < 0) return -1;

        // Step 2: Find the smallest digit on the right side of the ascent
        int j = length - 1;
        while (digits[j] <= digits[i]) {
            j--;
        }

        // Step 3: Swap the ascent with the smallest larger digit found
        swap(digits, i, j);

        // Step 4: Reverse the digits after the ascent
        reverse(digits, i + 1, length - 1);

        // Convert back to integer and check for overflow
        long result = Long.parseLong(new String(digits));
        return (result <= Integer.MAX_VALUE) ? (int) result : -1;
    }

    private void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }
}