let full_name = "Nguyễn Ngọc Thuần";
let identity_number = 192321321;
let birthday = "01/01/1990";
let email = "thuan@thuan.com";
let address = "Chưa chọn";
let type_customer = "Chưa chọn";
let discount = 0;
let amount_people = 0;
let amount_days = 0;
let type_service = "Chưa chọn";
let type_room = "Chưa chọn";
let pay_total = 0;
let addr_sale = 0;
let type_cus_sale =0; 
let day_sale = 0;
let choose;
let flg = true;

// hàm tính số tiền giảm giá
function giamGia() {
    switch (address) {
        case "Đà Nẵng":
            addr_sale = 20;
            break;
        case "Huế":
            addr_sale = 10;
            break;
        case "Quảng nam":
            addr_sale = 5;
            break;
        default:
            addr_sale = 0;
            break;
    }

    switch (type_customer) {
        case "Diamond ":
            type_cus_sale = 15;
            break;
        case "Platium ":
            type_cus_sale = 10;
            break;
        case "Gold":
            type_cus_sale = 5;
            break;
        case "Silver":
            type_cus_sale = 2;
            break;
        default:
            type_cus_sale = 0;
            break;
    }
    
    if (amount_days > 7 ) {
        day_sale = 30;
    } else if (amount_days >= 5) {
        day_sale = 20;  
    } else if (amount_days >= 2){
        day_sale = 10;
    } else {
        day_sale = 0;
    }
    
    discount = addr_sale + day_sale + type_cus_sale;
}
 // kết thúc tính số tiền giảm giá 

// hàm sửa thông tin
function edit_info() {
    let loop_checking; // biến để kiểm tra điều kiện lặp
    choose = parseInt(prompt(
        "1. Họ và tên: " + full_name + "\n"
        + "2. Số CMND: " + identity_number + "\n"
        + "3. Ngày sinh: " + birthday + "\n"
        + "4. Email: " + email + "\n"
        + "5. Địa chỉ: " + address + "\n"
        + "6. Loại Customer: " + type_customer + "\n"
        + "7. Số lượng đi kèm: " + amount_people + "\n"
        + "8. Số ngày thuê: " + amount_days + "\n"
        + "9. Loại dịch vụ: " + type_service + "\n"
        + "10. Loại phòng thuê: " + type_room + "\n"
    ));

    switch (choose) {
        case 1:
            do {
                let up_char = "";
                full_name = prompt("Họ và tên:", full_name);
                full_name = full_name.trim().toLowerCase();
                for (let i = 0; i < full_name.length; i++) {
                    if (full_name.charAt(i) === " " && full_name.charAt(i + 1) === " ") {
                        continue;
                    }
                    if (i === 0 || full_name.charAt(i - 1) === " ") {
                        up_char += full_name.charAt(i).toUpperCase();
                        continue;
                    } up_char += full_name.charAt(i);
                } full_name = up_char;
            } while (Number.isNaN(full_name));
            break;
        case 2:
            //let flg = true;
            do {
                alert("Số CMND phải có 8 kí tự số");
                identity_number = parseFloat(prompt("Số CMND:", identity_number));
                if (identity_number <= 99999999 && identity_number >= 10000000 && Number.isInteger(identity_number)) {
                    flg = false;
                } else {
                    alert("Số CMND " + identity_number + " SAI định dạng!");
                }
            } while (flg);
            break;
        case 3:
            //let flg = true;
            do {
            alert("Định dạng ngày sinh dd/mm/yyyy");
            birthday = prompt("Ngày sinh:", birthday);
            if (birthday.charAt(2) == "/" && birthday.charAt(5) == "/" && birthday.substring(0,1) <= 31 && birthday.substring(3,4) <= 12 && birthday.substring(6,10) <= 10000) {
                flg = false;
            } else {
                alert(birthday + " SAI định dạng!");
            }
            } while (flg);
            break;
        case 4:
            //let flg = true;
            let email_format = /^\w+@[a-zA-Z]{3,}.[a-z]{2,}$/;
            // /^ là mở; $/ là đóng; /w là a->Z 0->9 và dấu -; {số lượng ít nhất, số lượng nhiều nhất}
            do {
                alert("Email có dạng: example@example.com");
                email = prompt("Email:", email);
                if (email.match(email_format)) {
                    flg = false;
                } else {
                    alert("Email " + email + " SAI định dạng!");
                }
            } while (flg); //flg trong while đang là TRUE (theo giá trị khai báo ban đầu).
            break;
        case 5:
            alert("Đà Nẵng -20$ \nHuế -10$ \nQuảng Nam -5$");
            address = prompt("Địa chỉ:", address);
            break;
        case 6:
            alert("Diamond -15$ \nPlatium -10$ \nGold -5$ \nSilver -2$ \nMember -0$");
            type_customer = prompt("Loại Customer:", type_customer);
            break;
        case 7:
            //let flg = true;
            do {
                amount_people = parseInt(prompt("Số lượng đi kèm:", amount_people));
                if (amount_people > 0) {
                    flg = false;
                } else {
                    alert("Số người " + amount_people + " KHÔNG đúng!");
                }
            } while (flg);
            break;
        case 8:
           // let flg = true;
            do {
                alert("2->4 days -10$ \n5->7 days -20$ \nOver 7 days -30$");
                amount_days = prompt("Số ngày thuê:", amount_days);
                if (amount_days > 0) {
                    flg = false;
                } else {
                    alert("Số ngày thuê " + amount_days + " KHÔNG đúng!");
                }
            } while (flg);
            break;
        case 9:
            alert("Villa 500$ \nHouse 300$ \nRoom 100$");
            type_service = prompt("Loại dịch vụ:", type_service);
            break;
        case 10:
            alert("VIP \nBusiness \nNomal");
            type_room = prompt("Loại phòng thuê:", type_room);
            break;
        default:
            alert("Không có tùy chọn này!");
            loop_checking = 0;
            break;
    }
    // Lặp lại hàm edit_info nếu chọn switch trả về default.
    if (loop_checking === 0) {
        edit_info();
    }
    
    registration(); //hiển thị thông tin sau khi sửa
}

// hàm hiển thị thông tin
function registration() {
    document.getElementById("display").innerHTML =
        "<h2>Thông tin của bạn</h2>"
        + "Họ và tên: " + full_name + "<br>"
        + "Số CMND: " + identity_number + "<br>"
        + "Ngày sinh: " + birthday + "<br>"
        + "Email: " + email + "<br>"
        + "Địa chỉ(*): " + address + "<br>"
        + "Loại Customer(*): " + type_customer + "<br>"
        + "Số lượng đi kèm: " + amount_people + "<br>"
        + "Số ngày thuê(*): " + amount_days + "<br>"
        + "Loại dịch vụ: " + type_service + "<br>"
        + "Loại phòng thuê: " + type_room + "<br>"
}

// hàm hiển thị tổng giá
function total_pay() {
    giamGia();
    let total = 0; // biến lưu tổng tiền
    let price_type_service = 0; // giá loại dịch vụ
    if (type_service == "Villa") {
        price_type_service = 500;
    } else if (type_service == "House") {
        price_type_service = 300;
    } else if (type_service == "Room"){
        price_type_service = 100;
    }

    total = price_type_service * amount_days - discount; // Tổng tiền phải trả
    console.log(total);
    if (total < 0) {
        pay_total = 0;
    } else {
        pay_total = total;
    }

    document.getElementById("display").innerHTML =
        "<h2>Thông tin tổng số tiền</h2>"
        + "Loại Customer: " + type_customer + "<br>"
        + "Số ngày thuê: " + amount_days + "<br>"
        + "Loại dịch vụ: " + type_service + "<br>"
        + "Loại phòng thuê: " + type_room + "<br>"
        + "Giảm giá: " + discount + "$.<br>"
        + "Số tiền phải trả: " + pay_total + "$ và đã được giảm giá " + discount +"$.";
}
