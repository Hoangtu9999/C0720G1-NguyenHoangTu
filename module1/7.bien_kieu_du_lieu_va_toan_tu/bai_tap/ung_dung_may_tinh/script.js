function adition() {
    let inputValue1 = document.getElementById("value1").value;
    let inputValue2 = document.getElementById("value2").value;

    let value1 = parseFloat(inputValue1);
    let value2 = parseFloat(inputValue2);

    let result = value1 + value2;


    document.getElementById("result").innerHTML  = "Result adition:" + result;
}
function subtraction() {
    let inputValue1 = document.getElementById("value1").value;
    let inputValue2 = document.getElementById("value2").value;

    let value1 = parseFloat(inputValue1);
    let value2 = parseFloat(inputValue2);

    let result = value1 - value2;


    document.getElementById("result").innerHTML  = "Result subtraction:" + result;
}
function multiplication() {
    let inputValue1 = document.getElementById("value1").value;
    let inputValue2 = document.getElementById("value2").value;

    let value1 = parseFloat(inputValue1);
    let value2 = parseFloat(inputValue2);

    let result = value1 * value2;


    document.getElementById("result").innerHTML  = "Result multiplication:" + result;
}
function division() {
    let inputValue1 = document.getElementById("value1").value;
    let inputValue2 = document.getElementById("value2").value;

    let value1 = parseFloat(inputValue1);
    let value2 = parseFloat(inputValue2);

    let result = value1 / value2;


    document.getElementById("result").innerHTML  = "Result division:" + result;
}

