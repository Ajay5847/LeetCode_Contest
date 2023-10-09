// Intution:

// -> Find the indices of unequal bits and store it into an ArrayList(indices)
// -> if indices.size() is odd then we will not get pairs ro return -1
// -> inorder to calculte the minimum flips we follow three step approach
// -> We will calculate reursively frontFlip(i , i + 1) and backFlip(j, j - 1) and frontBack(i,j)
// -> We will return minimum of these three
// -> If we consider this array [1,5,6,10,15,16] and x = 3
// -> Then minimum will be {(1,10), (5,6), (15,16)} which gives 5

import java.util.*;

class Solution {
    public int minOperations(String s1, String s2, int x) {
        ArrayList<Integer> indices = new ArrayList<>();
        int n = s1.length();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                indices.add(i);
            }
        }
        if (indices.size() % 2 != 0) {
            return -1;
        }
        int m = indices.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = recursion(0, m - 1, m, indices, x, dp);
        return ans;
    }

    int recursion(int si, int ei, int m, ArrayList<Integer> indices, int x, int[][] dp) {
        if (si >= m - 1 || ei < 1 || si > ei) {
            return 0;
        }
        if (dp[si][ei] != -1) {
            return dp[si][ei];
        }
        int frontFlip = indices.get(si + 1) - indices.get(si) + recursion(si + 2, ei, m, indices, x, dp);
        int backFlip = indices.get(ei) - indices.get(ei - 1) + recursion(si, ei - 2, m, indices, x, dp);
        int frontBack = x + recursion(si + 1, ei - 1, m, indices, x, dp);

        return dp[si][ei] = Math.min(frontFlip, Math.min(frontBack, backFlip));
    }
}