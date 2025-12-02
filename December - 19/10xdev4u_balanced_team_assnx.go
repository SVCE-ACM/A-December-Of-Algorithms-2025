package main

import (
	"fmt"
)

func minDiff(skills []int, n int) int {
	totalSum := 0
	for _, skill := range skills {
		totalSum += skill
	}
	target := totalSum / 2

	dp := make([]bool, target+1)
	dp[0] = true

	for _, skill := range skills {
		for j := target; j >= skill; j-- {
			if dp[j-skill] {
				dp[j] = true
			}
		}

	}

	bestSum := 0
	for i := target; i >= 0; i-- {
		if dp[i] {
			bestSum = i
			break
		}
	}

	return totalSum - 2*bestSum
}

func main() {
	// Solution for Day 19: balanced_team_assnx
	var n int
	fmt.Scan(&n)

	sklsLst := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&sklsLst[i])
	}

	fmt.Println(minDiff(sklsLst, n))
}
