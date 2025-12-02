package main

import (
	"fmt"
)

func printMatrix(matx [][]int, n int) {
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			fmt.Printf("%d ", matx[i][j])
		}
		fmt.Println()
	}
}

func calcMagicMatrx(num int) [][]int {
	matx := make([][]int, num)
	for i := 0; i < num; i++ {
		matx[i] = make([]int, num)
	}

	row, col := 0, num/2
	for i := 1; i <= num*num; i++ {
		matx[row][col] = i
		prevRow, prevCol := row, col
		row, col = (row+num-1)%num, (col+1)%num
		if matx[row][col] != 0 {
			row, col = (prevRow+1)%num, prevCol
		}
	}
	return matx
}
func main() {
	// Solution for Day 06: magic_sqr_of_odno
	var n int
	fmt.Scan(&n)
	if n%2 == 0 {
		fmt.Println("Magic square is only possible for odd values of n.")
		return
	}

	magicnum := (n * (n*n + 1)) / 2
	fmt.Println("Magic number:", magicnum)

	magicMatrix := calcMagicMatrx(n)
	printMatrix(magicMatrix, n)

}
