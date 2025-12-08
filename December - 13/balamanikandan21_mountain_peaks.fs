open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line1 = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line1) then 0
    else
        let n = int line1
        let line2 = Console.ReadLine()
        let heights = line2.Split(' ', StringSplitOptions.RemoveEmptyEntries) |> Array.map int
        
        let peaks = ResizeArray<int>()
        for i in 1 .. n - 2 do
            if heights.[i] > heights.[i-1] && heights.[i] > heights.[i+1] then
                peaks.Add(i)
                
        if peaks.Count = 0 then
            printfn "-1"
        else
            for i in 0 .. peaks.Count - 1 do
                if i > 0 then printf " "
                printf "%d" peaks.[i]
            printfn ""
        0
