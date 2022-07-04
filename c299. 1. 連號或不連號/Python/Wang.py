def BubbleSort(arr):
    for i in range(1, len(arr)):
        for j in range(0, len(arr)-i):
            if arr[j] > arr[j+1]:
                arr[j], arr[j + 1] = arr[j + 1], arr[j]
    return arr


index = input().split(" ", 1)
nums = index[1].split(" ")

int_list = [int(i) for i in nums]

BubbleSort(int_list)

difference = int_list[-1] - int_list[0]
if(int(index[0])-1 == difference):
    print(f'{int_list[0]} {int_list[-1]} yes')
else:
    print(f'{int_list[0]} {int_list[-1]} no')
