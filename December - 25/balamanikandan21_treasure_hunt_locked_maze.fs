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
        let mutable sr, sc = 0, 0
        let mutable keysMap = Dictionary<char, int>()
        let mutable keyCounter = 0
        
        let lines = ResizeArray<string>()
        for i in 0 .. R - 1 do
            lines.Add(Console.ReadLine())
            
        for i in 0 .. R - 1 do
            for j in 0 .. C - 1 do
                let c = lines.[i].[j]
                if c >= 'a' && c <= 'z' then
                    if not (keysMap.ContainsKey(c)) then
                         keysMap.[c] <- keyCounter
                         keyCounter <- keyCounter + 1
        
        for i in 0 .. R - 1 do
            let s = lines.[i]
            for j in 0 .. C - 1 do
                let charVal = s.[j]
                grid.[i,j] <- charVal
                if charVal = 'S' then
                    sr <- i
                    sc <- j
                    
        let limit = 1 <<< keyCounter
        let dist = Array3D.create R C limit -1
        let q = Queue<int*int*int>()
        
        dist.[sr,sc,0] <- 0
        q.Enqueue((sr,sc,0))
        
        let directions = [| (-1,0); (1,0); (0,-1); (0,1) |]
        let mutable minSteps = -1
        
        while q.Count > 0 && minSteps = -1 do
            let (r, c, mask) = q.Dequeue()
            let currentDist = dist.[r,c,mask]
            
            if grid.[r,c] = 'T' then minSteps <- currentDist
            else
                for (dr, dc) in directions do
                    let nr, nc = r + dr, c + dc
                    if nr >= 0 && nr < R && nc >= 0 && nc < C then
                        let nDetails = grid.[nr,nc]
                        if nDetails <> '#' then
                            let mutable allowed = true
                            if nDetails >= 'A' && nDetails <= 'Z' then
                                let keyChar = Char.ToLower(nDetails)
                                if keysMap.ContainsKey(keyChar) then
                                    let bit = keysMap.[keyChar]
                                    if (mask &&& (1 <<< bit)) = 0 then allowed <- false
                                else
                                    allowed <- false
                                    
                            if allowed then
                                let mutable nextMask = mask
                                if nDetails >= 'a' && nDetails <= 'z' then
                                     if keysMap.ContainsKey(nDetails) then
                                         let bit = keysMap.[nDetails]
                                         nextMask <- mask ||| (1 <<< bit)
                                
                                if dist.[nr,nc,nextMask] = -1 then
                                    dist.[nr,nc,nextMask] <- currentDist + 1
                                    q.Enqueue((nr,nc,nextMask))
                                    
        printfn "%d" minSteps
        0
