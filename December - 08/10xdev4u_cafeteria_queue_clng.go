package main

import (
	"fmt"
)

func countStud(studQ []int, sandQ []int) int {
	circLvrs, sqrLvrs := 0, 0
	for _, s := range studQ {
		if s == 0 {
			circLvrs++
		} else {
			sqrLvrs++
		}
	}

	for _, sandW := range sandQ {
		if sandW == 0 {
			if circLvrs != 0 {
				circLvrs--
			} else {
				break
			}
		} else {
			if sqrLvrs != 0 {
				sqrLvrs--
			} else {
				break
			}
		}
	}
	return circLvrs + sqrLvrs
}

func main() {
	// Solution for Day 08: cafeteria_queue_clng
	var n int
	fmt.Scan(&n)

	studQ := make([]int, n)
	sandQ := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&studQ[i])
	}

	for i := 0; i < n; i++ {
		fmt.Scan(&sandQ[i])
	}
	result := countStud(studQ, sandQ)
	fmt.Println(result)
}
