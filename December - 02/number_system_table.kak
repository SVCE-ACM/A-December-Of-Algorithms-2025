define-command number-system-table %{
    evaluate-commands %sh{
        printf '%s\n' "$kak_selection" | awk '
        BEGIN {
            n = 0
        }
        {
            n = $1
        }
        END {
            if (n < 1 || n > 99) {
                print "echo Invalid input: N must be between 1 and 99"
                exit
            }
            
            for (i = 1; i <= n; i++) {
                dec = i
                oct = sprintf("%o", i)
                hex = sprintf("%X", i)
                bin = ""
                num = i
                
                if (num == 0) {
                    bin = "0"
                } else {
                    while (num > 0) {
                        bin = (num % 2) bin
                        num = int(num / 2)
                    }
                }
                
                printf "echo %5d %5s %5s %6s\n", dec, oct, hex, bin
            }
        }
        '
    }
}
