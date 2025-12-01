package main

import (
	"fmt"
)

func cntPrime(n int) int {
	if n < 2 {
		return 0
	}

	isCmpst := make([]bool, n)
	for i := 2; i*i < n; i++ {
		if !isCmpst[i] {
			for j := i * i; j < n; j += i {
				isCmpst[j] = true
			}
		}
	}

	primCnt := 0
	for i := 2; i < n; i++ {
		if !isCmpst[i] {
			primCnt++
		}
	}
	return primCnt
}

func main() {
	// Solution for Day 11: counting_prim_nox
	var n int
	fmt.Scan(&n)
	fmt.Println(cntPrime(n))
}
