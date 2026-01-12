open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let m = Console.ReadLine() |> int
        
        let adj = Array.create n ResizeArray<int*int>()
        for i in 0 .. n - 1 do adj.[i] <- ResizeArray<int*int>()
        
        for i in 1 .. m do
            let edgeLine = Console.ReadLine()
            let parts = edgeLine.Split(' ', StringSplitOptions.RemoveEmptyEntries)
            let u = int parts.[0]
            let v = int parts.[1]
            let w = int parts.[2]
            adj.[u].Add((v, w))
            
        let source = Console.ReadLine() |> int
        
        let dist = Array.create n Int32.MaxValue
        let pq = PriorityQueue<int, int>()
        
        dist.[source] <- 0
        pq.Enqueue(source, 0)
        
        while pq.Count > 0 do
            let success, u, d = pq.TryDequeue()
            if success then
                if d <= dist.[u] then
                    for (v, w) in adj.[u] do
                        if dist.[u] + w < dist.[v] then
                            dist.[v] <- dist.[u] + w
                            pq.Enqueue(v, dist.[v])
                            
        let maxTime = dist |> Array.max
        if maxTime = Int32.MaxValue then printfn "-1"
        else printfn "%d" maxTime
        0
