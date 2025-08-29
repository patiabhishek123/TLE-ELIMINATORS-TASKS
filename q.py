for _ in range(int(input())):
    n = int(input())
    s = input()
    best = [0]*n
    ct = 0
    for i in range(n):
        if s[i] == 'A': ct += 1
        elif s[i] == 'B': best[i] = ct
        else: ct = 0
    ct = 0
    for i in reversed(range(n)):
        if s[i] == 'A': ct = 0
        elif s[i] == 'B': best[i] = max(best[i], ct)
        else: ct += 1
    print(sum(best))