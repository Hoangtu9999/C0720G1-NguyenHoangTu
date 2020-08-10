function convert() {
    let amout = document.getElementById("amout").value;
    let fromCurrency = document.getElementById("fromCurrency").value;
    let toCurrency = document.getElementById("toCurrency").value;

    amout = parseInt(amout);

    let result = 0;
    if(fromCurrency == "USA" && toCurrency == "VNĐ")
        result = amout * 23000;
    else if (fromCurrency == "VNĐ" && toCurrency == "USA")
        result = amout / 23000;
     else
        result = "Bạn chọn lại đơn vị cân đối";


    document.getElementById("shows").innerHTML = "Kết quả:" + result;

}