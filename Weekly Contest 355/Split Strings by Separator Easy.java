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