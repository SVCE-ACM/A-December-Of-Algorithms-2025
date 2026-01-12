package main
import "fmt"
func main() {
    var N int
    fmt.Print("Enter the value of N: ")
    fmt.Scan(&N)
    count := 0
    for i := 1; i*i <= N; i++ {
        fmt.Print(i*i, " ")
        count++
    }
    fmt.Println()
    fmt.Println("Total count:", count)
}
