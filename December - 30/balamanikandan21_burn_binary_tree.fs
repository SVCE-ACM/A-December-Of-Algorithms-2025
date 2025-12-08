open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine() 
    let line2 = Console.ReadLine() 
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let parseRoot s = 
            let start = s.IndexOf('[')
            let end_ = s.LastIndexOf(']')
            if start >= 0 then
                s.Substring(start + 1, end_ - start - 1).Split(',', StringSplitOptions.RemoveEmptyEntries)
                |> Array.map (fun x -> x.Trim())
            else [||]
            
        let nodes = parseRoot line1
        let targetStr = 
            if line2.Contains("=") then line2.Split('=') |> Array.last else line2
        let target = int (targetStr.Trim())
        
        let adj = Dictionary<int, ResizeArray<int>>()
        let addEdge u v =
            if not (adj.ContainsKey(u)) then adj.[u] <- ResizeArray<int>()
            if not (adj.ContainsKey(v)) then adj.[v] <- ResizeArray<int>()
            adj.[u].Add(v)
            adj.[v].Add(u)
            
        let q = Queue<int>() 
        if nodes.Length > 0 && nodes.[0] <> "null" then
            let rootVal = int nodes.[0]
            if not (adj.ContainsKey(rootVal)) then adj.[rootVal] <- ResizeArray<int>()
            q.Enqueue(rootVal)
            
            let mutable i = 1
            while q.Count > 0 && i < nodes.Length do
                let parent = q.Dequeue()
                
                if i < nodes.Length then
                    if nodes.[i] <> "null" then
                        let leftVal = int nodes.[i]
                        addEdge parent leftVal
                        q.Enqueue(leftVal)
                    i <- i + 1
                    
                if i < nodes.Length then
                    if nodes.[i] <> "null" then
                        let rightVal = int nodes.[i]
                        addEdge parent rightVal
                        q.Enqueue(rightVal)
                    i <- i + 1
                    
        let burnQ = Queue<int>()
        let visited = HashSet<int>()
        
        burnQ.Enqueue(target)
        visited.Add(target) |> ignore
        
        while burnQ.Count > 0 do
            let count = burnQ.Count
            let stepBurned = ResizeArray<string>()
            for _ in 1 .. count do
                let u = burnQ.Dequeue()
                stepBurned.Add(string u)
                if adj.ContainsKey(u) then
                    for v in adj.[u] do
                        if visited.Add(v) then
                            burnQ.Enqueue(v)
            
            printfn "%s" (String.Join(", ", stepBurned))
            
        0
