import time
x = float
y = float
result = [None]*100_000
print("Array")
for timeA in range(100_000):
    x = int(round(time.time() * 1_000_000))
    size = 2_000
    re = [None]*(size - 1)
    for i in range(2,size+1):
        re[i - 2] = i
    for i in re :
        if(i == 0) : continue
        if(i > size**0.5): break
        for j in range(i+i,size+1,i):
            if(j%i == 0) :
                re[j-2] = 0
    y = int(round(time.time() * 1_000_000))
    # for k in re: 
    #     if k!=0 : print(k)
    result[timeA] = y - x
    # print((str(y - x))+ "uS")

sum_ = 0
for  d in result: sum_ += d
average = sum_ / len(result)
print("total time = " + '%.2E' %(sum(result)/1E6) + "S exc " + str(len(result)) + " time")
print("avg = " + '%.2E' %(average/1E6) + "S")
print("min = " + '%.2E' %(min(result)/1E6) + "S")
print("max = " + '%.2E' %(max(result)/1E6) + "S")
