package main

import (
	"fmt"
)

func sum0fUniq(arrY []int) int {
	elemCount := make(map[int]int)

	for _, ele := range arrY {
		elemCount[ele]++
	}

	finSum := 0
	for ele, cnt := range elemCount {
		if cnt == 1 {
			finSum += ele
		}
	}
	return finSum
}

func main() {
	// Solution for Day 09: sum_of_uniq_elemnts
	var n int
	fmt.Scan(&n)

	elex := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&elex[i])
	}
	fmt.Println(sum0fUniq(elex))
}
