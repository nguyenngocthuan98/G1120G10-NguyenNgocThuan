// Bai 1
function check() {
    let so_a = parseFloat(document.getElementById("so_a").value);
    let so_b = parseFloat(document.getElementById("so_b").value);
    if (so_a % so_b == 0) {
        document.getElementById("status").innerText = "Số a chia hết cho số b";
    } else {
        document.getElementById("status").innerText = "Số a KHÔNG chia hết cho số b";
    }
}

// Bai 2
function check_age() {
    let age = parseInt(document.getElementById("age").value);
    if (age < 1) {
        document.getElementById("status-age").innerText = "Tuổi không đúng";
    } else if (age < 16) {
        document.getElementById("status-age").innerText = "Bạn KHÔNG đủ tuổi học lớp 10";
    } else {
        document.getElementById("status-age").innerText = "Bạn đã đủ tuổi học lớp 10";
    }
}

// Bai 3
function check_num_int() {
    let num_int = parseInt(document.getElementById("num_int").value);
    if (num_int < 0) {
        document.getElementById("status-num_int").innerText = "Nhỏ hơn 0";
    }  else if (age = 0) {
        document.getElementById("status-num_int").innerText = "Bằng 0";
    } else {
        document.getElementById("status-num_int").innerText = "Lớn hơn 0";
    }
}

//Bai 4
function check_num_bigger() {
    let num_a = parseInt(document.getElementById("num_a").value);
    let num_b = parseInt(document.getElementById("num_b").value);
    let num_c = parseInt(document.getElementById("num_c").value);
    let max = num_a;

    if (max > num_b) {
        if (max < num_c) {
            max = num_c;
        }
    } else {
        max = num_b;
        if (max < num_c) {
            max = num_c;
        }
    }
    document.getElementById("status-num_int_bigger").innerText = max;
}

//Bai 5
function check_diem() {
    let numKtra = parseFloat(document.getElementById("num_ktra").value);
    let num_giuaki = parseFloat(document.getElementById("num_giuaki").value);
    let num_cuoiki = parseFloat(document.getElementById("num_cuoiki").value);
    let diemtrungbinh = 0;

    diemtrungbinh = (numKtra + num_giuaki * 2 + num_cuoiki * 3) / 6;
    console.log(diemtrungbinh);
    if (diemtrungbinh > 5) {
        if (diemtrungbinh > 8) {
            document.getElementById("status-num_diem").innerText = "Giỏi";
        } else {
            document.getElementById("status-num_diem").innerText = "Khá";
        }
    } else {
        document.getElementById("status-num_diem").innerText = "Yếu";
    }
}

//Bai 6
function check_num_sp() {
    let num_spham = parseInt(document.getElementById("num_spham").value);
    let rose = 0;

    if (num_spham < 100) {
        rose = 0;
    } else if (num_spham > 5000){
        rose = 50;
    } else {
        rose = 25;
    }
    document.getElementById("status-num_rose").innerText = "Bạn nhận được " + rose + "% hoa hồng khi bán được " + num_spham + " sản phẩm";
}

//Bai 7
function check_cuoc() {
    let num_sophut = parseInt(document.getElementById("num_sophut").value);
    let num_sogiay = parseInt(document.getElementById("num_sogiay").value);
    let cuoc = 0;
    // 1phut = 2000VND
    cuoc = (num_sophut * 2000) + ((num_sogiay / 60) * 2000);
    document.getElementById("status-cuoc").innerText = "Cước là: " + cuoc.toFixed(2) + " VND";
}
