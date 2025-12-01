package main

import (
	"fmt"
)

func canCrossBrig(stones []int) bool {
	maxReach := 0
	lastIdx := len(stones) - 1

	for i, jmp := range stones {
		if i > maxReach {
			return false
		}
		if jmp+i > maxReach {
			maxReach = jmp + i
		}
		if maxReach >= lastIdx {
			return true
		}
	}
	return false
}

func main() {
	// Solution for Day 03: bridge_crosing_chlng
	var n int
	fmt.Scan(&n)
	stones := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&stones[i])
	}

	fmt.Println(canCrossBrig(stones))
}
