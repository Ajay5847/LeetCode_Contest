// Intution: 

// -> Sort Both processorTime and tasks
// -> As each core has 4 tasks
// -> minimum processorTime should be used by maximum task values
// -> This calculates the minProcessingTime

import java.util.*;

class Solution {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        Collections.sort(tasks);
        int ans = Integer.MIN_VALUE;
        int n = tasks.size();
        int i = n - 1;
        int idx = 0;
        while (i > 2) {
            int check = Integer.MIN_VALUE;
            for (int j = i; j > i - 4; j--) {
                check = Math.max(check, tasks.get(j) + processorTime.get(idx));
            }
            ans = Math.max(ans, check);
            idx++;
            i = i - 4;
        }

        return ans;
    }
}