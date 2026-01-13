package main

import (
	"fmt"
)

func minSweetx(scorex []int, n int) int {
	if n == 0 {
		return 0
	}

	sweets := make([]int, n)
	for i := range sweets {
		sweets[i] = 1
	}

	for i := 1; i < n; i++ {
		if scorex[i] > scorex[i-1] {
			sweets[i] = sweets[i-1] + 1
		}
	}

	for i := n - 2; i >= 0; i-- {
		if scorex[i] > scorex[i+1] && sweets[i] <= sweets[i+1] {
			sweets[i] = sweets[i+1] + 1
		}
	}

	totalSweets := 0
	for _, val := range sweets {
		totalSweets += val
	}
	return totalSweets
}

func main() {
	// Solution for Day 28: sweet_reward4studs
	var n int
	fmt.Scan(&n)
	scores := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&scores[i])
	}

	fmt.Println(minSweetx(scores, n))
}
