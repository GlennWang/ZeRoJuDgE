transferSymbol = ['普通', '吉', '大吉']
month, day = list(map(int, input().split()))
print(transferSymbol[(month * 2 + day) % 3])