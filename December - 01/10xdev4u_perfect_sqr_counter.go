package main

import (
	"fmt"
)

func countPerfectSquares(n int) int {
	count := 0
	for i := 1; i*i <= n; i++ {
		count++
		fmt.Printf("Perfect square %d: %d\n", count, i*i)
	}
	return count
}

func main() {
	// Solution for Day 01: perfect_sqr_counter
	var n int
	fmt.Print("Enter N: ")
	fmt.Scan(&n)

	fmt.Printf("Number of perfect squares between 1 and %d: %d\n", n, countPerfectSquares(n))
}
