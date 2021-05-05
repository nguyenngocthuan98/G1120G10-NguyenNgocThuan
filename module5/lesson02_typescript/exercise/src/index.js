function sumFibonacci(number) {
    var sum = 0;
    var first = 0;
    var second = 1;
    var third;
    var count = 2;
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
