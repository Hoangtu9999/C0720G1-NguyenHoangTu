package models;

public abstract class Services {
    private String id;
    private String serviceName;
    private double areaOfUse;
    private int rentalCosts;
    private int numberOfPeopleMax;
    private String rentType;

    public Services(String id, String serviceName, double areaOfUse, int rentalCosts, int numberOfPeopleMax, String rentType) {
        this.id = id;
        this.serviceName = serviceName;
        this.areaOfUse = areaOfUse;
        this.rentalCosts = rentalCosts;
        this.numberOfPeopleMax = numberOfPeopleMax;
        this.rentType = rentType;
    }

    public Services() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getAreaOfUse() {
        return areaOfUse;
    }

    public void setAreaOfUse(double areaOfUse) {
        this.areaOfUse = areaOfUse;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumberOfPeopleMax() {
        return numberOfPeopleMax;
    }

    public void setNumberOfPeopleMax(int numberOfPeopleMax) {
        this.numberOfPeopleMax = numberOfPeopleMax;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public abstract void showInfor();


    @Override
    public String toString() {
        return "Id : " + id + "\n" +
                        "ServiceName : " + serviceName + "\n" +
                        "AreaOfUse : " + areaOfUse + "\n" +
                        "RentalCosts : " + rentalCosts + "\n" +
                        "NumberOfPeopleMax : " + numberOfPeopleMax + "\n" +
                        "RentType : " + rentType + "\n";
    }
}
