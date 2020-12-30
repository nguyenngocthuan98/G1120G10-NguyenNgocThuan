let flg = true;
let index;
let arrListCustomer = [];

// Show/hide menu
function displayMainMenu() {
    document.getElementById("mainMenu").style.display = "block";
    document.getElementById("mainEMenu").style.display = "none";
    document.getElementById("btnShowMenu").style.display = "none";
    document.getElementById("btnShowEMenu").style.display="none";
}
function exitMainMenu() {
    document.getElementById("mainMenu").style.display = "none";
    document.getElementById("display").style.display = "none";
    document.getElementById("btnShowMenu").style.display = "block";
    document.getElementById("btnShowEMenu").style.display="block";
}

// CRUD-Create new customer
function addNewCustomer() {
    let add_fullName,
        add_identifyNumber,
        add_dayOfBirth,
        add_email,
        add_address,
        add_typeOfCustomer,
        add_discount,
        add_includePeople,
        add_dayRents,
        add_typeService,
        add_typeRoom;
    let arrInforCustomer = [];
    let customer = new Customer();

    // add name
    add_fullName = formatString(prompt("Customer name:"));
    customer.setFullName(add_fullName);
    arrInforCustomer.push(customer.getFullName());
    // add identify
    do {
        add_identifyNumber = prompt("Identity number:\nFormat 9 digits!");
    } while (formatIdentify(add_identifyNumber) === false);
    customer.setIndentifyNumber(add_identifyNumber);
    arrInforCustomer.push(customer.getIndentifyNumber());
    // add day of birth
    do {
        add_dayOfBirth = prompt("Day of Birth:\nFormat: dd/mm/yyyy", "01/01/1990");
    } while (formatDoB(add_dayOfBirth) === false);
    customer.setDayOfBirth(add_dayOfBirth);
    arrInforCustomer.push(customer.getDayOfBirth());
    // add email
    do {
        add_email = prompt("Email:", "example@example.com");
    } while (formatEmail(add_email) === false);
    customer.setEmail(add_email);
    arrInforCustomer.push(customer.getEmail());
    // add address
    add_address = formatString(prompt("Address:\nĐà Nẵng -20$ / Huế -10$ / Quảng Nam -5$", "unknown"));
    customer.setAddress(add_address);
    arrInforCustomer.push(customer.getAddress());
    // add type of customer
    add_typeOfCustomer = formatString(prompt("Type of customer:\nDiamond -15$ / Platium -10$ / Gold -5$ / Silver -2$ / Member -0$", "unknown"));
    customer.setTypeOfCustomer(add_typeOfCustomer);
    arrInforCustomer.push(customer.getTypeOfCustomer());
    // add discount
    do {
        add_discount = prompt("Discount*:\nDiscount must be percentage value and integer value", 0);
    } while (formatNumber(add_discount) === false);
    customer.setDiscount(add_discount);
    arrInforCustomer.push(customer.getDiscount());
    // add include people
    do {
        add_includePeople = prompt("Include people:", 0);
    } while (formatNumber(add_includePeople) === false);
    customer.setIncludePeople(add_includePeople);
    arrInforCustomer.push(customer.getIncludePeople());
    // add day rent
    do {
        add_dayRents = prompt("Rent days*:\n2->4 days -10$ / 5->7 days -20$ / Over 7 days -30$", 0);
    } while (formatNumber(add_dayRents) === false);
    customer.setDayRents(add_dayRents);
    arrInforCustomer.push(customer.getDayRents());
    // add type service
    add_typeService = formatString(prompt("Type service*:\nVilla 500$ / House 300$ / Room 100$", "unknown"));
    customer.setTypeService(add_typeService);
    arrInforCustomer.push(customer.getTypeService());
    // add type room
    add_typeRoom = formatString(prompt("Type room:\nVip / Business / Nomal", "unknown"));
    customer.setTypeRoom(add_typeRoom);
    arrInforCustomer.push(customer.getTypeRoom());
    // add room charge
    arrInforCustomer.push(customer.roomCharge());
    // show alert add success
    alert("Add new customer successfully!");
    // add values to arrListCustomer
    arrListCustomer[arrListCustomer.length] = arrInforCustomer;
}

// CRUD-Read customer - show detail customer by indentify number
function displayInfo() {
    function showOneCus(i) {
        let render
            = "<b>Full name: </b>" + arrListCustomer[i][0] + "<br/>"
            + "<b>Indentify number: </b>" + arrListCustomer[i][1] + "<br/>"
            + "<b>Day of birth: </b>" + arrListCustomer[i][2] + "<br/>"
            + "<b>Email: </b>" + arrListCustomer[i][3] + "<br/>"
            + "<b>Address: </b>" + arrListCustomer[i][4] + "<br/>"
            + "<b>Type of customer: </b>" + arrListCustomer[i][5] + "<br/>"
            + "<b>Discount: </b>" + arrListCustomer[i][6] + " %<br/>"
            + "<b>Include people: </b>" + arrListCustomer[i][7] + "<br/>"
            + "<b>Rent days: </b>" + arrListCustomer[i][8] + "<br/>"
            + "<b>Type service: </b>" + arrListCustomer[i][9] + "<br/>"
            + "<b>Type room: </b>" + arrListCustomer[i][10] + "<br/>";
        return render;
    }

    findIdentify();
    document.getElementById("display").style.display = "block";
    document.getElementById("display").innerHTML = "";
    document.getElementById("display").innerHTML +=
        "<fieldset><legend><h3>" + arrListCustomer[index][0] + "'s detail</h3></legend>" + showOneCus(index) + "</fieldset>";
}

// Show list customer non-detail (fullName and identify)
function displayDetail() {
    document.getElementById("btn_find").style.display = "block";
    document.getElementById("display").style.display = "block";
    document.getElementById("display").innerHTML = "";
    function showOneCusInList(i) {
        let render
            = "<b>Full name: </b>" + arrListCustomer[i][0] + "<br/>"
            + "<b>Indentify number: </b>" + arrListCustomer[i][1] + "<br/>"
        return render;
    }
    for (let i = 0; i < arrListCustomer.length; i++) {
        document.getElementById("display").innerHTML +=
            "<fieldset><legend><h3>" + arrListCustomer[i][0] + "'s detail</h3></legend>" + showOneCusInList(i) + "</fieldset>";
    }
}

// Read detail customer - show detail + total pay of customer by indentify number
function showPay() {
    function showOneCusPay(i) {
        let render
            = "<b>Full name: </b>" + arrListCustomer[i][0] + "<br/>"
            + "<b>Indentify number: </b>" + arrListCustomer[i][1] + "<br/>"
            + "<b>Address: </b>" + arrListCustomer[i][4] + "<br/>"
            + "<b>Type of customer: </b>" + arrListCustomer[i][5] + "<br/>"
            + "<b>Discount: </b>" + arrListCustomer[i][6] + " %<br/>"
            + "<b>Rent days: </b>" + arrListCustomer[i][8] + "<br/>"
            + "<b>Type service: </b>" + arrListCustomer[i][9] + "<br/>"
            + "<b>Total pay: " + arrListCustomer[i][11] + " $</b><br/>";
        return render;
    }
    findIdentify();
    document.getElementById("display").style.display = "block";
    document.getElementById("display").innerHTML = "";
    document.getElementById("display").innerHTML +=
        "<fieldset><legend><h3>" + arrListCustomer[index][0] + "'s detail</h3></legend>" + showOneCusPay(index) + "</fieldset>";
}

// CRUD-Update customer
function editCustomer() {
    let edit_fullName,
        edit_identifyNumber,
        edit_dayOfBirth,
        edit_email,
        edit_address,
        edit_typeOfCustomer,
        edit_discount,
        edit_includePeople,
        edit_dayRents,
        edit_typeService,
        edit_typeRoom;
    let flg_exit = true;
    let choose;

    findIdentify();
    do {
        choose = parseInt(prompt(
            "1. Full name: " + arrListCustomer[index][0] + "\n"
            + "2. Indentify number: " + arrListCustomer[index][1] + "\n"
            + "3. Day of birth: " + arrListCustomer[index][2] + "\n"
            + "4. Email: " + arrListCustomer[index][3] + "\n"
            + "5. Address: " + arrListCustomer[index][4] + "\n"
            + "6. Type of customer: " + arrListCustomer[index][5] + "\n"
            + "7. Discount: " + arrListCustomer[index][6] + "\n"
            + "8. Include people: " + arrListCustomer[index][7] + "\n"
            + "9. Rent days: " + arrListCustomer[index][8] + "\n"
            + "10. Type service: " + arrListCustomer[index][9] + "\n"
            + "11. Type service: " + arrListCustomer[index][10] + "\n"
            + "12. Exit editer."
        ));

        switch (choose) {
            case 1:
                edit_fullName = prompt("Customer name:", arrListCustomer[index][0]);
                arrListCustomer[index][0] = formatString(edit_fullName);
                break;
            case 2:
                do {
                    edit_identifyNumber = prompt("Identity number:\nFormat 9 digits!", arrListCustomer[index][1]);
                } while (formatIdentify(edit_identifyNumber) === false);
                arrListCustomer[index][1] = edit_identifyNumber;
                break;
            case 3:
                do {
                    edit_dayOfBirth = prompt("Day of Birth:\nFormat: dd/mm/yyyy", arrListCustomer[index][2]);
                } while (formatDoB(edit_dayOfBirth) === false);
                arrListCustomer[index][2] = edit_dayOfBirth;
                break;
            case 4:
                do {
                    edit_email = prompt("Email:", arrListCustomer[index][3]);
                } while (formatEmail(edit_email) === false);
                arrListCustomer[index][3] = edit_email;
                break;
            case 5:
                edit_address = prompt("Address:\nĐà Nẵng -20$ / Huế -10$ / Quảng Nam -5$", arrListCustomer[index][4]);
                arrListCustomer[index][4] = formatString(edit_address);
                break;
            case 6:
                edit_typeOfCustomer = prompt("Type of customer:\nDiamond -15$ / Platium -10$ / Gold -5$ / Silver -2$ / Member -0$", arrListCustomer[index][5]);
                arrListCustomer[index][5] = formatString(edit_typeOfCustomer);
                break;
            case 7:
                do{
                    edit_discount = prompt("Discount*:\nDiscount must be percentage value and integer value", arrListCustomer[index][6]);
                } while (formatNumber(edit_discount) === false);
                arrListCustomer[index][6] = edit_discount;
                break;
            case 8:
                do{
                    edit_includePeople = prompt("Include people:", arrListCustomer[index][7]);
                } while (formatNumber(edit_includePeople) === false);
                arrListCustomer[index][7] = edit_includePeople;
                break;
            case 9:
                do{
                    edit_dayRents = prompt("Rent days*:\n2->4 days -10$ / 5->7 days -20$ / Over 7 days -30$", arrListCustomer[index][8]);
                } while (formatNumber(edit_dayRents) === false);
                arrListCustomer[index][8] = edit_dayRents;
                break;
            case 10:
                edit_typeService = prompt("Type service*:\nVilla 500$ / House 300$ / Room 100$", arrListCustomer[index][9]);
                arrListCustomer[index][9] = formatString(edit_typeService);
                break;
            case 11:
                edit_typeRoom = prompt("Type room:\nVip / Business / Nomal", arrListCustomer[index][10]);
                arrListCustomer[index][9] = formatString(edit_typeRoom);
            break;
            case 12:
                flg = false;
                break;
            default:
                alert("This choice does not exist, choose again!")
                break;
        } return flg; 
    } while (flg_exit);
}

// CRUD-Delete customer
function delCustomer() {
    findIdentify();
    if (flg === false) {
        arrListCustomer.splice(index,1);
        alert("Deleted!"); 
    }
    flg = true;
    displayDetail();
}

// find indentify number
function findIdentify() {
    let identityNum = prompt("Enter customer's identify:");
    for (let i = 0; i < arrListCustomer.length; i++) {
        for (let j = 0; j < arrListCustomer[i].length; j++) {
            if (identityNum === arrListCustomer[i][1]) {
                index = i;
                flg = false;
                return index;
            }
        }
    }
    if (flg === true) {
        alert(identityNum + " NOT exist!");
    }
}
