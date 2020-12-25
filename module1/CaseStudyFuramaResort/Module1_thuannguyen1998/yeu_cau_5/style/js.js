let full_name;
let identity_number;
let birthday;
let email;
let address;
let type_customer;
let discount;
let amount_people;
let amount_days;
let type_service;
let type_room;
let price_type_service;
let pay_total = 0;
let index;
let arrListCustomer = [];
let flg = true;

function displayMainMenu() {
    document.getElementById("mainMenu").style.display = "block";
    document.getElementById("btnShowMenu").style.display="none";
}

function exitMainMenu() {
    document.getElementById("mainMenu").style.display = "none";
    document.getElementById("display").style.display = "none";
    document.getElementById("btnShowMenu").style.display="block";
}

function tinh() {
    switch (type_service) {
        case "Villa":
            price_type_service = 500;
            break;
        case "House":
            price_type_service = 300;
        break;
        case "Room":
            price_type_service = 100;
        break;
        default:
            price_type_service = 0;
            break;
    }
    let pay = price_type_service * amount_days * (1 - (25 / 100));
    return pay;
}

function addNewCustomer() {
    let arrInfoCustomer = [];

    full_name = prompt("Họ và tên:");
    arrInfoCustomer.push(full_name);

    identity_number = prompt("Số CMND:");
    arrInfoCustomer.push(identity_number);

    birthday = prompt("Ngày sinh:");
    arrInfoCustomer.push(birthday);

    email = prompt("Email :");
    arrInfoCustomer.push(email);

    address = prompt("Địa chỉ:\nĐà Nẵng -20$ / Huế -10% / Quảng Nam -5$");
    arrInfoCustomer.push(address);

    type_customer = prompt("Loại customer:\nDiamond -15$ / Platium -10$ / Gold -5$ / Silver -2$ / Member -0$");
    arrInfoCustomer.push(type_customer);

    amount_people = prompt("Số lượng đi kèm:");
    arrInfoCustomer.push(amount_people);

    amount_days = prompt("Số ngày thuê :\n2->4 days -10$ / 5->7 days -20$ / Over 7 days -30$");
    arrInfoCustomer.push(amount_days);

    type_service = prompt("Loại dịch vụ :\nVilla 500$ / House 300$ / Room 100$");
    arrInfoCustomer.push(type_service);

    type_room = prompt("Loại phòng thuê :\nVIP / Business / Nomal");
    arrInfoCustomer.push(type_room);

    pay_total = tinh();
    arrInfoCustomer.push(pay_total);

    alert("Thêm thành công");
    arrListCustomer[arrListCustomer.length] = arrInfoCustomer;
    displayMainMenu();
}

function editCustomer() {
    let identityNum = prompt("Nhập số CMND của customer:");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (identityNum === arrListCustomer[i][j]) {
                index = i;
            }
        }
    }
    //console.log(arrListCustomer[index]);
    let choose;
    
    choose = parseInt(prompt(
        "1. Họ và tên: " + arrListCustomer[index][0] + "\n"
        + "2. Số CMND: " + arrListCustomer[index][1] + "\n"
        + "3. Ngày sinh: " + arrListCustomer[index][2] + "\n"
        + "4. Email: " + arrListCustomer[index][3] + "\n"
        + "5. Địa chỉ: " + arrListCustomer[index][4] + "\n"
        + "6. Loại Customer: " + arrListCustomer[index][5] + "\n"
        + "7. Số lượng đi kèm: " + arrListCustomer[index][6] + "\n"
        + "8. Số ngày thuê: " + arrListCustomer[index][7] + "\n"
        + "9. Loại dịch vụ: " + arrListCustomer[index][8] + "\n"
        + "10. Loại phòng thuê: " + arrListCustomer[index][9] + "\n"
    ));

    switch (choose) {
        case 1:
            new_full_name = prompt("Họ và tên:", arrListCustomer[index][0]);
            arrListCustomer[index][0] = new_full_name;
            break;
        case 2:
            new_identity_number = prompt("Số CMND:", arrListCustomer[index][1]);
            arrListCustomer[index][1] = new_identity_number;
            break;
        case 3:
            new_birthday = prompt("Ngày sinh:", arrListCustomer[index][2]);
            arrListCustomer[index][2] = new_birthday;
            break;
        case 4:
            new_email = prompt("Email:", arrListCustomer[index][3]);
            arrListCustomer[index][3] = new_email;
            break;
        case 5:
            new_address = prompt("Địa chỉ:\nĐà Nẵng -20$ / Huế -10% / Quảng Nam -5$", arrListCustomer[index][4]);
            arrListCustomer[index][4] = new_address;
            break;
        case 6:
            new_type_customer = prompt("Loại customer:\nDiamond -15$ / Platium -10$ / Gold -5$ / Silver -2$ / Member -0$", arrListCustomer[index][5]);
            arrListCustomer[index][5] = new_type_customer;
            break;
        case 7:
            new_amount_people = prompt("Số lượng đi kèm:", arrListCustomer[index][6]);
            arrListCustomer[index][6] = new_amount_people;
            break;
        case 8:
            new_amount_days = prompt("Số ngày thuê :\n2->4 days -10$ / 5->7 days -20$ / Over 7 days -30$", arrListCustomer[index][7]);
            arrListCustomer[index][7] = new_amount_days;
            break;
        case 9:
            new_type_service = prompt("Loại dịch vụ :\nVilla 500$ / House 300$ / Room 100$", arrListCustomer[index][8]);
            arrListCustomer[index][8] = new_type_service;
            break;
        case 10:
            new_type_room = prompt("Loại phòng thuê :\nVIP / Business / Nomal", arrListCustomer[index][9]);
            arrListCustomer[index][9] = new_type_room;
            break;
    }
    //tính lại tiền sau khi sửa
    if (choose === 7 || choose === 8) {
        type_service = arrListCustomer[index][8];
        amount_days = arrListCustomer[index][7];
        new_pay_total = tinh();
        arrListCustomer[index][10]= new_pay_total;
    }
    displayInfo();
}

function delCustomer() {
    let identityNum = prompt("Nhập số CMND của customer:");

    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (identityNum === arrListCustomer[i][j]) {
                index = i;
            }
        }
    }
    arrListCustomer.splice(index,1);
    alert("Deleted!");

    displayInfo();
}

function showOneCus(i) {
    let render =
        "<b>Họ và tên: </b>" + arrListCustomer[i][0] + ". "
        + "<b>Số CMND: </b>" + arrListCustomer[i][1] + ". "
        + "<b>Ngày sinh: </b>" + arrListCustomer[i][2] + ". "
        + "<b>Email: </b>" + arrListCustomer[i][3] + ". "
        + "<b>Địa chỉ: </b>" + arrListCustomer[i][4] + ". "
        + "<b>Loại Customer: </b>" + arrListCustomer[i][5] + ". "
        + "<b>Số lượng đi kèm: </b>" + arrListCustomer[i][6] + ". "
        + "<b>Số ngày thuê* : </b>" + arrListCustomer[i][7] + ". "
        + "<b>Loại dịch vụ* : </b>" + arrListCustomer[i][8] + ". "
        + "<b>Loại phòng thuê: </b>" + arrListCustomer[i][9] + "<br /> "
        + "<b>Số tiền phải trả: </b>" + arrListCustomer[i][10] + "$ <i>Bạn đã được giảm 25% tổng giá tiền</i>"
        ;
    return render;
}

function displayInfo() {
    document.getElementById("display").style.display = "block";
    document.getElementById("display").innerHTML = "";
    for (let i = 0; i < arrListCustomer.length; i++) {
        document.getElementById("display").innerHTML +=
            "<fieldset><legend><h3>Thông tin của " + arrListCustomer[i][0] + "</h3></legend>" + showOneCus(i) + "</fieldset>";
    }
}
