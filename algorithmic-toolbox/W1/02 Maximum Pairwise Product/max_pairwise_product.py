# python3


def max_pairwise_product(numbers):
    numbers.sort(reverse=True)

    return numbers[0] * numbers[1]


if __name__ == '__main__':
    input_n = int(input())
    input_numbers = [int(x) for x in input().split()]
    print(max_pairwise_product(input_numbers))

