package main

import (
	"fmt"
)

func findSubArr(arr []int, n int, trgt int) (int, int) {
	sum := make(map[int]int)
	currSum := 0
	sum[0] = -1
	for i := 0; i < n; i++ {
		currSum += arr[i]
		neededSum := currSum - trgt
		if idx, found := sum[neededSum]; found {
			return idx + 1, i
		}
		if _, exists := sum[currSum]; !exists {
			sum[currSum] = i
		}
	}
	return -1, -1
}

func main() {
	// Solution for Day 04: trgt_subarray_findr
	var n, trgt int
	fmt.Scan(&n, &trgt)

	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&arr[i])
	}
	start, end := findSubArr(arr, n, trgt)
	fmt.Printf("[%d %d]", start, end)
}
