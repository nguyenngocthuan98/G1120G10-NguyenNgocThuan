function confirm() {
    let full_name = document.getElementById("full_name").value;
    let identity_number = document.getElementById("identity_number").value;
    let birthday = document.getElementById("birthday").value;
    let email = document.getElementById("email").value;
    let address = document.getElementById("address").value;
    let type_customer = document.getElementById("type_customer").value;
    let discount = parseFloat(document.getElementById("discount").value);
    let amount_people = parseInt(document.getElementById("amount_people").value);
    let amount_days = parseInt(document.getElementById("amount_days").value);
    let type_service = document.getElementById("type_service").value;
    let type_room = document.getElementById("type_room").value;
    let price_type_service;
    let pay = 0;

    if (type_service == "villa") {
        price_type_service = 500;
    } else if (type_service == "house") {
        price_type_service = 300;
    } else {
        price_type_service = 100;
    }
    pay = price_type_service * amount_days * (1 - (discount / 100));

    document.getElementById("dp-full_name").innerHTML = full_name;
    document.getElementById("dp-identity_number").innerText = identity_number;
    document.getElementById("dp-birthday").innerText = birthday;
    document.getElementById("dp-email").innerText = email;
    document.getElementById("dp-address").innerText = address;
    document.getElementById("dp-type_customer").innerText = type_customer;
    document.getElementById("dp-discount").innerText = discount;
    document.getElementById("dp-amount_people").innerText = amount_people;
    document.getElementById("dp-amount_days").innerText = amount_days;
    document.getElementById("dp-type_service").innerText = type_service;
    document.getElementById("dp-type_room").innerText = type_room;
    document.getElementById("dp-pay").innerText = pay + "$";
}
