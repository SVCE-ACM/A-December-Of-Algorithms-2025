package main

import (
	"fmt"
	"strconv"
)

func calPoints(Ops []string) int {
	var Rcrd []int
	for _, op := range Ops {
		n := len(Rcrd)
		switch op {
		case "+":
			scr := Rcrd[n-1] + Rcrd[n-2]
			Rcrd = append(Rcrd, scr)
		case "D":
			scr := Rcrd[n-1] * 2
			Rcrd = append(Rcrd, scr)
		case "C":
			Rcrd = Rcrd[:n-1]
		default:
			scr, _ := strconv.Atoi(op)
			Rcrd = append(Rcrd, scr)
		}
	}

	finScr := 0
	for _, scr := range Rcrd {
		finScr += scr
	}
	return finScr
}

func main() {
	// Solution for Day 07: baseball_score_rcrd_kpr
	var n int
	fmt.Scan(&n)

	var ops []string
	for i := 0; i < n; i++ {
		var input string
		fmt.Scan(&input)
		ops = append(ops, input)
	}

	fmt.Println(calPoints(ops))
}
