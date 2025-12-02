package main

import (
	"fmt"
)

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}

func chkDupndMisng(list []int) (misng int, dup int) {
	dup, misng = -1, -1
	for _, no := range list {
		if list[abs(no)-1] < 0 {
			dup = abs(no)
		} else {
			list[abs(no)-1] = -list[abs(no)-1]
		}
	}

	for i, no := range list {
		if no > 0 {
			misng = i + 1
			break
		}
	}
	return misng, dup
}

func main() {
	// Solution for Day 12: the_missing_poctv_lmnt
	var n int
	fmt.Scan(&n)
	lstOfVals := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&lstOfVals[i])
	}
	fmt.Println(chkDupndMisng(lstOfVals))
}
