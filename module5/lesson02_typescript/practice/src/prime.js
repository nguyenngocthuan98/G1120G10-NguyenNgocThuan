// Kiểm tra số nguyên tố
function isPrime(n) {
    var isPrime = true;
    if (n < 2) {
        isPrime = false;
    }
    else if (n > 2) {
        for (var i = 2; i < Math.sqrt(n); i++) {
            if (n % i === 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}
var array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
// @ts-ignore
var sum = 0;
for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
    var number = array_1[_i];
    if (isPrime(number)) {
        sum += number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);
