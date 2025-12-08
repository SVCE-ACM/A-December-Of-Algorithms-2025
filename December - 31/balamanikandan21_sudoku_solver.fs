open System

[<EntryPoint>]
let main _ =
    let grid = Array2D.create 9 9 '.'
    
    for i in 0 .. 8 do
        let line = Console.ReadLine()
        if not (String.IsNullOrWhiteSpace(line)) then
            let parts = line.Split(' ', StringSplitOptions.RemoveEmptyEntries)
            for j in 0 .. 8 do
                if j < parts.Length then
                    grid.[i,j] <- parts.[j].[0]
                
    let isValid r c k =
        let mutable ok = true
        for i in 0 .. 8 do
            if grid.[r,i] = k then ok <- false
            if grid.[i,c] = k then ok <- false
            
        let startR = (r / 3) * 3
        let startC = (c / 3) * 3
        for i in 0 .. 2 do
            for j in 0 .. 2 do
                if grid.[startR + i, startC + j] = k then ok <- false
        ok
        
    let rec solve r c =
        if r = 9 then true
        else
            let nextR = if c = 8 then r + 1 else r
            let nextC = if c = 8 then 0 else c + 1
            
            if grid.[r,c] <> '.' then
                solve nextR nextC
            else
                let mutable found = false
                let mutable k = '1'
                while k <= '9' && not found do
                    if isValid r c k then
                        grid.[r,c] <- k
                        if solve nextR nextC then found <- true
                        else grid.[r,c] <- '.'
                    k <- char (int k + 1)
                found
                
    if solve 0 0 then
        for i in 0 .. 8 do
            for j in 0 .. 8 do
                if j > 0 then printf " "
                printf "%c" grid.[i,j]
            printfn ""
    0
