# Uses python3
import sys

def get_fibonacci_last_digit(n):
    if (n < 1):
        return n

    prev = 0
    curr = 1

    for _ in range(n - 1):
        prev, curr = curr % 10, (prev + curr) % 10

    return curr % 10

def get_fibonacci_sum(n):
    # Little trick:
    # Pisano period modulo 10 is 60
    # Sum of n Fibonacci numbers is F(n + 2) - 1
    last_digit = get_fibonacci_last_digit((n + 2) % 60)
    sum_last_digit = (last_digit - 1) if (last_digit != 0) else 9
    return sum_last_digit

if __name__ == '__main__':
    input = sys.stdin.read()
    n = int(input)
    print(get_fibonacci_sum(n))
