package controllers;


import commons.*;
import models.*;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainController {
    static String id;
    static String serviceName;
    static String areaOfUse;
    static int rentalCosts;
    static int numberOfPeopleMax;
    static String rentType;
    static int chooseTheCustomer;
    public static Scanner scanner = new Scanner(System.in);
    public static ArrayList<Services> listService = new ArrayList();
    public static ArrayList<Villa> listVilla = new ArrayList();
    public static ArrayList<House> listHouse = new ArrayList();
    public static ArrayList<Room> listRoom = new ArrayList();
    public static ArrayList<Customer> listCustomer = new ArrayList();

    public static final String FILE_NAME_VILLA = "src/data/Villa.csv";
    public static final String FILE_NAME_HOUSE = "src/data/House.csv";
    public static final String FILE_NAME_ROOM = "src/data/Room.csv";
    public static final String FILE_NAME_CUSTOMER = "src/data/Customer.csv";
    public static final String FILE_NAME_BOOKING = "src/data/Booking.csv";
    public static final String COMMA = ",";


    public static void main(String[] args) {
        displayMenu();
    }

    /**
     * SERVICE
     **/
    public static boolean checkInputServiceName(String serviceName) {
        String regex = ("[A-Z][a-z]*");  //("^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$");
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serviceName);
        return matcher.find();
    }

    public static boolean checkInputAreaOfUse(String areaOfUse) {
        String regex = "^([3][0]+.\\d+)|([3][1-9]+.?\\d*)|([4-9]\\d+.?\\d*)|(\\d{3,}.?\\d*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(areaOfUse);
        return matcher.find();
    }

    public static void inputService() {
        do {
            System.out.print("Nhập tên dịch vụ:");
            serviceName = scanner.nextLine();
        } while (!checkInputServiceName(serviceName));
        do {
            System.out.print("Nhập diện tích sử dụng :");
            areaOfUse = scanner.nextLine();
        } while (!checkInputAreaOfUse(areaOfUse));

        do {
            System.out.print("Nhập chi phí thuê:");
            rentalCosts = Integer.parseInt(scanner.nextLine());
        } while (rentalCosts < 0);
        do {
            System.out.print("Nhập số lượng người tối đa:");
            numberOfPeopleMax = Integer.parseInt(scanner.nextLine());
        } while (numberOfPeopleMax < 0 || numberOfPeopleMax > 20);
        do {
            System.out.print("Kiểu thuê:");
            rentType = scanner.nextLine();
        } while (!checkInputServiceName(rentType));

    }

    public static void showServices() {
        System.out.println("------------------------\n" +
                "1.\tShow all Villa\n" +
                "2.\tShow all House\n" +
                "3.\tShow all Room\n" +
                "4.\tShow All Name Villa Not Duplicate\n" +
                "5.\tShow All Name House Not Duplicate\n" +
                "6.\tShow All Name Name Not Duplicate\n" +
                "7.\tBack to menu\n" +
                "---------------------------"
        );
        System.out.print("Nhập chọn menu:");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        switch (inputNumber) {
            case 1:
                showAllVilla();
                showServices();
                break;
            case 2:
                showAllHouse();
                showServices();
                break;
            case 3:
                showAllRoom();
                showServices();
                break;
            case 4:

        }
    }
    /**END SERVICE**/
    /**
     * VILLA
     **/
    public static boolean checkInputVilla(String id) {
        String regex = "(SVVL)-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.find();
    }

    public static void addNewVilla() {
        do {
            System.out.print("Nhập id:");
            id = scanner.nextLine();
        } while (!checkInputVilla(id));
        inputService();
        String standardRoom;
        do {
            System.out.print("Nhập tiêu chuẩn phòng:");
            standardRoom = scanner.nextLine();
        } while (!checkInputServiceName(standardRoom));

        System.out.print("Nhập mô tả tiện nghi:");
        String comfortDescription = scanner.nextLine();
        System.out.print("Nhập diện tích hồ bơi:");
        double poolArea = Integer.parseInt(scanner.nextLine());
        int numberOfFloors;
        do {
            System.out.print("Nhập số tầng:");
            numberOfFloors = Integer.parseInt(scanner.nextLine());
        } while (numberOfFloors < 0);

        Villa villa = new Villa(id, serviceName, Double.parseDouble(areaOfUse), rentalCosts, numberOfPeopleMax, rentType, standardRoom, comfortDescription, poolArea, numberOfFloors);
        listVilla.add(villa);
        listService.add(villa);

        String line = null;
        line = villa.getId()
                + COMMA + villa.getServiceName()
                + COMMA + villa.getAreaOfUse()
                + COMMA + villa.getRentalCosts()
                + COMMA + villa.getNumberOfPeopleMax()
                + COMMA + villa.getRentType()
                + COMMA + villa.getStandardRoom()
                + COMMA + villa.getComfortDescription()
                + COMMA + villa.getPoolArea()
                + COMMA + villa.getNumberOfFloors();
        FileUtils.writeFile(FILE_NAME_VILLA, line);

    }

    public static void showAllVilla() {
        List<String> listLine = FileUtils.readFile(FILE_NAME_VILLA);
        int index = 1;
        for (String string : listLine) {
            String[] listSplit = string.split(",");
            Villa villa = new Villa(listSplit[0], listSplit[1], Double.parseDouble(listSplit[2]),
                    Integer.parseInt(listSplit[3]), Integer.parseInt(listSplit[4]), listSplit[5],
                    listSplit[6], listSplit[7], Double.parseDouble(listSplit[8]), Integer.parseInt(listSplit[9]));
            listVilla.add(villa);
            System.out.println(index++ + "\n" + villa);
        }
    }
    /**
     * END VILLA
     * **/

    /**
     * HOUSE
     **/
    public static boolean checkInputHouse(String id) {
        String regex = "(SVHO)-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.find();
    }

    public static void addNewHouse() {
        do {
            System.out.print("Nhập id:");
            id = scanner.nextLine();
        } while (!checkInputHouse(id));
        inputService();
        String standardRoom;
        do {
            System.out.print("Nhập tiêu chuẩn phòng:");
            standardRoom = scanner.nextLine();
        } while (!checkInputServiceName(standardRoom));
        System.out.print("Nhập mô tả tiện nghi:");
        String comfortDescription = scanner.nextLine();
        int numberOfFloors;
        do {
            System.out.print("Nhập số tầng:");
            numberOfFloors = Integer.parseInt(scanner.nextLine());
        } while (numberOfFloors < 0);


        House house = new House(id, serviceName, Double.parseDouble(areaOfUse), rentalCosts, numberOfPeopleMax, rentType, standardRoom, comfortDescription, numberOfFloors);
        listHouse.add(house);
        listService.add(house);

        String line = null;
        line = house.getId()
                + COMMA + house.getServiceName()
                + COMMA + house.getAreaOfUse()
                + COMMA + house.getRentalCosts()
                + COMMA + house.getNumberOfPeopleMax()
                + COMMA + house.getRentType()
                + COMMA + house.getStandardRoom()
                + COMMA + house.getComfortDescription()
                + COMMA + house.getNumberOfFloors();
        FileUtils.writeFile(FILE_NAME_HOUSE, line);
    }


    public static void showAllHouse() {
        List<String> listLine = FileUtils.readFile(FILE_NAME_HOUSE);
        int index = 1;
        for (String string : listLine) {
            String[] listSlit = string.split(",");
            House house = new House(listSlit[0], listSlit[1], Double.parseDouble(listSlit[2]), Integer.parseInt(listSlit[3]),
                    Integer.parseInt(listSlit[4]), listSlit[5], listSlit[6], listSlit[7], Integer.parseInt(listSlit[8]));
            listHouse.add(house);
            System.out.println(index++ + "\n" + house);
        }
    }
    /**
     * END HOUSE
     * **/

    /**
     * ROOM
     **/
    public static boolean checkInputFreeServiceIncluded(String freeServiceIncluded) {
        String regex = "(massage|karaoke|food|drink|car)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(freeServiceIncluded);
        return matcher.find();
    }

    public static boolean checkInputRoom(String id) {
        String regex = "(SVRO)-\\d{4}";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.find();
    }

    public static void addNewRoom() {
        do {
            System.out.print("Nhập id:");
            id = scanner.nextLine();
        } while (!checkInputRoom(id));
        inputService();
        String freeServiceIncluded;
        do {
            System.out.print("Nhập dịch vụ miễn phí đi kèm:");
            freeServiceIncluded = scanner.nextLine();
        } while (!checkInputFreeServiceIncluded(freeServiceIncluded));

        System.out.print("Nhập tên dịch vụ đi kèm:");
        String nameAccompanied = scanner.nextLine();
        System.out.print("Nhập đơn vị:");
        String unit = scanner.nextLine();
        System.out.print("Nhập giá tiền:");
        int priceAccompanied = Integer.parseInt(scanner.nextLine());

        Room room = new Room(id, serviceName, Double.parseDouble(areaOfUse), rentalCosts, numberOfPeopleMax, rentType, freeServiceIncluded, new AccompaniedService(nameAccompanied, unit, priceAccompanied));
        listRoom.add(room);
        listService.add(room);

        String line = null;
        line = room.getId()
                + COMMA + room.getServiceName()
                + COMMA + room.getAreaOfUse()
                + COMMA + room.getRentalCosts()
                + COMMA + room.getNumberOfPeopleMax()
                + COMMA + room.getRentType()
                + COMMA + room.getFreeServiceIncluded()
                + COMMA + room.getAccompaniedService().getNameAccompanied()
                + COMMA + room.getAccompaniedService().getUnit()
                + COMMA + room.getAccompaniedService().getPriceAccompanied();
        FileUtils.writeFile(FILE_NAME_ROOM, line);
    }


    public static void showAllRoom() {
        List<String> listLine = FileUtils.readFile(FILE_NAME_ROOM);
        int index = 1;
        for (String string : listLine) {
            String[] listSplit = string.split(",");
            Room room = new Room(listSplit[0], listSplit[1], Double.parseDouble(listSplit[2])
                    , Integer.parseInt(listSplit[3]), Integer.parseInt(listSplit[4]),
                    listSplit[5], listSplit[6], new AccompaniedService(listSplit[7], listSplit[8], Integer.parseInt(listSplit[9])));
            listRoom.add(room);
            System.out.println(index++ + "\n" + room);
        }
    }

    /**
     * END ROOM
     **/


    public static void displayMenu() {
        System.out.println("---------------------------" + "\n"
                + "1.Add New Services" + "\n"
                + "2.Show Services" + "\n"
                + "3.Add New Customer" + "\n"
                + "4.Show Information of Customer" + "\n"
                + "5.Add New Booking" + "\n"
                + "6.Show Information of Employee" + "\n"
                + "7.Exit" + "\n"
                + "---------------------------");
        System.out.print("Vui lòng chọn:");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                menuAdd();
                displayMenu();
                break;
            case 2:
                showServices();
                displayMenu();
                break;
            case 3:
                addCutomer();
                displayMenu();
                break;
            case 4:
                showInformationCustomers();
                displayMenu();
                break;
            case 5:

                AddNewBooking();
                displayMenu();
                break;
        }
    }

    /**
     * CUSTOMER
     **/
    public static void checkNameCus(String name) throws NameException {
        String regex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
    }

    public static void checkEmailCus(String email) throws EmailException {
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) throw new EmailException("Email phải đúng định dạng abc@abc.abc");
    }

    public static void checkGenderCus(String sex) throws GenderException {
        String regex = "(Male|Female|Unknow)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(sex);
        if (!matcher.find()) throw new GenderException("Giới tính phải đúng định dạng Male|Female|Unknow");
    }

    public static void checkIdCardCus(String idCard) throws IdCardException {
        String regex = "(\\d{9})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(idCard);
        if (!matcher.find()) throw new IdCardException("Số CMND phải đúng định dạng XXX XXX XXX");
    }

    public static void checkBirthDay(String birthDay) throws BirthdayException {
        String regex = "^([0][1-9]|[12][0-9]|[3][01])/([0][1-9]|[1][012])/([2][0][0]([012])|[1][9]\\d{2})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(birthDay);
        if (!matcher.find())
            throw new BirthdayException("Số ngày sinh phải đúng định dạng dd/mm/yyyy và năm nhỏ hơn 2002");
    }

    public static void addCutomer() {
        boolean check = false;
        System.out.print("Nhập id customer: ");
        String id = scanner.nextLine();
        String nameCus = null;
        do {
            try {
                check = true;
                System.out.print("Nhập name customer:");
                nameCus = scanner.nextLine();
                checkNameCus(nameCus);
            } catch (NameException e) {
                System.err.println(e.getMessage());
                check = false;
            }
        } while (!check);

        String dateOfBirth = null;
        do {
            try {
                check = true;
                System.out.print("Nhập ngày sinh:");
                dateOfBirth = scanner.nextLine();
                checkBirthDay(dateOfBirth);
            } catch (BirthdayException e) {
                System.err.println(e.getMessage());
                check = false;
            }
        } while (!check);

        String sex = null;
        do {
            try {
                check = true;
                System.out.print("Nhập giới tính:");
                sex = scanner.nextLine();
                checkGenderCus(sex);
            } catch (GenderException e) {
                System.err.println(e.getMessage());
                check = false;
            }
        } while (!check);
        String identityCardNumber = null;
        do {
            try {
                check = true;
                System.out.print("Nhập số CMND:");
                identityCardNumber = scanner.nextLine();
                checkIdCardCus(identityCardNumber);
            } catch (IdCardException e) {
                System.err.println(e.getMessage());
                check = false;
            }
        } while (!check);

        System.out.print("Nhập số điện thoại:");
        int mumberPhone = Integer.parseInt(scanner.nextLine());
        String email = null;
        do {
            try {
                check = true;
                System.out.print("Nhập email:");
                email = scanner.nextLine();
                checkEmailCus(email);
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.print("Nhập loại khách:");
        String typeOfCustomer = scanner.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, nameCus, dateOfBirth, sex, Integer.parseInt(identityCardNumber), mumberPhone, email, typeOfCustomer, address, null);
        listCustomer.add(customer);
        String line = null;
        line = customer.getIdCustomer()
                + COMMA + customer.getNameCustomer()
                + COMMA + customer.getDateOfBirth()
                + COMMA + customer.getSex()
                + COMMA + customer.getIdentityCardNumber()
                + COMMA + customer.getNumberPhone()
                + COMMA + customer.getEmail()
                + COMMA + customer.getTypeOfCustomer()
                + COMMA + customer.getAddress()
                + COMMA + customer.getServices();
        FileUtils.writeFile(FILE_NAME_CUSTOMER, line);
    }

    public static void showInformationCustomers() {
        List<String> customerList = FileUtils.readFile(FILE_NAME_CUSTOMER);
        int index = 1;
        for (String customer : customerList) {
            String[] listSplit = customer.split(",");
            Customer customer1 = new Customer(listSplit[0], listSplit[1], listSplit[2]
                    , listSplit[3], Integer.parseInt(listSplit[4]),
                    Integer.parseInt(listSplit[5]), listSplit[6], listSplit[7], listSplit[8], null);
            listCustomer.add(customer1);
        }
        Collections.sort(listCustomer);
        for (Customer customer : listCustomer) {
            System.out.println(index++ + "\n" + customer);
        }

    }

    /**
     * END CUSTOMER
     **/
    /**
     * BOOKING
     **/

    public static void AddNewBooking() {
        showInformationCustomers();
        System.out.print("Vui lòng chọn khách hàng:");
        chooseTheCustomer = Integer.parseInt(scanner.nextLine());
        System.out.println("---------------------" + "\n" +
                "1.Booking Villa\n" +
                "2.Booking House\n" +
                "3.Booking Room\n"
                + "---------------------");
        System.out.print("Nhập chọn:");
        int input = Integer.parseInt(scanner.nextLine());
        switch (input) {
            case 1:
                BookingVilla();
                displayMenu();
                break;
            case 2:
                BookingHouse();
                displayMenu();
                break;
            case 3:
                BookingVRoom();
                displayMenu();
                break;

        }
    }

    public static void BookingVilla() {
        showAllVilla();
        System.out.print("Chọn villa bạn muốn đặt:");
        int chooseVilla = Integer.parseInt(scanner.nextLine());
        listCustomer.get(chooseTheCustomer - 1).setServices(listVilla.get(chooseVilla - 1));
        AddFileCus(chooseTheCustomer);
    }

    public static void BookingHouse() {
        showAllHouse();
        System.out.print("Chọn house bạn muốn đặt:");
        int chooseHouse = Integer.parseInt(scanner.nextLine());
        listCustomer.get(chooseTheCustomer - 1).setServices(listVilla.get(chooseHouse - 1));
        AddFileCus(chooseTheCustomer);
    }

    public static void BookingVRoom() {
        showAllRoom();
        System.out.print("Chọn room bạn muốn đặt:");
        int chooseRoom = Integer.parseInt(scanner.nextLine());
        listCustomer.get(chooseTheCustomer - 1).setServices(listVilla.get(chooseRoom - 1));
        AddFileCus(chooseTheCustomer);
    }

    public static void AddFileCus(int chooseTheCustomer) {
        String line;
        line = listCustomer.get(chooseTheCustomer - 1).getIdCustomer()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getNameCustomer()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getDateOfBirth()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getSex()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getIdentityCardNumber()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getNumberPhone()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getEmail()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getTypeOfCustomer()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getAddress()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getId()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getServiceName()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getAreaOfUse()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getRentalCosts()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getNumberOfPeopleMax()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getServices().getRentType();
        FileUtils.writeFile(FILE_NAME_BOOKING, line);
    }

    /**
     * END BOOKING
     **/
    public static void menuAdd() {
        System.out.println("-----------------------\n" +
                "1.\tAdd New Villa\n" +
                "2.\tAdd New House\n" +
                "3.\tAdd New Room\n" +
                "4.\tBack to menu\n" +
                "----------------------------"
        );
        System.out.print("Vui lòng chọn:");
        int inputNumber = Integer.parseInt(scanner.nextLine());
        switch (inputNumber) {
            case 1:
                addNewVilla();
                menuAdd();
                break;
            case 2:
                addNewHouse();
                menuAdd();
                break;
            case 3:
                addNewRoom();
                menuAdd();
                break;
            case 4:
                displayMenu();
                break;
            default:
                System.out.println("vui lòng nhập từ 1 - 4");
                break;

        }
    }
}
