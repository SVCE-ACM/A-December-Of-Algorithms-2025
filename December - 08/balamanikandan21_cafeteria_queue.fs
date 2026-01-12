open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    let line2 = Console.ReadLine()
    
    let parse (s:string) =
        if String.IsNullOrWhiteSpace(s) then [||]
        else
            let start = s.IndexOf('[')
            let end_ = s.LastIndexOf(']')
            if start >= 0 && end_ > start then
                s.Substring(start + 1, end_ - start - 1)
                 .Split([|','; ' '|], StringSplitOptions.RemoveEmptyEntries)
                 |> Array.map int
            else [||]
         
    let students = parse line1
    let sandwiches = parse line2
    
    let mutable count0 = 0
    let mutable count1 = 0
    for s in students do
        if s = 0 then count0 <- count0 + 1 else count1 <- count1 + 1
        
    let mutable i = 0
    let n = sandwiches.Length
    let mutable possible = true
    
    while i < n && possible do
        let sand = sandwiches.[i]
        if sand = 0 then
            if count0 > 0 then
                count0 <- count0 - 1
                i <- i + 1
            else
                possible <- false
        else
            if count1 > 0 then
                count1 <- count1 - 1
                i <- i + 1
            else
                possible <- false
                
    printfn "%d" (n - i)
    0
