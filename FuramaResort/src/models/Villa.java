package models;

public class Villa extends Services {
    private String standardRoom;
    private String comfortDescription;
    private double poolArea;
    private int numberOfFloors;

    public Villa(String standardRoom, String comfortDescription, double poolArea, int numberOfFloors) {
        this.standardRoom = standardRoom;
        this.comfortDescription = comfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa(String id, String serviceName, double areaOfUse, int rentalCosts, int numberOfPeopleMax, String rentType, String standardRoom, String comfortDescription, double poolArea, int numberOfFloors) {
        super(id, serviceName, areaOfUse, rentalCosts, numberOfPeopleMax, rentType);
        this.standardRoom = standardRoom;
        this.comfortDescription = comfortDescription;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public Villa() {

    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getComfortDescription() {
        return comfortDescription;
    }

    public void setComfortDescription(String comfortDescription) {
        this.comfortDescription = comfortDescription;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    @Override
    public String toString() {
        return super.toString() +
                "StandardRoom : " + standardRoom + "\n" +
                "ComfortDescription : " + comfortDescription + "\n" +
                "PoolArea : " + poolArea + "\n" +
                "NumberOfFloors : " + numberOfFloors + "\n";
    }

    @Override
    public void showInfor() {

        this.toString();
    }
}
