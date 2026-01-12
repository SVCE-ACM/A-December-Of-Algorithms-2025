open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let parts = line1.Split(' ', StringSplitOptions.RemoveEmptyEntries)
        let R = int parts.[0]
        let C = int parts.[1]
        
        let grid = Array2D.zeroCreate R C
        for i in 0 .. R - 1 do
            let rowLine = Console.ReadLine()
            let nums = rowLine.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
            for j in 0 .. C - 1 do
                grid.[i, j] <- nums.[j]
                
        let memo = Array2D.create R C 0
        let directions = [| (-1,0); (1,0); (0,-1); (0,1) |]
        
        let rec dfs r c =
            if memo.[r,c] <> 0 then memo.[r,c]
            else
                let mutable maxLen = 1
                for (dr, dc) in directions do
                    let nr, nc = r + dr, c + dc
                    if nr >= 0 && nr < R && nc >= 0 && nc < C && grid.[nr,nc] > grid.[r,c] then
                        let len = 1 + dfs nr nc
                        if len > maxLen then maxLen <- len
                memo.[r,c] <- maxLen
                maxLen
                
        let mutable overallMax = 0
        for i in 0 .. R - 1 do
            for j in 0 .. C - 1 do
                let res = dfs i j
                if res > overallMax then overallMax <- res
                
        printfn "%d" overallMax
        0
