for i in range(int(input())):
    numbers = list(map(int, input().split()))
    if (numbers[3] + numbers[0] == numbers[2] + numbers[1]):
        print(*numbers, end=f' {2 * numbers[3]-numbers[2]}\n')
    else:
        print(*numbers, end=f' {int(numbers[3] * (numbers[3] / numbers[2]))}\n')
