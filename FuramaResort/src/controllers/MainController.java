package controllers;


import commons.*;
import models.*;

import java.util.*;

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
    public static ArrayList<Employee> listEmployeeArray = new ArrayList();
    public static Map<String, Employee> listEmployeeMap = new TreeMap<>();
    public static Queue<Customer> listQueue = new LinkedList<>();


    public static final String FILE_NAME_VILLA = "src/data/Villa.csv";
    public static final String FILE_NAME_HOUSE = "src/data/House.csv";
    public static final String FILE_NAME_ROOM = "src/data/Room.csv";
    public static final String FILE_NAME_CUSTOMER = "src/data/Customer.csv";
    public static final String FILE_NAME_BOOKING = "src/data/Booking.csv";
    public static final String FILE_NAME_EMPLOYEE = "src/data/Employee.csv";
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
        int choose = 1;
        do {
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
                    break;
                case 2:
                    showAllHouse();
                    break;
                case 3:
                    showAllRoom();
                    break;
                case 4:
                    showsListNameVilla();
                    break;
                case 5:
                    showsListNameHouse();
                    break;
                case 6:
                    showsListNameRoom();
                    break;
                case 7:
                    displayMenu();
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1 - 6");
                    break;
            }
        } while (choose >= 1 && choose <= 6);
    }
    /**
     ** END SERVICE
     **/


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

    public static void showsListNameVilla() {
        Set<String> listSet = new TreeSet<>();
        for (Villa villa : listVilla) {
            listSet.add(villa.getServiceName());
        }
        for (String string : listSet) {
            System.out.println(string);
        }
    }
    /**
     * END VILLA
     **/

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

    public static void showsListNameHouse() {
        Set<String> listSet = new TreeSet<>();
        for (House house : listHouse) {
            listSet.add(house.getServiceName());
        }
        for (String string : listSet) {
            System.out.println(string);
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
        String nameAccompanied;
        do {
            System.out.print("Nhập tên dịch vụ đi kèm:");
            nameAccompanied = scanner.nextLine();
            checkInputFreeServiceIncluded(nameAccompanied);
        } while (!checkInputFreeServiceIncluded(nameAccompanied));

        System.out.print("Nhập đơn vị:");
        String unit = scanner.nextLine();
        System.out.print("Nhập giá tiền:");
        int priceAccompanied = Integer.parseInt(scanner.nextLine());

        Room room = new Room(id, serviceName, Double.parseDouble(areaOfUse), rentalCosts, numberOfPeopleMax, rentType, new AccompaniedService(nameAccompanied, unit, priceAccompanied));
        listRoom.add(room);
        listService.add(room);

        String line = null;
        line = room.getId()
                + COMMA + room.getServiceName()
                + COMMA + room.getAreaOfUse()
                + COMMA + room.getRentalCosts()
                + COMMA + room.getNumberOfPeopleMax()
                + COMMA + room.getRentType()
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
                    listSplit[5], new AccompaniedService(listSplit[6], listSplit[7], Integer.parseInt(listSplit[8])));
            listRoom.add(room);
            System.out.println(index++ + "\n" + room);
        }
    }

    public static void showsListNameRoom() {
        Set<String> listSet = new TreeSet<>();
        for (Room room : listRoom) {
            listSet.add(room.getServiceName());
        }
        for (String string : listSet) {
            System.out.println(string);
        }
    }

    /**
     * END ROOM
     **/


    /**
     * CUSTOMER
     **/
    public static void checkNameCustomer(String name) throws NameException {
        String regex = "^[A-Z][a-z]+(\\s[A-Z][a-z]+)+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        if (!matcher.find()) throw new NameException("Tên Khách hàng phải in hoa ký tự đầu tiên trong mỗi từ");
    }

    public static void checkEmailCustomer(String email) throws EmailException {
        String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        if (!matcher.find()) throw new EmailException("Email phải đúng định dạng abc@abc.abc");
    }

    public static void checkGenderCustomer(String gender) throws GenderException {
        String regex = "(Male|Female|Unknow)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(gender);
        if (!matcher.find()) throw new GenderException("Giới tính phải đúng định dạng Male|Female|Unknow");
    }

    public static void checkIdCardCustomer(String idCard) throws IdCardException {
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
                checkNameCustomer(nameCus);
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

        String gender = null;
        do {
            try {
                check = true;
                System.out.print("Nhập giới tính:");
                gender = scanner.nextLine();
                checkGenderCustomer(gender);
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
                checkIdCardCustomer(identityCardNumber);
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
                checkEmailCustomer(email);
            } catch (EmailException e) {
                System.err.println(e.getMessage());
            }
        } while (!check);
        System.out.print("Nhập loại khách:");
        String typeOfCustomer = scanner.nextLine();
        System.out.print("Nhập địa chỉ:");
        String address = scanner.nextLine();

        Customer customer = new Customer(id, nameCus, dateOfBirth, gender, Integer.parseInt(identityCardNumber), mumberPhone, email, typeOfCustomer, address, null);
        listCustomer.add(customer);
        String line = null;
        line = customer.getIdCustomer()
                + COMMA + customer.getNameCustomer()
                + COMMA + customer.getDateOfBirth()
                + COMMA + customer.getGender()
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
    public static void exceptionIndexCusTomer(int choiceCustomer) throws IndexOutOfBoundsException {
        if (choiceCustomer < 1 || choiceCustomer > listCustomer.size())
            throw new IndexOutOfBoundsException("Vui lòng chọn trong danh sách");
    }
    public static void exceptionIndexVilla(int choiceCustomer) throws IndexOutOfBoundsException {
        if (choiceCustomer < 1 || choiceCustomer > listVilla.size())
            throw new IndexOutOfBoundsException("Vui lòng chọn trong danh sách");
    }
    public static void exceptionIndexHouse(int choiceCustomer) throws IndexOutOfBoundsException {
        if (choiceCustomer < 1 || choiceCustomer > listHouse.size())
            throw new IndexOutOfBoundsException("Vui lòng chọn trong danh sách");
    }
    public static void exceptionIndexRoom(int choiceCustomer) throws IndexOutOfBoundsException {
        if (choiceCustomer < 1 || choiceCustomer > listRoom.size())
            throw new IndexOutOfBoundsException("Vui lòng chọn trong danh sách");
    }

    public static void addNewBooking() {
        int choose = 1;
        do {
            boolean flag = false;
            do {
                try {
                    listCustomer = new ArrayList<>();
                    flag = true;
                    showInformationCustomers();
                    System.out.print("Vui lòng chọn khách hàng:");
                    chooseTheCustomer = Integer.parseInt(scanner.nextLine());
                    exceptionIndexCusTomer(chooseTheCustomer);
                } catch (IndexOutOfBoundsException e) {
                    flag = false;
                    System.err.println(e.getMessage());
                }
            } while (!flag);

            System.out.println("---------------------" + "\n" +
                    "1.Booking Villa\n" +
                    "2.Booking House\n" +
                    "3.Booking Room\n" +
                    "4.Back To Menu\n"
                    + "---------------------");
            System.out.print("Nhập chọn:");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    bookingVilla();
                    break;
                case 2:
                    bookingHouse();
                    break;
                case 3:
                    bookingRoom();
                    break;
                case 4:
                    displayMenu();
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1 -4");
                    break;

            }
        } while (choose >= 1 && choose <= 4);

    }

    public static void bookingVilla() {
        showAllVilla();
        int chooseVilla = 0;
        boolean flag = false;
        do {
            try {
                flag = true;
                System.out.print("Chọn villa bạn muốn đặt:");
                chooseVilla = Integer.parseInt(scanner.nextLine());
                exceptionIndexVilla(chooseVilla);
            } catch (IndexOutOfBoundsException e) {
                flag = false;
                System.err.println(e.getMessage());
            }
        } while (!flag);


        listCustomer.get(chooseTheCustomer - 1).setServices(listVilla.get(chooseVilla - 1));
        addFileCustomer(chooseTheCustomer);
        System.err.println("Thêm booking villa thành công");
        displayMenu();
    }

    public static void bookingHouse() {
        showAllHouse();
        int chooseHouse = 0;
        boolean flag = false;

        do {
            try {
                flag = true;
                System.out.print("Chọn villa bạn muốn đặt:");
                chooseHouse = Integer.parseInt(scanner.nextLine());
                exceptionIndexHouse(chooseHouse);
            } catch (IndexOutOfBoundsException e) {
                flag = false;
                System.err.println(e.getMessage());
            }
        } while (!flag);

        listCustomer.get(chooseTheCustomer - 1).setServices(listHouse.get(chooseHouse - 1));
        addFileCustomer(chooseTheCustomer);
        System.err.println("Thêm booking house thành công");
        displayMenu();
    }

    public static void bookingRoom() {
        showAllRoom();
        int chooseRoom = 0;
        boolean flag = false;
        do {
            try {
                flag = true;
                System.out.print("Chọn room bạn muốn đặt:");
                chooseRoom = Integer.parseInt(scanner.nextLine());

                exceptionIndexRoom(chooseRoom);
            } catch (IndexOutOfBoundsException e) {
                flag = false;
                System.err.println(e.getMessage());
            }
        } while (!flag);

        listCustomer.get(chooseTheCustomer - 1).setServices(listRoom.get(chooseRoom - 1));
        addFileCustomer(chooseTheCustomer);
        System.err.println("Thêm booking room thành công");
        displayMenu();
    }

    public static void addFileCustomer(int chooseTheCustomer) {
        String line;
        line = listCustomer.get(chooseTheCustomer - 1).getIdCustomer()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getNameCustomer()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getDateOfBirth()
                + COMMA + listCustomer.get(chooseTheCustomer - 1).getGender()
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


    /**
     * EMPLOYEE
     **/
    public static boolean checkLevel(String location) {
        String regex = "(Trung cấp|Cao đẳng|Đại học|Sau đại học)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(location);
        return matcher.find();
    }

    public static boolean checkLocation(String level) {
        String regex = "(Lễ tân|Phục vụ|Chuyên viên|Qiám sát|Quản lý|Giám đốc)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(level);
        return matcher.find();
    }

    public static void addEmployee() {
        System.out.print("Vui lòng nhập id:");
        String id = scanner.nextLine();
        System.out.print("Vui lòng nhập tên:");
        String name = scanner.nextLine();
        System.out.print("Vui lòng nhập ngày sinh:");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Vui lòng nhập CMND:");
        int idCard = Integer.parseInt(scanner.nextLine());
        System.out.print("Vui lòng nhập điện thoại:");
        int numberPhone = Integer.parseInt(scanner.nextLine());
        System.out.print("Vui lòng nhập email:");
        String email = scanner.nextLine();
        String academicLevel = null;
        do {
            System.out.print("Vui lòng nhập trình độ:");
            academicLevel = scanner.nextLine();
            checkLevel(academicLevel);
        } while (!checkLevel(academicLevel));
        String location;
        do {
            System.out.print("Vui lòng nhập vị trí:");
            location = scanner.nextLine();
            checkLocation(location);
        } while (!checkLocation(location));

        System.out.print("Vui lòng nhập lương:");
        int salary = Integer.parseInt(scanner.nextLine());

        Employee employee = new Employee(id, name, dateOfBirth, idCard, numberPhone, email, academicLevel, location, salary);
        listEmployeeArray.add(employee);

        String line = null;
        line = employee.getIdEmployee()
                + COMMA + employee.getNameEmployee()
                + COMMA + employee.getDateOfBirth()
                + COMMA + employee.getIdentityCardNumber()
                + COMMA + employee.getNumberOfPhone()
                + COMMA + employee.getEmail()
                + COMMA + employee.getAcademicLevel()
                + COMMA + employee.getLocation()
                + COMMA + employee.getSalary();
        FileUtils.writeFile(FILE_NAME_EMPLOYEE, line);
    }

    public static void showEmployee() {
        List<String> listEmployee = FileUtils.readFile(FILE_NAME_EMPLOYEE);
        for (String employee : listEmployee) {
            String[] split = employee.split(",");
            if (split.length != 1) {
                Employee employee1 = new Employee(split[0], split[1], split[2], Integer.parseInt(split[3]), Integer.parseInt(split[4])
                        , split[5], split[6], split[7], Integer.parseInt(split[8]));
                listEmployeeMap.put(split[0], employee1);
            }
        }

    }

    public static void showInformationOfEmployee() {
        showEmployee();
        for (String key : listEmployeeMap.keySet()) {
            System.out.println(key + " " + listEmployeeMap.get(key));
        }
    }


    /**
     * END EMPLOYEE
     **/


    /**
     * MOVIE 4D
     **/
    public static void menuShow4DMovieViewers() {
        int choose = 1;
        do {
            System.out.println("----------------------" + "\n"
                    + "1.Mua vé" + "\n"
                    + "2.Danh sách mua vé" + "\n"
                    + "3.Back to menu" + "\n"
                    + "--------------------------");
            System.out.print("Nhập chọn:");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    showInformationCustomers();
                    buyMovieTickets();
                    break;
                case 2:
                    show4DMovieViewers();

                    break;
                case 3:
                    displayMenu();
                    break;
                default:
                    System.out.println("Vui lòng chọn từ 1 - 3");
                    break;

            }
        } while (choose >= 1 && choose <= 3);
    }

    public static void buyMovieTickets() {
        try {
            System.out.print("Vui lòng chọn khách hàng:");
            int chooseTheCustomer = Integer.parseInt(scanner.nextLine());
            listQueue.add(listCustomer.get(chooseTheCustomer - 1));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Vui lòng chọn trong danh sách");
        }

    }

    public static void show4DMovieViewers() {
        int size = listQueue.size();
        if (size == 0) {
            System.err.println("Chưa có khách hàng nào");
        }
        for (int i = 0; i < size; i++) {
            System.out.println(listQueue.poll().getNameCustomer());
        }
    }
    /**
     * END MOVIE 4D
     *
     **/

    /**
     * MENU
     **/
    public static void displayMenu() {
        int choose = 1;
        do {
            System.out.println("---------------------------" + "\n"
                    + "1.Add New Services" + "\n"
                    + "2.Show Services" + "\n"
                    + "3.Add New Customer" + "\n"
                    + "4.Show Information of Customer" + "\n"
                    + "5.Add New Booking" + "\n"
                    + "6.Add New Employee" + "\n"
                    + "7.Show Information of Employee" + "\n"
                    + "8.Show 4D Movie Viewers" + "\n"
                    + "9.Search Profile Employee" + "\n"
                    + "10.Exit" + "\n"
                    + "---------------------------");
            System.out.print("Vui lòng chọn:");
            int input = Integer.parseInt(scanner.nextLine());
            switch (input) {
                case 1:
                    menuAdd();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addCutomer();
                    break;
                case 4:
                    showInformationCustomers();
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    addEmployee();
                    break;
                case 7:
                    showInformationOfEmployee();
                    break;
                case 8:
                    menuShow4DMovieViewers();
                    break;
                case 9:
                    FilingCabinets.employeeProfileSearch();
                    break;
                default:
                    System.out.println("Vui lòng nhập từ 1-9");
                    break;
            }
        } while (choose >= 1 && choose <= 9);
    }

    public static void menuAdd() {
        int choose = 1;
        do {
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
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    displayMenu();
                    break;
                default:
                    System.out.println("vui lòng nhập từ 1 - 4");
                    break;
            }
        } while (choose >= 1 && choose <= 4);

    }
    /**
     * END MENU
     **/
}
