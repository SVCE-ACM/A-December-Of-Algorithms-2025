package main

import (
	"fmt"
)

func fistUniqChar(s string) string {
	freq := [26]int{}
	for _, ch := range s {
		freq[ch-'a']++
	}

	for _, ch := range s {
		if freq[ch-'a'] == 1 {
			return string(ch)
		}
	}
	return "-1"
}

func main() {
	// Solution for Day 24: first_nonrptng_char
	var s string
	fmt.Scanln(&s)
	fmt.Println(fistUniqChar(s))
}
