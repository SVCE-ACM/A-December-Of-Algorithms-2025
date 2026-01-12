// Problem Description:
// You are given a non-negative integer N.
// Count how many prime numbers exist strictly less than N.
//
// A prime number is an integer > 1 that has exactly two divisors:
// 1 and itself.
//
// Input:
//   A single integer N.
//
// Output:
//   The count of prime numbers less than N is: <value>
//
// Constraints:
//   0 ≤ N ≤ 1,000,000
//
// ---------------------------------------------------------
// Approach (Sieve of Eratosthenes):
//
// 1. Create a boolean array isPrime[] of size N and mark all as true.
// 2. Mark 0 and 1 as not prime.
// 3. For each i from 2 to sqrt(N):
//       If isPrime[i] is true,
//          mark multiples of i starting from i*i as false.
// 4. Count how many positions remain true.
//
// Complexity:
//   Time:  O(N log log N)
//   Space: O(N)



class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;

        boolean[] isPrime = new boolean[n];
        java.util.Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (boolean prime : isPrime) {
            if (prime) count++;
        }

        return count;
    }
}
