package main

import (
	"fmt"
)

func chkMirror(arr []int, len int) bool {
	for i := 0; i < len/2; i++ {
		if arr[i] != arr[len-1-i] {
			return false
		}
	}
	return true
}

func main() {
	// Solution for Day 18: mirror_necklace_chk
	var n int
	fmt.Scan(&n)
	necklacePtn := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&necklacePtn[i])
	}
	fmt.Printf("Is Mirrored? %v", chkMirror(necklacePtn, n))
}
