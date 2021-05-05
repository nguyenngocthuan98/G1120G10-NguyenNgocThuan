function sumFibonacci(number: number) {
    let sum: number = 0;
    let first: number = 0;
    let second: number = 1;
    let third: number;
    let count: number = 2;
    sum += first + second;

    while (count <= number) {
        third = first + second;
        first = second;
        second = third;
        sum += third;
        count++;
    }
    console.log(number + " first Fibonacci is " + sum);
}

sumFibonacci(10);
