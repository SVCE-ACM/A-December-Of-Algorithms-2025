open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    let n = 
        if line.Contains(":") then
            line.Split(':') |> Array.last |> String.filter Char.IsDigit |> int
        else
            int line
            
    if n % 2 = 0 then
        printfn "Magic square is only possible for odd values of n."
    else
        let magicConstant = (n * (n * n + 1)) / 2
        printfn "Magic constant: %d" magicConstant
        
        let grid = Array2D.zeroCreate n n
        let mutable r = 0
        let mutable c = n / 2
        
        for k in 1 .. n * n do
            grid.[r, c] <- k
            let nextR = (r - 1 + n) % n
            let nextC = (c + 1) % n
            if grid.[nextR, nextC] <> 0 then
                r <- (r + 1) % n
            else
                r <- nextR
                c <- nextC
                
        for i in 0 .. n - 1 do
            for j in 0 .. n - 1 do
                printf "%-4d" grid.[i,j]
            printfn ""
    0
