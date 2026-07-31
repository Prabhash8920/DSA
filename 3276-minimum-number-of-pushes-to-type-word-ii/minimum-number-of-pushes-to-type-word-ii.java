class Solution {
    public int minimumPushes(String word) {
       Integer[] mp = new Integer[26];
        Arrays.fill(mp, 0);

        // Count frequency of each character
        for (char ch : word.toCharArray()) {
            mp[ch - 'a']++;
        }

        // Sort in descending order
        Arrays.sort(mp, Collections.reverseOrder());

        int result = 0;

        for (int i = 0; i < 26; i++) {
            int freq = mp[i];
            int press = i / 8 + 1;
            result += press * freq;
        }

        return result;
    }
}