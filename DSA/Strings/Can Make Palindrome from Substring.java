// You are given a string s and array queries where queries[i] = [lefti, righti, ki]. 
// We may rearrange the substring s[lefti...righti] for each query 
// and then choose up to ki of them to replace with any lowercase English letter.

// If the substring is possible to be a palindrome string after the operations above, 
// the result of the query is true. Otherwise, the result is false.
// Return a boolean array answer where answer[i] is the result of the ith query queries[i].

// Note that each letter is counted individually for replacement, 
// so if, for example s[lefti...righti] = "aaa", and ki = 2, 
// we can only replace two of the letters. Also, note that no query modifies the initial string s.

// Example :

// Input: s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
// Output: [true,false,false,true,true]
// Explanation:
// queries[0]: substring = "d", is palidrome.
// queries[1]: substring = "bc", is not palidrome.
// queries[2]: substring = "abcd", is not palidrome after replacing only 1 character.
// queries[3]: substring = "abcd", could be changed to "abba" which is palidrome. Also this can be changed to "baab" first rearrange it "bacd" then replace "cd" with "ab".
// queries[4]: substring = "abcda", could be changed to "abcba" which is palidrome.
// Example 2:

// Input: s = "lyb", queries = [[0,1,0],[2,2,1]]
// Output: [false,true]
 
// Constraints:

// 1 <= s.length, queries.length <= 105
// 0 <= lefti <= righti < s.length
// 0 <= ki <= s.length
// s consists of lowercase English letters.

// Intution 

// for Every query we need to create a substring and then find the frequencies of the 
// selected substring characters the in this we need to find the count of odd frequencies
// which will result in TLE error !

// So we maintain a occurances matrix that will hold frequency for each letter seen till index
// this frequencies are stored in ths order. by copying the previous frequncies.
// occurances[i][0] = frequencies of "a";
// occurances[i][1] = frequencies of "ab";
// occurances[i][2] = frequencies of "abc";
// occurances[i][3] = frequencies of "abcd";
// occurances[i][5] = frequencies of "abcda";

// then we need to count the number of oddcnt then return half of it;

class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] occurances = new int[s.length()][26];
        occurances[0][s.charAt(0) - 'a'] = 1;
        for(int i = 1;i < s.length();i++){
            for(int j = 0;j < 26;j++){
                occurances[i][j] = occurances[i - 1][j];
            }
            occurances[i][s.charAt(i) - 'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        for(int i = 0;i < queries.length;i++){
            int si = queries[i][0];
            int ei = queries[i][1];
            int k = queries[i][2];
            int cnt = isPalindrome(si,ei,occurances);
            if(cnt == 0 || cnt <= k){
                ans.add(true);
            }
            else{
                ans.add(false);
            }
        }
        return ans;
    }

    int isPalindrome(int left,int right,int[][] occurances){
        int oddcnt = 0;
        int len = right - left + 1;
        if(left == 0){
            for(int i = 0;i < 26;i++){
                if(occurances[right][i]%2 != 0){
                    oddcnt++;
                }
            }
        }
        else{
            for(int i = 0;i < 26;i++){
                if((occurances[right][i] - occurances[left - 1][i])%2 != 0){
                    oddcnt++;
                }
            }
        }
        return oddcnt/2;
    }
}