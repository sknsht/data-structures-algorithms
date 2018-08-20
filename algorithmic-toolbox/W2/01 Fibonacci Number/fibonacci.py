# python3


def get_fibonacci(n):
    if (n < 1):
        return n

    prev = 0
    curr = 1

    for _ in range(n - 1):
        prev, curr = curr, prev + curr

    return curr


n = int(input())
print(get_fibonacci(n))
