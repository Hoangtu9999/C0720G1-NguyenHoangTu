function demo() {
    let inputC = prompt("Nhập độ C");

    let C = parseFloat(inputC);

    let F = (C /5 * 9) + 32 ;

    document.write(C + " Độ C = " + F + " Độ F" )
}