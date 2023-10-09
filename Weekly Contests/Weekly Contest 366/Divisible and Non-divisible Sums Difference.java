// Intution : 

// Find the Sum of Divisible and NotDivisble Elements from [1,n] by m;
// Then subtract Divisible - NotDivisble

class Solution {
    public int differenceOfSums(int n, int m) {
        int divSum = 0;
        int notDivSum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m == 0) {
                notDivSum += i;
            } else {
                divSum += i;
            }
        }
        return divSum - notDivSum;
    }
}