open System

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let n = int line
        for i in 1 .. n do
            let oct = Convert.ToString(i, 8)
            let hex = Convert.ToString(i, 16).ToUpper()
            let bin = Convert.ToString(i, 2)
            printfn "%5d %5s %5s %5s" i oct hex bin
        0
