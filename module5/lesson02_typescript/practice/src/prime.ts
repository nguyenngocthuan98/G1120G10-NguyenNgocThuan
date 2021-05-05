// Kiểm tra số nguyên tố
function isPrime(n: number): boolean {
    let isPrime = true;
    if (n < 2) {
        isPrime = false;
    } else if (n > 2) {
        for (let i = 2; i < Math.sqrt(n); i++) {
            if (n % i === 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}

let array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
let sump: number = 0;
for (let number of array){
    if (isPrime(number)){
        sump+=number;
    }
}
console.log("Tổng các số nguyên tố trong mảng trên là: " + sum);
