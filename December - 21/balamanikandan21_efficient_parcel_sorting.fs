open System

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let line2 = Console.ReadLine()
        if String.IsNullOrWhiteSpace(line2) then 0
        else
            let weights = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
            Array.sortInPlace weights
            
            for i in 0 .. n - 1 do
                if i > 0 then printf " "
                printf "%d" weights.[i]
            printfn ""
            0
