import java.util.Arrays;

class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        char[] arr = s.toCharArray();

        // Sort only the first half
        Arrays.sort(arr, 0, mid);

        // Copy the first half to the second half in reverse order
        for (int i = 0; i < mid; i++) {
            arr[n - 1 - i] = arr[i];
        }

        return new String(arr);
    }
}