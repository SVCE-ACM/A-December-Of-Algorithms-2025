import sys

def parse(s: str):
    idx = 0
    n = len(s)

    def parse_val():
        nonlocal idx
        if s[idx] == '[':
            idx += 1
            lst = []
            while idx < n and s[idx] != ']':
                lst.append(parse_val())
                if idx < n and s[idx] == ',':
                    idx += 1
            idx += 1  # skip ']'
            return lst
        else:
            sign = 1
            if s[idx] == '-':
                sign = -1
                idx += 1
            num = 0
            while idx < n and s[idx].isdigit():
                num = num * 10 + int(s[idx])
                idx += 1
            return sign * num

    return parse_val()


def serialize(obj):
    if isinstance(obj, list):
        return '[' + ','.join(serialize(x) for x in obj) + ']'
    return str(obj)


def solve():
    raw = sys.stdin.read().strip()
    if not raw:
        return
    s = raw.strip()
    if len(s) >= 2 and s[0] == '"' and s[-1] == '"':
        s = s[1:-1]
    result = parse(s)
    print(serialize(result))

if __name__ == "__main__":
    solve()
