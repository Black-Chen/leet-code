import java.util.Arrays;

/*
 * @lc app=leetcode id=204 lang=java
 *
 * [204] Count Primes
 */

// @lc code=start
class Solution {
    public int countPrimes(int n) {
        if (n < 2) {
            return 0;
        }
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = n - 2;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j = j + i) {
                    if (isPrime[j]) {
                        isPrime[j] = false;
                        count--;
                    }
                }
            }
        }
        return count;
    }
}
// @lc code=end

