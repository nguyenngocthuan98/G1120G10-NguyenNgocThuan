let number;
let arrNameCustomers = []; 
let name_del;
let flg = true;

function addName() {
    do {
        input_number = prompt("Enter number of customers:");
        if (!isNaN(input_number)) {
            flg = false;
        } else {
            alert(input_number + " not a number.");
            console.log(flg);
        }
    } while (flg);
    number = parseInt(input_number);
    console.log(number);
    arrNameCustomers = Array(number);
    for (let i = 0; i < arrNameCustomers.length; i++) {
        arrNameCustomers[i] = prompt("Enter name customer:");
    }
    showList();
}

function delName() {
    name_del = prompt("Enter name to delete: ");
    for (let i = 0; i < arrNameCustomers.length; i++) {
        if (arrNameCustomers[i] === name_del) {
            arrNameCustomers.splice(i,1);
        }
    }
    alert("Deleted customer: " + name_del);
    showList();
}

function showList() {
    document.getElementById("display").innerHTML +=
        "<h2>List Customers</h2>" + arrNameCustomers.sort().join("<br/>");
}