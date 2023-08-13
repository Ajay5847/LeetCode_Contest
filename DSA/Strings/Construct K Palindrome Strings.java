// Given a string s and an integer k, 
// return true if you can use all the characters in s to construct k palindrome strings or false otherwise.

// Input: s = "annabelle", k = 2
// Output: true
// Explanation: You can construct two palindromes using all characters in s.
// Some possible constructions "anna" + "elble", "anbna" + "elle", "anellena" + "b"
// Example 2:

// Input: s = "leetcode", k = 3
// Output: false
// Explanation: It is impossible to construct 3 palindromes using all the characters of s.

// Constraints:

// 1 <= s.length <= 105
// s consists of lowercase English letters.
// 1 <= k <= 105

// Intution 

// Find the frequencies of each character and calculate the no. of odd frequencies count 
// if the count of odd frequencies is <= k then we can form k palindromes.

// ex - 1
// a - 2,n - 2,b - 1,e - 2,l - 2;
// oddcnt = 1;
// 1 <= 2 (output = true)

class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k){
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0;i < s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0) + 1);
        }
        int oddcnt = 0;
        for(Map.Entry<Character,Integer> ent: map.entrySet()){
            if(ent.getValue()%2 != 0){
                oddcnt++;
            }
        }
        return (oddcnt <= k) ? true : false;
    }
}

