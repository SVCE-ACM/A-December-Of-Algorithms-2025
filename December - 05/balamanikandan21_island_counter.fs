open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let parts = line.Split(' ', StringSplitOptions.RemoveEmptyEntries)
        let R = int parts.[0]
        let C = int parts.[1]
        
        let grid = Array2D.zeroCreate R C
        for i in 0 .. R - 1 do
            let rowLine = Console.ReadLine()
            if not (String.IsNullOrWhiteSpace(rowLine)) then
                let rowParts = rowLine.Split(' ', StringSplitOptions.RemoveEmptyEntries)
                for j in 0 .. C - 1 do
                     if j < rowParts.Length then
                        grid.[i, j] <- int rowParts.[j]
                
        let visited = Array2D.zeroCreate R C
        let mutable count = 0
        let directions = [| (-1,0); (1,0); (0,-1); (0,1) |] 
        
        for i in 0 .. R - 1 do
            for j in 0 .. C - 1 do
                if grid.[i,j] = 1 && not visited.[i,j] then
                    count <- count + 1
                    let q = Queue<int*int>()
                    q.Enqueue((i,j))
                    visited.[i,j] <- true
                    while q.Count > 0 do
                        let (r, c) = q.Dequeue()
                        for (dr, dc) in directions do
                            let nr, nc = r + dr, c + dc
                            if nr >= 0 && nr < R && nc >= 0 && nc < C && grid.[nr,nc] = 1 && not visited.[nr,nc] then
                                visited.[nr,nc] <- true
                                q.Enqueue((nr,nc))
        printfn "%d" count
        0
