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

function addNewCustomer() {
    let arrInfoCustomer = [];

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
        //console.log("price_type_service: " + typeof price_type_service + price_type_service);
        //console.log("amount_days: "+typeof amount_days + amount_days);
        //console.log("pay: "+typeof pay + pay);
        return pay;
    }

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
    //console.log("pay_total: "+ typeof pay_total + pay_total)
    arrInfoCustomer.push( pay_total);

    alert("Thêm thành công");
    arrListCustomer[arrListCustomer.length] = arrInfoCustomer;
    //console.log(arrInfoCustomer);
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
    console.log(arrListCustomer[index]);
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
            arrListCustomer[index][choose-1] = new_full_name;
            break;
        case 2:
            new_identity_number = prompt("Số CMND:", arrListCustomer[index][1]);
            arrListCustomer[index][choose] = identity_number;
            console.log(arrListCustomer[index][choose]);
            break;
        case 3:
            birthday = prompt("Ngày sinh:", birthday);
            break;
        case 4:
            email = prompt("Email:", email);
            break;
        case 5:
            address = prompt("Địa chỉ:\nĐà Nẵng -20$ / Huế -10% / Quảng Nam -5$", address);
            break;
        case 6:
            type_customer = prompt("Loại customer:\nDiamond -15$ / Platium -10$ / Gold -5$ / Silver -2$ / Member -0$", type_customer);
            break;
        case 7:
            amount_people = prompt("Số lượng đi kèm:", amount_people);
            break;
        case 8:
            amount_days = prompt("Số ngày thuê :\n2->4 days -10$ / 5->7 days -20$ / Over 7 days -30$", amount_days);
            break;
        case 9:
            type_service = prompt("Loại dịch vụ :\nVilla 500$ / House 300$ / Room 100$", type_service);
            break;
        case 10:
            type_room = prompt("Loại phòng thuê :\nVIP / Business / Nomal", type_room);
            break;
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
        + "<b>Số ngày thuê: </b>" + arrListCustomer[i][7] + ". "
        + "<b>Loại dịch vụ: </b>" + arrListCustomer[i][8] + ". "
        + "<b>Loại phòng thuê: </b>" + arrListCustomer[i][9] + "<br /> "
        + "<b>Số tiền phải trả: </b>" + arrListCustomer[i][10] + "$."
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
