open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let start = line.IndexOf('[')
        let end_ = line.LastIndexOf(']')
        if start <> -1 && end_ > start then
            let content = line.Substring(start + 1, end_ - start - 1)
            let parts = content.Split(',', StringSplitOptions.RemoveEmptyEntries) |> Array.map (fun s -> s.Trim())
            
            let mutable seenNull = false
            let mutable isComplete = true
             
            for p in parts do
                if p = "null" then
                    seenNull <- true
                else
                    if seenNull then isComplete <- false
            
            if isComplete then printfn "true" else printfn "false"
        else
            printfn "false"
        0
