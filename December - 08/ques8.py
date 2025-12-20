st=eval(input("students list"))
sw=eval(input("sandwich list"))
if len(st)==len(sw):
    
    while len(st)!=0:
        if st[0]==sw[0]:
            st.pop(0)
            sw.pop(0)
        else:

            if sw[0] in st:
                
                a=st.pop(0)
                st.append(a)
            else:
                print(len(st))
                break
    else:
        print(0)
else:
    print("invalid list")
