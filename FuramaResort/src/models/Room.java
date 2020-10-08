package models;

public class Room extends Services {
    private AccompaniedService accompaniedService;

    public Room() {
    }

    public Room(String id, String serviceName, double areaOfUse, int rentalCosts, int numberOfPeopleMax, String rentType, AccompaniedService accompaniedService) {
        super(id, serviceName, areaOfUse, rentalCosts, numberOfPeopleMax, rentType);
        this.accompaniedService = accompaniedService;
    }

    public AccompaniedService getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(AccompaniedService accompaniedService) {
        this.accompaniedService = accompaniedService;
    }


    @Override
    public void showInfor() {
        this.toString();
    }

    @Override
    public String toString() {
        return super.toString() + accompaniedService ;
    }
}