# python3


def calc_fib(n):
    if (n < 1):
        return n

    prev = 0
    curr = 1

    for _ in range(n - 1):
        prev, curr = curr, prev + curr

    return curr


n = int(input())
print(calc_fib(n))
