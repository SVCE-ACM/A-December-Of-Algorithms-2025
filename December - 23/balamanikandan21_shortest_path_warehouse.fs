open System
open System.Collections.Generic

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
            let gridLine = Console.ReadLine()
            let gp = gridLine.Split(' ', StringSplitOptions.RemoveEmptyEntries)
            for j in 0 .. C - 1 do
                if j < gp.Length then
                    grid.[i,j] <- int gp.[j]
        
        let startR, startC = 0, 0
        let endR, endC = R - 1, C - 1
        
        if grid.[startR,startC] = 1 || grid.[endR,endC] = 1 then
            printfn "-1"
        else
            let dist = Array2D.create R C -1
            let q = Queue<int*int>()
            
            dist.[startR,startC] <- 0
            q.Enqueue((startR,startC))
            let directions = [| (-1,0); (1,0); (0,-1); (0,1) |]
            
            let mutable found = false
            
            while q.Count > 0 && not found do
                let (r, c) = q.Dequeue()
                if r = endR && c = endC then found <- true
                else
                    for (dr, dc) in directions do
                        let nr, nc = r + dr, c + dc
                        if nr >= 0 && nr < R && nc >= 0 && nc < C && grid.[nr,nc] = 0 && dist.[nr,nc] = -1 then
                            dist.[nr,nc] <- dist.[r,c] + 1
                            q.Enqueue((nr,nc))
                            
            if dist.[endR,endC] <> -1 then
                printfn "%d" dist.[endR,endC]
            else
                printfn "-1"
        0
