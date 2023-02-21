symbolYear = {True: '閏年', False: '平年'}
while(True):
    try:
        year = int(input())
        print(symbolYear[(year % 4 == 0 and year % 100 != 0) or year % 400 == 0])  
    except:
        break
