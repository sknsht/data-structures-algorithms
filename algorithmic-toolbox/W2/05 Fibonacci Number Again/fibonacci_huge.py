# python3
import sys


def get_fibonacci(n):
    if (n < 1):
        return n

    prev = 0
    curr = 1

    for _ in range(n - 1):
        prev, curr = curr, prev + curr

    return curr
    
def get_pisano_period(m):
    prev = 0
    curr = 1
    
    for i in range(m * m):
        prev, curr = curr, (prev + curr) % m
        if prev == 0 and curr == 1:
            return i + 1
            
def get_fibonacci_huge(n, m):
    remainder = n % get_pisano_period(m)
    return get_fibonacci(remainder) % m

if __name__ == '__main__':
    input = sys.stdin.read();
    n, m = map(int, input.split())
    print(get_fibonacci_huge(n, m))
