package main

import (
	"fmt"
	"strconv"
	"strings"
)

type NstdChst struct {
	isIntr bool
	val    int
	Lst    []*NstdChst
}

var idx int

func parse(s string) *NstdChst {
	idx = 0
	return dfs(s)
}

func dfs(s string) *NstdChst {
	switch s[idx] {
	case '[':
		return parseList(s)
	default:
		return parseInt(s)
	}
}

func (Chst *NstdChst) String() string {
	if Chst.isIntr {
		return strconv.Itoa(Chst.val)
	}
	PartX := make([]string, len(Chst.Lst))
	for i, lst := range Chst.Lst {
		PartX[i] = lst.String()
	}
	return "[" + strings.Join(PartX, ",") + "]"
}

func parseList(s string) *NstdChst {
	Chst := &NstdChst{isIntr: false, Lst: []*NstdChst{}}
	idx++

	for idx < len(s) {
		switch s[idx] {
		case ']':
			idx++
			return Chst
		case ',':
			idx++
		case '[':
			Chst.Lst = append(Chst.Lst, parseList(s))
		default:
			Chst.Lst = append(Chst.Lst, parseInt(s))
		}
	}
	return Chst
}

func parseInt(s string) *NstdChst {
	start := idx
	if s[idx] == '-' {
		idx++
	}
	for idx < len(s) && s[idx] >= '0' && s[idx] <= '9' {
		idx++
	}

	num, _ := strconv.Atoi(s[start:idx])
	return &NstdChst{isIntr: true, val: num}
}

func main() {
	// Solution for Day 14: magical_treasure_chst_prsr
	var s string
	fmt.Scanln(&s)

	result := parse(s)
	fmt.Println(result)
}
