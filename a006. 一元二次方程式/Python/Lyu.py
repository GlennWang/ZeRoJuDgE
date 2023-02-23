import math
a, b, c = list(map(int, input().split()))
diff_fomula = b*b-(4*a*c)
result = "No real root"
if (diff_fomula >= 0):
    root1 = int((-b + math.sqrt(diff_fomula))/(2*a))
    root2 = int((-b - math.sqrt(diff_fomula))/(2*a))
    if (root1 == root2):
        result = f"Two same roots x={root1}"
    else:
        result = f"Two different roots x1={root1} , x2={root2}"
print(result)
