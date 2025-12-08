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
        
        let result = Array.create n -1
        let stack = Stack<int>() 
        
        for i in 0 .. n - 1 do
            while stack.Count > 0 && heights.[i] > heights.[stack.Peek()] do
                let idx = stack.Pop()
                result.[idx] <- heights.[i]
            stack.Push(i)
            
        for i in 0 .. n - 1 do
            if i > 0 then printf " "
            printf "%d" result.[i]
        printfn ""
        0
