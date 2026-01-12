open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let parts = line1.Split(' ', StringSplitOptions.RemoveEmptyEntries)
        let V = int parts.[0]
        let E = int parts.[1]
        
        let adj = Array.create V ResizeArray<int>()
        for i in 0 .. V - 1 do adj.[i] <- ResizeArray<int>()
        
        for i in 1 .. E do
            let edgeLine = Console.ReadLine()
            let edgeParts = edgeLine.Split(' ', StringSplitOptions.RemoveEmptyEntries)
            let u = int edgeParts.[0]
            let v = int edgeParts.[1]
            adj.[u].Add(v)
            adj.[v].Add(u)
            
        let stateLine = Console.ReadLine()
        let states = stateLine.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
        
        let dist = Array.create V -1
        let q = Queue<int>()
        
        for i in 0 .. V - 1 do
            if states.[i] = 1 then
                dist.[i] <- 0
                q.Enqueue(i)
                
        let mutable maxDist = 0
        let mutable filledCount = q.Count
        
        while q.Count > 0 do
            let u = q.Dequeue()
            if dist.[u] > maxDist then maxDist <- dist.[u]
            
            for v in adj.[u] do
                if dist.[v] = -1 then
                    dist.[v] <- dist.[u] + 1
                    filledCount <- filledCount + 1
                    q.Enqueue(v)
                    
        if filledCount = V then
            printfn "%d" maxDist
        else
            printfn "-1"
        0
