package main

import (
	"fmt"
)

func cntPeaks(pkheights []int, n int) []int {
	var peaks []int
	for i := 1; i < n-1; i++ {
		prev := pkheights[i-1]
		curr := pkheights[i]
		next := pkheights[i+1]
		if curr > prev && curr > next {
			peaks = append(peaks, i)
		}
	}
	return peaks
}

func main() {
	// Solution for Day 13: mountain_peaks_in_a_trial
	var n int
	fmt.Scan(&n)
	heights := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Scan(&heights[i])
	}
	peaks := cntPeaks(heights, n)
	if len(peaks) == 0 {
		fmt.Println("-1")
	} else {
		fmt.Println(peaks)
	}
}
