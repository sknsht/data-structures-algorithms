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

def get_fibonacci_sum(n):
    # Little trick:
    # Pisano period modulo 10 is 60
    # Sum of n Fibonacci numbers is F(n + 2) - 1
    last_digit = get_fibonacci_last_digit((n + 2) % 60)
    sum_last_digit =  get_last_digit_after_subtraction(last_digit, 1)
    return sum_last_digit

def get_fibonacci_partial_sum(a, b):
    last_digit_partial_sum = get_last_digit_after_subtraction(get_fibonacci_sum(b), get_fibonacci_sum(a - 1))

    return last_digit_partial_sum

def get_last_digit_after_subtraction(last_digit_minuend, last_digit_subtrahend):
    if (last_digit_minuend < last_digit_subtrahend):
        last_digit_minuend = last_digit_minuend + 10;
    return last_digit_minuend - last_digit_subtrahend

if __name__ == '__main__':
    input = sys.stdin.read();
    a, b = map(int, input.split())
    print(get_fibonacci_partial_sum(a, b))