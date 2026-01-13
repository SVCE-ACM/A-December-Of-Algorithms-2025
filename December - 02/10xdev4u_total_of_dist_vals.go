package main

import (
	"fmt"
)

func formatNo(n int, width int) {
	for i := 1; i <= n; i++ {
		fmt.Println(fmt.Sprintf("%*d %*o %*X %*b", width, i, width, i, width, i, width, i))
	}
}

func main() {
	// Solution for Day 02: total_of_dist_vals
	var no int
	fmt.Scan(&no)
	formatNo(no, len(fmt.Sprintf("%b", no)))
}
