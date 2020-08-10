function demo() {
    let inputVatLy = prompt("Nhập điểm vật lý");
    let inputHoaHoc = prompt("Nhập điểm hóa ");
    let inputSinhHoc = prompt("Nhập điểm sinh");

    let vatLy = parseFloat(inputVatLy);
    let hoaHoc = parseFloat(inputHoaHoc);
    let sinhHoc = parseFloat(inputSinhHoc);

    let dtb = (vatLy + hoaHoc + sinhHoc) /3;

    document.write("Điểm trung bình:" + dtb);
}