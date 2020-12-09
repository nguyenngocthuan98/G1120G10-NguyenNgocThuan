function check() {
    let age = document.getElementById("age").value;
    let height = parseFloat(document.getElementById("height").value);
    let weight = parseFloat(document.getElementById("weight").value);
    let bmi = 0;
    let status;

    bmi = weight / (Math.pow(height, 2));
    if (bmi < 18.5) {
        status = "Thiếu cân";
    } else if (bmi < 25) {
        status = "Bình thường";
    } else if (bmi < 30) {
        status = "Quá cân";
    } else {
        status = "Béo phì";
    }

    document.getElementById("dp-age").innerText = age + "tuổi";
    document.getElementById("dp-weight").innerText = weight + "Kg"; 
    document.getElementById("dp-height").innerText = height + "m";
    document.getElementById("dp-bmi").innerText = bmi.toFixed(2)+".";
    document.getElementById("dp-status").innerText ="Bạn đang " + status;
}