// string format
function formatString(inputString) {
    let arr_a = [];
    let arr_b = [];
    let stringTrimLow = inputString.trim().toLowerCase();

    for (let i = 0; i < stringTrimLow.length; i++) {
        arr_b[i] = stringTrimLow[i];
    }

    for (let i = 0; i < arr_b.length; i++) {
        if ((arr_b[i] === " ") && (arr_b[i+1] === " ")) {
            arr_b.splice((i),1);
            i--;
        }
        arr_a[i] = arr_b[i];
    }

    for (let i = 0; i < arr_a.length; i++) {
        arr_a[0] = arr_a[0].toUpperCase();
        if (arr_a[i] === " ") {
            arr_a[i+1] = arr_a[i+1].toUpperCase();
        }
    }
    return arr_a.join("");
}

// identify format
function formatIdentify(inputId) {
    let count = 0;
    let flg = true;
    let number = ["1","2","3","4","5","6","7","8","9","0"];

    if (inputId.length !== 9) {
        flg = false;
    } else {
        for (let i = 0; i < inputId.length; i++) {
            for (let j = 0; j < number.length; j++) {
                if (inputId[i] === number[j]) {
                    count++;
                }
            }
        }
        if (count !== 9) {
            flg = false;
        }
    }

    return flg;
}

// dd of birth format
function formatDoB(inputDoB) {
    let flg = true;
// the first way
    let getThisDate = new Date(); // display todays date
    let getYear = getThisDate.getFullYear(); //display the full year of todays date    
    if (inputDoB.length !== 10) {
        flg = false;
    } else {
        let dd = parseInt(inputDoB.slice(0,1));
        let mm = parseInt(inputDoB.slice(3,4));
        let yyyy = parseInt(inputDoB.slice(6, 10));
        
        if (inputDoB[2] !== "/" || (inputDoB[5] !== "/")) {
            flg = false;
        }

        if (dd <= 0 || dd > 31 || mm <= 0 || mm > 12 || yyyy <= 1900 || yyyy > getYear) {
            flg = false;
        } else if (((mm === 4) || (mm === 6) || (mm === 9) || (mm === 11)) && (dd > 30)) {
            flg = false;
        } else if ((mm === 2) && (dd > 29)) {
            flg = false;
        }
        
        if ((mm * 0 !== 0) &&  (dd * 0 !== 0) && (yyyy * 0 !== 0)) {
            flg = false;
        }
    }
// end The first way
// The second way
    // let date_regex = /^(0[1-9]|1\d|2\d|3[01])\/(0[1-9]|1[0-2])\/(19|20)\d{2}$/;
    // if(inputDoB.match(date_regex) === false){
    //     flg = false;
    // }
// end The second way

    return flg;
}

// format email
function formatEmail(inputEmail) {
    let email_format = /^\w+@[a-zA-Z]{3,}.[a-z]{2,}$/;
    if (inputEmail.match(email_format)) {
        flg = true;
    } else {
        flg = false;
    }

    return flg;
}

// format number
function formatNumber(inputNumber) {
    let count = 0;
    let flg = true;
    let number = ["1","2","3","4","5","6","7","8","9","0"];

    for (let i = 0; i < inputNumber.length; i++) {
        for (let j = 0; j < number.length; j++) {
            if (inputNumber[i] === number[j]) {
                count++;
            }
        }
    }
    if (count !== inputNumber.length) {
        flg = false;
    }
    
    return flg;
}
