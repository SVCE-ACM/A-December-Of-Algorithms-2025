open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let vStr = if line1.Contains("=") then line1.Split('=') |> Array.last else line1
        let V = int (vStr.Trim())
        
        let matrix = Array2D.create V V 100000000 
        let dist = Array2D.create V V 100000000
        
        let mutable content = ""
        let mutable line = Console.ReadLine()
        while line <> null do
             content <- content + line
             line <- Console.ReadLine()
             
        let edgesRaw = 
             content
                 .Replace("edges", "")
                 .Replace("=", "")
                 .Replace(" ", "")
                 .Replace("],[", "|")
                 .Replace("[", "")
                 .Replace("]", "")
                 .Split('|', StringSplitOptions.RemoveEmptyEntries)
        
        for e in edgesRaw do
            let p = e.Split(',', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
            if p.Length >= 3 then
                let u, v, w = p.[0], p.[1], p.[2]
                if u < V && v < V then
                    matrix.[u,v] <- w
                    matrix.[v,u] <- w
                    dist.[u,v] <- w
                    dist.[v,u] <- w
            
        for i in 0 .. V - 1 do dist.[i,i] <- 0
        
        let mutable minCycle = 100000000
        
        for k in 0 .. V - 1 do
            for i in 0 .. k - 1 do
                for j in 0 .. k - 1 do
                    if i <> j then
                        let res = dist.[i,j] + matrix.[i,k] + matrix.[k,j]
                        if res < minCycle then minCycle <- res
            
            for i in 0 .. V - 1 do
                for j in 0 .. V - 1 do
                    if dist.[i,k] + dist.[k,j] < dist.[i,j] then
                        dist.[i,j] <- dist.[i,k] + dist.[k,j]
                        
        if minCycle >= 100000000 then printfn "-1" 
        else printfn "%d" minCycle
        0
