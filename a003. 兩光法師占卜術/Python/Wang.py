M, D = input().split(" ")

switch = {0: lambda: print("普通"),
          1: lambda: print("吉"),
          2: lambda: print("大吉"), }

switch[(int(M)*2+int(D)) % 3]()
