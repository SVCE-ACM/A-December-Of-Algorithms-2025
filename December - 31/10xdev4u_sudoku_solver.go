package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func isValid(board [][]byte, row, col int, num byte) bool {
	for i := 0; i < 9; i++ {
		if board[row][i] == num {
			return false
		}
	}

	for i := 0; i < 9; i++ {
		if board[i][col] == num {
			return false
		}
	}

	startRow := (row / 3) * 3
	startCol := (col / 3) * 3
	for i := 0; i < 3; i++ {
		for j := 0; j < 3; j++ {
			if board[startRow+i][startCol+j] == num {
				return false
			}
		}
	}

	return true
}

func isValidInitialState(board [][]byte) bool {
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] != '.' {
				currentVal := board[i][j]

				board[i][j] = '.'

				if !isValid(board, i, j, currentVal) {
					board[i][j] = currentVal
					return false
				}

				board[i][j] = currentVal
			}
		}
	}
	return true
}

func solveSudoku(board [][]byte) bool {
	if !isValidInitialState(board) {
		return false
	}

	return backtrack(board)
}

func backtrack(board [][]byte) bool {
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			if board[i][j] == '.' {
				for num := byte('1'); num <= '9'; num++ {
					if isValid(board, i, j, num) {
						board[i][j] = num

						if backtrack(board) {
							return true
						}

						board[i][j] = '.'
					}
				}
				return false
			}
		}
	}
	return true
}

func printBoard(board [][]byte) {
	for i := 0; i < 9; i++ {
		for j := 0; j < 9; j++ {
			fmt.Printf("%c", board[i][j])
			if j < 8 {
				fmt.Print(" ")
			}
		}
		fmt.Println()
	}
}

func main() {
	board := make([][]byte, 9)
	scanner := bufio.NewScanner(os.Stdin)

	for i := 0; i < 9; i++ {
		if scanner.Scan() {
			line := scanner.Text()
			parts := strings.Fields(line)
			if len(parts) < 9 {
				continue
			}
			board[i] = make([]byte, 9)
			for j := 0; j < 9; j++ {
				board[i][j] = parts[j][0]
			}
		}
	}

	if solveSudoku(board) {
		printBoard(board)
	} else {
		fmt.Println("No solution exists")
	}
}
