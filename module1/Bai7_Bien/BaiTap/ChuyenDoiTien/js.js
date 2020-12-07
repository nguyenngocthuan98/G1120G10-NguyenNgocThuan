let dc_nhap = document.getElementById("nhap");
let dc_from = document.getElementById("from");
let dc_to = document.getElementById("to");
let result;
let type;

function convert() {
    nhap = parseInt(dc_nhap.value);
    from = dc_from.value;
    to = dc_to.value;

    if (from == "usd" && to == "vnd") {
        result = nhap * 23200;
        type = "VND";
    } else if (from === "vnd" && to === "usd") {
        result = nhap / 23200;
        type = "USD";
    } else {
        result = nhap;
    }
    document.getElementById("result").innerText = "Result: " + result.toFixed(2) +" "+ type;
}