package main

import (
	"fmt"
)

func queueSrt(convyrItms []int) []int {
	sortdQ := []int{}

	for len(convyrItms) > 0 {
		minIdx := 0
		for i := 1; i < len(convyrItms); i++ {
			if convyrItms[i] < convyrItms[minIdx] {
				minIdx = i
			}
		}
		sortdQ = append(sortdQ, convyrItms[minIdx])
		convyrItms = append(convyrItms[:minIdx], convyrItms[minIdx+1:]...)
	}

	return sortdQ
}

func main() {
	// Solution for Day 21: effcient_parcl_srtng
	var n int
	fmt.Scan(&n)
	convQ := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&convQ[i])
	}

	fmt.Println(queueSrt(convQ))
}
