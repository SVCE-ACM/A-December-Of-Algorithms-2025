package main

import (
	"fmt"
)

func nextTallr(towrHeights []int, n int) []int {
	result := make([]int, n)
	stack := []int{}

	for i := n - 1; i >= 0; i-- {
		for len(stack) > 0 && towrHeights[stack[len(stack)-1]] <= towrHeights[i] {
			stack = stack[:len(stack)-1]
		}
		if len(stack) == 0 {
			result[i] = -1
		} else {
			result[i] = towrHeights[stack[len(stack)-1]]
		}
		stack = append(stack, i)
	}
	return result
}

func main() {
	// Solution for Day 20: tower_vcblty_chlng
	var n int
	fmt.Scan(&n)

	tovrHi8 := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&tovrHi8[i])
	}

	fmt.Println(nextTallr(tovrHi8, n))
}
