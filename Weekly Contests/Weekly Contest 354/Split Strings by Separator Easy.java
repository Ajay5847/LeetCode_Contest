// Given an array of strings words and a character separator, split each string in words by separator.
// Return an array of strings containing the new strings formed after the splits, excluding empty strings.
// Notes
// -> separator is used to determine where the split should occur, but it is not included as part of the resulting strings.
// -> A split may result in more than two strings.
// -> The resulting strings must maintain the same order as they were initially given.

// Example 1:

// Input: words = ["one.two.three","four.five","six"], separator = "."
// Output: ["one","two","three","four","five","six"]
// Explanation: In this example we split as follows:
// "one.two.three" splits into "one", "two", "three"
// "four.five" splits into "four", "five"
// "six" splits into "six" 
// Hence, the resulting array is ["one","two","three","four","five","six"].


// problem link - https://leetcode.com/problems/split-strings-by-separator/description/;

class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            String[] updated = words.get(i).split("[" + separator + "]");
            for (int j = 0; j < updated.length; j++) {
                if (updated[j].length() > 0) {
                    ans.add(updated[j]);
                }
            }
        }
        return ans;
    }
}
