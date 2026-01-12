open System

[<EntryPoint>]
let main _ =
    let readVal prefix = 
        let line = Console.ReadLine()
        if String.IsNullOrWhiteSpace(line) then ""
        else
            if line.Contains("=") then
                line.Split('=') |> Array.last |> fun s -> s.Trim()
            else line.Trim()
            
    let parseArr (s:string) =
        if String.IsNullOrWhiteSpace(s) then [||]
        else
            let start = s.IndexOf('[')
            let end_ = s.LastIndexOf(']')
            if start <> -1 && end_ > start then
                 s.Substring(start + 1, end_ - start - 1)
                  .Split([|','; ' '|], StringSplitOptions.RemoveEmptyEntries)
                  |> Array.map int
            else [||]
        
    let targetStr = readVal "target"
    if targetStr = "" then 0
    else
        let target = int targetStr
        let nStr = readVal "n"
        let n = int nStr
        let posStr = Console.ReadLine() 
        let spdStr = Console.ReadLine() 
        
        if n = 0 then
            printfn "No turtle fleets formed."
        else
            let positions = parseArr posStr
            let speeds = parseArr spdStr
            
            let turtles = 
                Array.zip positions speeds
                |> Array.sortByDescending (fun (p, _) -> p)
                
            let times = 
                turtles 
                |> Array.map (fun (p, s) -> double(target - p) / double s)
                
            let mutable fleets = 0
            let mutable maxTime = 0.0
            
            for t in times do
                if t > maxTime then
                    fleets <- fleets + 1
                    maxTime <- t
                    
            printfn "The number of turtle fleets is: %d" fleets
        0
