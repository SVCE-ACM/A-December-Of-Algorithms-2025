/*
 * Problem: Minimum Sweets Distribution
 *
 * Rules:
 * ------
 * 1. Every student gets at least 1 sweet.
 * 2. Student with higher score than neighbor must get more sweets.
 *
 * Insight:
 * --------
 * Local comparisons matter only with adjacent students.
 *
 * Solution Strategy:
 * ------------------
 * Two-pass greedy approach:
 *
 * 1️⃣ Left → Right pass
 *    If score[i] > score[i-1]
 *       sweets[i] = sweets[i-1] + 1
 *
 * 2️⃣ Right → Left pass
 *    If score[i] > score[i+1]
 *       sweets[i] = max(sweets[i], sweets[i+1] + 1)
 *
 * Finally sum all sweets.
 *
 * Complexity:
 * -----------
 * Time  : O(n)
 * Space : O(n)
 */

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] score = new int[n];

        for (int i = 0; i < n; i++)
            score[i] = sc.nextInt();

        int[] sweets = new int[n];
        Arrays.fill(sweets, 1); // Rule 1

        // Left → Right
        for (int i = 1; i < n; i++) {
            if (score[i] > score[i - 1])
                sweets[i] = sweets[i - 1] + 1;
        }

        // Right → Left
        for (int i = n - 2; i >= 0; i--) {
            if (score[i] > score[i + 1])
                sweets[i] = Math.max(sweets[i], sweets[i + 1] + 1);
        }

        long total = 0;
        for (int x : sweets) total += x;

        System.out.println(total);
    }
}
