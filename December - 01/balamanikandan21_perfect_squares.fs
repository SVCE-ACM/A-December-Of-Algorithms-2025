open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let n = int line
        let mutable i = 1
        let mutable count = 0
        
        while i * i <= n do
            if count > 0 then printf " "
            printf "%d" (i * i)
            count <- count + 1
            i <- i + 1
            
        printfn ""
        printfn "%d" count
        0
