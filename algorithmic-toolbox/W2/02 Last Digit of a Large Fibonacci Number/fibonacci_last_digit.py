# python3
import sys


def get_fibonacci_last_digit(n):
    if (n < 1):
        return n

    prev = 0
    curr = 1

    for _ in range(n - 1):
        prev, curr = curr % 10, (prev + curr) % 10

    return curr % 10


if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    print(get_fibonacci_last_digit(n))
