package models;

public class Customer implements Comparable<Customer> {
    private String idCustomer;
    private String nameCustomer;
    private String dateOfBirth;
    private String gender;
    private int identityCardNumber;
    private int numberPhone;
    private String email;
    private String typeOfCustomer;
    private String address;
    private Services services;

    public Customer(String idCustomer, String nameCustomer, String dateOfBirth, String gender, int identityCardNumber, int numberPhone, String email, String typeOfCustomer, String address, Services services) {
        this.idCustomer = idCustomer;
        this.nameCustomer = nameCustomer;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.identityCardNumber = identityCardNumber;
        this.numberPhone = numberPhone;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.services = services;
    }

    public Customer() {
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdentityCardNumber() {
        return identityCardNumber;
    }

    public void setIdentityCardNumber(int identityCardNumber) {
        this.identityCardNumber = identityCardNumber;
    }

    public int getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(int numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "IdCustomer : " + idCustomer + "\n" +
                "NameCustomer : " + nameCustomer + "\n" +
                "DateOfBirth : " + dateOfBirth + "\n" +
                "Sex : " + gender + "\n" +
                "IdentityCardNumber : " + identityCardNumber + "\n" +
                "NumberPhone : " + numberPhone + "\n" +
                "Email : " + email + "\n" +
                "TypeOfCustomer : " + typeOfCustomer + "\n" +
                "Address : " + address + "\n" +
                "Services : " + services + "\n";
    }

    public void showInfor() {
        System.out.println(this.toString());
    }

    @Override
    public int compareTo(Customer o) {
        int result = this.getNameCustomer().compareTo(o.getNameCustomer());
        if (result == 0) {
            result = this.getDateOfBirth().substring(6, 10).compareTo(o.getDateOfBirth().substring(6, 10));
        }
        return result;
    }
}
