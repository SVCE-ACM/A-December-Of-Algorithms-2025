open System
open System.Collections.Generic

[<EntryPoint>]
let main _ =
    let line = Console.ReadLine()
    if String.IsNullOrWhiteSpace(line) then 0
    else
        let parts = 
            line
                .Replace("ops", "")
                .Replace("=", "")
                .Replace("[", "")
                .Replace("]", "")
                .Replace("\"", "")
                .Replace("'", "")
                .Split([|','; ' '|], StringSplitOptions.RemoveEmptyEntries)
        
        let stack = Stack<int>()
        for op in parts do
            match op with
            | "C" -> if stack.Count > 0 then stack.Pop() |> ignore
            | "D" -> 
                if stack.Count > 0 then
                    stack.Push(stack.Peek() * 2)
            | "+" ->
                if stack.Count >= 2 then
                    let top = stack.Pop()
                    let newTop = top + stack.Peek()
                    stack.Push(top)
                    stack.Push(newTop)
            | _ -> 
                let success, val_ = Int32.TryParse(op)
                if success then stack.Push(val_)
                
        let sum = stack |> Seq.sum
        printfn "%d" sum
        0
